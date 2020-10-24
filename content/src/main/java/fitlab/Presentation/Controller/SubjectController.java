package fitlab.Presentation.Controller;

import fitlab.BussinessLogic.Logic.SubjectLogic;
import fitlab.Data.Model.ContentType;
import fitlab.Data.Model.Subject;
import org.springframework.beans.factory.annotation.Autowired;
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

    /**
     * The method is used to show a subject page
     * @param subject This is the subject name from the link
     * @param model This is a variable used by the framework
     * @return This returns a page of the subject
     */
    @RequestMapping("/subjects/{subject}")
    public String subjectPage(@PathVariable String subject, Model model) {
        Subject sub1 = sub.SearchSubjects(subject);

        if(sub1 != null) {
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
    @PostMapping(value = "/subjects/{subject}", params = {"description"})
    public String EditDescription(@PathVariable String subject, @RequestParam String description, Model model) {
        if(description.length() == 0) {
            Subject sub1 = sub.SearchSubjects(subject);
            String s = "Enter text before editing";
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
    @PostMapping(value = "/subjects/{subject}")
    public String AddPage(@PathVariable String subject, @RequestParam String title,@RequestParam String type, Model model) {
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
        model.addAttribute("subject",sub1);
        model.addAttribute("contents",sub1.getContentList());
        return "subject";

    }





}
