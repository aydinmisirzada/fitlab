package fitlab.BussinessLogic.Logic;

import fitlab.BussinessLogic.Interfaces.TeacherLogicConf;
import fitlab.Data.Model.*;
import fitlab.Data.Repository.ReviewRepository;
import fitlab.Data.Repository.TeacherRepository;
import fitlab.Data.Repository.UserRepository;
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
    @Autowired
    ReviewRepository rev;
    @Autowired
    UserRepository user;
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

    public void addRating(int id, int rate, String text, String username) {
        Review r = new Review(rate, text,user.findByUsername(username).get(),repo.findById(id));
        rev.save(r);
        repo.findById(id).addReview(r);
        repo.save(repo.findById(id));
    }

    public List<Review> getReviews(int id) {
        return repo.findById(id).getReviewList();
    }

    public Teacher getTeacher(int id) {
        return  repo.findById(id);

    }

}
