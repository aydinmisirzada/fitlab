package fitlab.BussinessLogic;

import fitlab.Model.Teacher;
import fitlab.Repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;

@Service
public class TeacherLogic {
    @Autowired
    TeacherRepository repo;

    public String GetTeachersList(Model model) {
        List<Teacher> teachers =  repo.findAll();
        model.addAttribute("teacher", teachers);
        return "teachers";
    }


    public void addTeacher(String name, String surname, String username, Model model) {
        repo.save(new Teacher(name,surname,username));
    }

    public void delTeacher(int  id) {
        repo.delete(repo.getOne(id));
    }
}
