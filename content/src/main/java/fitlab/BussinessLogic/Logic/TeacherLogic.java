package fitlab.BussinessLogic.Logic;

import fitlab.BussinessLogic.Interfaces.TeacherLogicConf;
import fitlab.Data.Model.Teacher;
import fitlab.Data.Repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;

@Service
public class TeacherLogic implements TeacherLogicConf {
    @Autowired
    TeacherRepository repo;

    public List<Teacher> GetTeachersList() {
        return repo.findAll();
    }


    public void addTeacher(String name, String surname, String username) {
        repo.save(new Teacher(name,surname,username));
    }

    public void delTeacher(int  id) {
        repo.delete(repo.getOne(id));
    }
}
