package fitlab.Controller;

import fitlab.Model.Subject;
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

    @RequestMapping("/subjects/{subject}")
    public String Search(@PathVariable String subject, Model model) {
        Subject sub = repo.findByCode(subject);

        if(subject != null) {
            model.addAttribute("subject",sub);
        }

        return "subject";
    }


}
