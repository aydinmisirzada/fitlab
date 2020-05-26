package fitlab.Controller;

import fitlab.BussinessLogic.Logic.SubjectLogic;
import fitlab.Data.Model.Semester;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class MainPageController {

    @Autowired
    SubjectLogic s_repo;

    @GetMapping("/subjects")
    public String Search(Model model) {
        model.addAttribute("subject", s_repo.SearchList());
        return "subjects";
    }


    @PostMapping("/subjects")
    public String add(@RequestParam String code, @RequestParam String name, @RequestParam Semester semester) {
        s_repo.addSubject(code, name, semester);
        return "redirect:/subjects";
    }


    @PostMapping(value = "/subjects" , params = "id")
    public String delSubjects(@RequestParam int  id) {
        s_repo.delSubject(id);
        return "redirect:/subjects";
    }

}
