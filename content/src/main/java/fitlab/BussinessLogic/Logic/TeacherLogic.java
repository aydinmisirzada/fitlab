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
    ReviewRepository rev;
    @Autowired
    UserRepository user;
    public List<Teacher> GetTeachersList() {
        return repo.findAll();
    }


    public void addTeacher(String name, String surname, String username) {
        Teacher tec = new Teacher(name,surname,username);
        repo.save(tec);
    }
    public void delTeacher(int  id) {

        Teacher teacher = repo.findById(id);
        if(teacher == null)
            throw new IllegalArgumentException("Teacher id is invaild");
        for (Review review :teacher.getReviewList())
            rev.delete(review);

        repo.delete(repo.getOne(id));
    }

    public Boolean tecDuplicate(String username) {
        return (repo.findByUsername(username) == null);
    }

    public Teacher SearchTeacher(int id) {
        return repo.findById(id);
    }

    public void addRating(int id, int rate, String text, String username) {
        if(repo.findById(id) == null)
            throw new IllegalArgumentException("Teacher id is invaild");
        Review r = new Review(rate, text,user.findByUsername(username).get(),repo.findById(id));
        rev.save(r);
        repo.findById(id).addReview(r);
        repo.save(repo.findById(id));
    }

    public List<Review> getReviews(int id) {
        return repo.findById(id).getReviewList();
    }

    public Teacher getTeacher(int id) {
        if(repo.findById(id) == null)
            throw new IllegalArgumentException("Teacher id is invaild");
        return  repo.findById(id);
    }

    public boolean  findDup( int id, String username ) {
        User u = user.findByUsername(username).get();
        List<Review> rev = repo.findById(id).getReviewList();

        for (Review r : rev) {
            if(r.getUser().getUsername() == u.getUsername()) return false;
        }

        return true;
    }

    public void editTeacherDetails(int id,String name, String surname, String username){
        if(repo.findById(id) == null)
            throw new IllegalArgumentException("Teacher id is invaild");
        repo.findById(id).setName(name);
        repo.findById(id).setSurname(surname);
        repo.findById(id).setUsername(username);
        repo.save(repo.findById(id));
    }


    public void editRating (int id, int rate, String text, String username) {
        Teacher teacher = repo.findById(id);
        if(teacher == null)
            throw new IllegalArgumentException("Teacher id is invaild");
        List<Review> reviewList = teacher.getReviewList();
        for(int i = 0; i < reviewList.size(); i++) {
            if(reviewList.get(i).getUser().getUsername().equals(username)) {
                reviewList.get(i).setRating(rate);
                reviewList.get(i).setText(text);
                rev.save(reviewList.get(i));
                repo.save(teacher);
                break;
            }
        }
    }


}
