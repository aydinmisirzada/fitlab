package fitlab.BussinessLogic.Logic;

import fitlab.BussinessLogic.Interfaces.SubjectLogicConf;
import fitlab.Data.Model.ContentType;
import fitlab.Data.Model.Semester;
import fitlab.Data.Model.Subject;
import fitlab.Data.Repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;

@Service
public class SubjectLogic implements SubjectLogicConf {
    @Autowired
    SubjectRepository repo;
    @Autowired
    ContentLogic con;
    public Subject SearchSubjects(String subject) {
        return repo.findByCode(subject);
    }

    public Subject SubjectEditDescription( String subject, String description) {
        Subject  sub = repo.findByCode(subject);
        sub.setDescription(description);
        repo.save(sub);
        return  sub;
    }


    public Subject SubjectAddPage(String subject, String title, ContentType type) {

        Subject  sub = repo.findByCode(subject);
        con.addContent(title,type,sub);
        repo.save(sub);
        return sub;

    }

    public List<Subject> SearchList() {
        return repo.findAll();
    }

    public void addSubject(String code,String name, Semester semester) {
        repo.save(new Subject(code,name,semester));
    }


    public void delSubject(int  id) {
        repo.delete(repo.getOne(id));
    }

}
