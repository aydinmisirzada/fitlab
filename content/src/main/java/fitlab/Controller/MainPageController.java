package fitlab.Controller;

import fitlab.Model.Semester;
import fitlab.Model.Subject;
import fitlab.Repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class MainPageController {

    @Autowired
    SubjectRepository repo;


    @GetMapping("/subjects")
    public String Search(Model model) {
        List<Subject> subjects =  repo.findAll();
        model.addAttribute("subject", subjects);
        return "subjects";
    }


    @PostMapping("/subjects")
    public String add(@RequestParam String code, @RequestParam String name, @RequestParam Semester semester, Model model) {
        repo.save(new Subject(code,name,semester));
        List<Subject> subjects =  repo.findAll();
        model.addAttribute("subject", subjects);
        return "subjects";
    }


}
