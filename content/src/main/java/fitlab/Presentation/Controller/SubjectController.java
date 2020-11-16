package fitlab.Presentation.Controller;

import fitlab.BussinessLogic.Logic.ContentLogic;
import fitlab.BussinessLogic.Logic.SubjectLogic;
import fitlab.BussinessLogic.Logic.UsersLogic;
import fitlab.Data.Model.ContentType;
import fitlab.Data.Model.Subject;
import fitlab.Data.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

//The class controls subject page
@Controller
public class SubjectController {
    @Autowired
    SubjectLogic sub;
    @Autowired
    ContentLogic con;
    @Autowired
    UsersLogic usersLogic;
    /**
     * The method is used to show a subject page
     * @param subject This is the subject name from the link
     * @param model This is a variable used by the framework
     * @return This returns a page of the subject
     */
    @RequestMapping("/subjects/{subject}")
    public String subjectPage(@PathVariable String subject, Model model, Authentication auth) {
        Subject sub1 = sub.SearchSubjects(subject);


        if(sub1 != null) {
            boolean tmp = sub.assignedSubejct(sub1, auth.getName());
            model.addAttribute("assigned", tmp);
            model.addAttribute("subject",sub1);
            model.addAttribute("contents",sub1.getContentList());
            model.addAttribute("error","");
            return "subject";
        } else {
            return "errorpage";
        }
    }

    /**
     * The method is used to edit a description of the subject
     * @param subject This is the subject name from the link
     * @param description This is a descriptionof the subject
     * @param model This is a variable used by the framework
     * @return This returns a page of the subject
     */
    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping(value = "/subjects/{subject}", params = {"description"})
    public String EditDescription(@PathVariable String subject, @RequestParam String description, Model model, Authentication auth) {
        if(description.length() == 0) {
            Subject sub1 = sub.SearchSubjects(subject);
            String s = "Enter text before editing";
            boolean tmp = sub.assignedSubejct(sub1, auth.getName());
            model.addAttribute("assigned", tmp);
            model.addAttribute("error", s);
            model.addAttribute("subject",sub1);
            model.addAttribute("contents",sub1.getContentList());

            return "subject";
        }
        sub.SubjectEditDescription(subject,description);

        return "redirect:/subjects/" + subject;
    }

    /**
     * The method is used to add a content page of the subject
     * @param subject This is the subject name from the link
     * @param title This is the title from the link
     * @param type This isa type of the page
     * @param model This is a variable used by the framework
     * @return This returns a page of the subject
     */
    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping(value = "/subjects/{subject}", params = {"title", "type"})
    public String AddPage(@PathVariable String subject, @RequestParam String title,@RequestParam String type, Model model, Authentication auth) {
        if(title.isEmpty()) return "errorpage";
        ContentType Type = ContentType.HOMEWORK;
        switch (type) {
            case "HOMEWORK":
                Type = ContentType.HOMEWORK;break;
            case "TEST":
                Type = ContentType.TEST;break;
            case "EXAM":
                Type = ContentType.EXAM;break;
            case "REVIEW":
                break;
            default:
                return "errorpage";
        }
        Subject sub1 = sub.SubjectAddPage(subject,title,Type);
        boolean tmp = sub.assignedSubejct(sub1, auth.getName());
        model.addAttribute("assigned", tmp);
        model.addAttribute("subject",sub1);
        model.addAttribute("contents",sub1.getContentList());
        model.addAttribute("error","");
        return "subject";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping(value = "subjects/{subject}", params = {"title", "id"})
    public String editContent(@PathVariable String subject, @RequestParam String title, @RequestParam int id) {
        if(title.isEmpty()) return "errorpage";
        con.changeTitle(id,title);
        return "redirect:/subjects/" + subject;
    }


    @PostMapping(value = "subjects/{subject}/addAssignment")
    public String AddAssignment1(@PathVariable String subject, Authentication auth) {
        sub.assignSubject(auth.getName(),subject);
        return "redirect:/subjects/" + subject;
    }

    @PostMapping(value = "subjects/{subject}/delAssignment")
    public String delAssignment1(@PathVariable String subject, Authentication auth) {
        User u = usersLogic.getUser(auth.getName());
        Subject sub1 = sub.SearchSubjects(subject);
        usersLogic.delAssignment(u,sub1.getId());
        return "redirect:/subjects/" + subject;
    }



}
