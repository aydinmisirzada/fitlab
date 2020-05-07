package fitlab.Controller;

import fitlab.Model.Semester;
import fitlab.Model.Subject;
import fitlab.Model.Teacher;
import fitlab.Repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class TeacherController {
    @Autowired
    TeacherRepository repo;

    @GetMapping("/teachers")
    public String TeachersList(Model model) {
        List<Teacher> teachers =  repo.findAll();
        model.addAttribute("teacher", teachers);
        return "teachers";
    }

    @PostMapping("/teachers")
    public String addTeachers(@RequestParam String name, @RequestParam String surname, @RequestParam String username, Model model) {
        repo.save(new Teacher(name,surname,username));
        return "redirect:/teachers";
    }

    @PostMapping(value = "/teachers" , params = "id")
    public String delTeacher(@RequestParam int  id, Model model) {
        repo.delete(repo.getOne(id));
        return "redirect:/teachers";
    }

}
