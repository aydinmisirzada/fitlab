package fitlab.Presentation.Controller;

import fitlab.BussinessLogic.Logic.SubjectLogic;
import fitlab.Data.Model.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Controller
public class MainPageController {
    @Autowired
    SubjectLogic sub_repo;

    @GetMapping("/")
    public String getMain(Model model){
        List<Subject> subs =  sub_repo.SearchList();
        subs.sort(Comparator.comparingInt(Subject::averageRating));
        Collections.reverse(subs);
        model.addAttribute("subjectSet",subs);
        return "index";
    }

}
