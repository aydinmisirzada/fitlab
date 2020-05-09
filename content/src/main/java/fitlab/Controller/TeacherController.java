package fitlab.Controller;

import fitlab.BussinessLogic.TeacherLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class TeacherController {
    @Autowired
    TeacherLogic t_repo;

    @GetMapping("/teachers")
    public String TeachersList(Model model) {
        return t_repo.GetTeachersList(model);
    }

    @PostMapping(value = "/teachers", params = {"name","surname","username"})
    public String addTeachers(@RequestParam String name, @RequestParam String surname, @RequestParam String username, Model model) {
        t_repo.addTeacher(name, surname, username, model);
        return "redirect:/teachers";
    }

    @PostMapping(value = "/teachers" , params = "id")
    public String delTeacher(@RequestParam int  id) {
        t_repo.delTeacher(id);
        return "redirect:/teachers";
    }

}
