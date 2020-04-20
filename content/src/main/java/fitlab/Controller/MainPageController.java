package fitlab.Controller;

import fitlab.Model.Subject;
import fitlab.Repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class MainPageController {

    @Autowired
    SubjectRepository repo;


    @RequestMapping("/subjects")
    public String Search(Model model) {
        List<Subject> subjects =  repo.findAll();
        model.addAttribute("subject", subjects);
        return "subjects";
    }
}
