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


@Controller
public class SubjectController {
    @Autowired
    SubjectLogic sub;

    @RequestMapping("/subjects/{subject}")
    public String subjectPage(@PathVariable String subject, Model model) {
        Subject sub1 = sub.SearchSubjects(subject);

        if(sub1 != null) {
            model.addAttribute("subject",sub1);
            model.addAttribute("content",sub1.getContentList());
            return "subject";
        } else {
            return "errorpage";
        }
    }

    @PostMapping(value = "/subjects/{subject}", params = {"description"})
    public String EditDescription(@PathVariable String subject, @RequestParam String description, Model model) {
        Subject sub1 = sub.SubjectEditDescription(subject,description);
        model.addAttribute("subject",sub1);
        model.addAttribute("content",sub1.getContentList());
        return "subject";
    }

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
            default:
                return "errorpage";
        }
        Subject sub1 = sub.SubjectAddPage(subject,title,Type);
        model.addAttribute("subject",sub1);
        model.addAttribute("content",sub1.getContentList());
        return "subject";

    }



}
