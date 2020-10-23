package fitlab.BussinessLogic.Logic;

import fitlab.BussinessLogic.Interfaces.SubjectLogicConf;
import fitlab.Data.Model.Content;
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
        Subject subject = repo.findById(id);
        List<Content> contents = subject.getContentList();
        for (int i = 0; i < contents.size(); i++)  {
            con.delContent(contents.get(i));
        }
        repo.delete(repo.findById(id));
    }

    public Boolean subDuplicate(String code,String name) {
        return (repo.findByName(name) == null && repo.findByCode(code) == null);
    }

    public int averageRating( List<Integer> ratings ) {
        int x = 0;
        for (Integer rat : ratings) {
            x += rat;
        }
        x /= ratings.size();
        return x;
    }
}
