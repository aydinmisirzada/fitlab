package fitlab.Controller;

import fitlab.BussinessLogic.Logic.TeacherLogic;
import fitlab.Data.Model.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Controller
public class TeacherController {
    @Autowired
    TeacherLogic t_repo;

    @GetMapping("/teachers")
    public String TeachersList(Model model) {
        List<Teacher> teachers = t_repo.GetTeachersList();;
        model.addAttribute("teacher", teachers);
        return "teachers";
    }

    @PostMapping(value = "/teachers", params = {"name","surname","username"})
    public String addTeachers(@RequestParam String name, @RequestParam String surname, @RequestParam String username) {
        t_repo.addTeacher(name, surname, username);
        return "redirect:/teachers";
    }

    @PostMapping(value = "/teachers" , params = "id")
    public String delTeacher(@RequestParam int  id) {
        t_repo.delTeacher(id);
        return "redirect:/teachers";
    }

}
