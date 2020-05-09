package fitlab.BussinessLogic;

import fitlab.Model.ContentType;
import fitlab.Model.Subject;
import fitlab.Repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
public class SubjectLogic {
    @Autowired
    SubjectRepository repo;
    @Autowired
    ContentLogic con;
    public String SearchSubjects(String subject, Model model) {
        Subject sub = repo.findByCode(subject);

        if(sub != null) {
            model.addAttribute("subject",sub);
            model.addAttribute("content",sub.getContentList());
            return "subject";
        } else {
            return "errorpage";
        }
    }

    public String SubjectEditDescription( String subject, String description, Model model) {
        Subject  sub = repo.findByCode(subject);
        sub.setDescription(description);
        repo.save(sub);
        model.addAttribute("subject",sub);
        model.addAttribute("content",sub.getContentList());
        return "subject";
    }


    public String SubjectAddPage(String subject, String title, String type, Model model) {
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
        Subject  sub = repo.findByCode(subject);
        con.addContent(title,Type,sub);
        repo.save(sub);
        model.addAttribute("subject",sub);
        model.addAttribute("content",sub.getContentList());
        return "subject";
    }


}
