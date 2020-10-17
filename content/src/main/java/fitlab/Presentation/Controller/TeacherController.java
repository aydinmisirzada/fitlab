package fitlab.Presentation.Controller;

import fitlab.BussinessLogic.Logic.TeacherLogic;
import fitlab.Data.Model.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//The class controls teacher list
@Controller
public class TeacherController {
    @Autowired
    TeacherLogic t_repo;

    /**
     * This method is used to show a page with list of teachers
     *
     * @param model This is a variable used by the framework
     * @return This returns a name of html page
     */
    @GetMapping("/teachers")
    public String TeachersList(Model model) {
        List<Teacher> teachers = t_repo.GetTeachersList();
        model.addAttribute("teacher", teachers);
        return "teachers";
    }

    /**
     * This method is used to add a teacher to the database
     *
     * @param name     This is a name of the teacher
     * @param surname  This is a name of the teacher
     * @param username This is a name of the teacher
     * @return This returns a name of html page
     */
    @PostMapping(value = "/teachers", params = {"name", "surname", "username"})
    public String addTeachers(@RequestParam String name, @RequestParam String surname, @RequestParam String username) {
        if (!t_repo.tecDuplicate(username) || name.isEmpty() || surname.isEmpty() || username.isEmpty())
            return "errorpage";
        t_repo.addTeacher(name, surname, username);
        return "redirect:/teachers";
    }

    /**
     * This method is used to delete a teacher to the database
     *
     * @param id This is id of the teacher
     * @return This returns a name of html page
     */
    @PostMapping(value = "/teachers", params = "id")
    public String delTeacher(@RequestParam int id) {
        t_repo.delTeacher(id);
        return "redirect:/teachers";
    }

    @RequestMapping("/teachers/{id}")
    public String teacherPage(@PathVariable int id, Model model) {
        Teacher teacher = t_repo.SearchTeacher(id);
        if(teacher == null)
            return "errorpage";
        model.addAttribute("teacher",teacher);
        return "teacher_page";
    }


}
