package fitlab.Controller;

import fitlab.Model.Content;
import fitlab.Model.ContentType;
import fitlab.Model.Subject;
import fitlab.Repository.ContentRepository;
import fitlab.Repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class SubjectController {
    @Autowired
    SubjectRepository repo;
    @Autowired
    ContentRepository con_repo;

    @RequestMapping("/subjects/{subject}")
    public String Search(@PathVariable String subject, Model model) {
        Subject sub = repo.findByCode(subject);

        if(subject != null) {
            model.addAttribute("subject",sub);
            model.addAttribute("content",sub.getContentList());
        }

        return "subject";
    }

    @PostMapping(value = "/subjects/{subject}", params = {"description"})
    public String EditDescription(@PathVariable String subject, @RequestParam String description, Model model) {
        Subject  sub = repo.findByCode(subject);
        sub.setDescription(description);
        repo.save(sub);
        model.addAttribute("subject",sub);
        model.addAttribute("content",sub.getContentList());
        return "subject";
    }

    @PostMapping(value = "/subjects/{subject}")
    public String AddHomework(@PathVariable String subject, @RequestParam(required = false) String title,@RequestParam String type, Model model) {
        ContentType Type = ContentType.HOMEWORK;
        switch (type) {
            case "HOMEWORK":
                Type = ContentType.HOMEWORK;break;
            case "TEST":
                Type = ContentType.TEST;break;
            case "EXAM":
                Type = ContentType.EXAM;break;
            default:
                break;
        }
        Subject  sub = repo.findByCode(subject);
        Content con = new Content(title, Type);
        con.setSubject(sub);
        con_repo.save(con);
        repo.save(sub);
        model.addAttribute("subject",sub);
        model.addAttribute("content",sub.getContentList());
        return "subject";
    }



}
