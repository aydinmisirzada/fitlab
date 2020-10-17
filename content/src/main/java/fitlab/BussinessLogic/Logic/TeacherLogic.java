package fitlab.BussinessLogic.Logic;

import fitlab.BussinessLogic.Interfaces.TeacherLogicConf;
import fitlab.Data.Model.Content;
import fitlab.Data.Model.ContentType;
import fitlab.Data.Model.Subject;
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
    @Autowired
    ContentLogic con;
    public List<Teacher> GetTeachersList() {
        return repo.findAll();
    }


    public void addTeacher(String name, String surname, String username) {
        Teacher tec = new Teacher(name,surname,username);
        repo.save(tec);
        con.addContent("Review",ContentType.REVIEW,tec);
        repo.save(tec);
    }
    public Content getContent(int id){return repo.findById(id).getContent();}
    public void delTeacher(int  id) {

        Teacher teacher = repo.findById(id);
        Content content = teacher.getContent();
        con.delContent(content);
 
        repo.delete(repo.getOne(id));
    }

    public Boolean tecDuplicate(String username) {
        return (repo.findByUsername(username) == null);
    }

    public Teacher SearchTeacher(int id) {
        return repo.findById(id);
    }



}
