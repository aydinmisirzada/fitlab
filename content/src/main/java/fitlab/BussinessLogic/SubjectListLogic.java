package fitlab.BussinessLogic;

import fitlab.Model.Semester;
import fitlab.Model.Subject;
import fitlab.Repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectListLogic {
    @Autowired
    SubjectRepository repo;

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
