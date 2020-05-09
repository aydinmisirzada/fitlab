package fitlab.Controller;

import fitlab.BussinessLogic.SubjectLogic;
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
    public String Search(@PathVariable String subject, Model model) {
        return sub.SearchSubjects(subject,model);
    }

    @PostMapping(value = "/subjects/{subject}", params = {"description"})
    public String EditDescription(@PathVariable String subject, @RequestParam String description, Model model) {
        return sub.SubjectEditDescription(subject,description,model);
    }

    @PostMapping(value = "/subjects/{subject}")
    public String AddPage(@PathVariable String subject, @RequestParam String title,@RequestParam String type, Model model) {
        return sub.SubjectAddPage(subject,title,type,model);
    }



}
