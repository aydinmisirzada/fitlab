package fitlab.BussinessLogic.Logic;

import fitlab.BussinessLogic.Interfaces.SubjectLogicConf;
import fitlab.Data.Model.*;
import fitlab.Data.Repository.ReviewRepository;
import fitlab.Data.Repository.SubjectRepository;
import fitlab.Data.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SubjectLogic implements SubjectLogicConf {
    @Autowired
    SubjectRepository repo;
    @Autowired
    UserRepository userRepository;
    @Autowired
    ContentLogic con;
    @Autowired
    UsersLogic usersLogic;
    @Autowired
    ReviewRepository rev;
    @Autowired
    UserRepository user;

    public Subject SearchSubjects(String subject) {
        if(repo.findByCode(subject) == null)
            throw new IllegalArgumentException("Subject code is invaild");
        return repo.findByCode(subject);
    }

    public Subject SubjectEditDescription( String subject, String description) {
        if(repo.findByCode(subject) == null)
            throw new IllegalArgumentException("Subject code is invaild");
        Subject  sub = repo.findByCode(subject);
        sub.setDescription(description);
        repo.save(sub);
        return  sub;
    }


    public Subject SubjectAddPage(String subject, String title, ContentType type) {
        if(repo.findByCode(subject) == null)
            throw new IllegalArgumentException("Subject code is invaild");
        Subject  sub = repo.findByCode(subject);
        con.addContent(title,type,sub);
        repo.save(sub);
        return sub;
    }

    public List<Subject> SearchList() {
        return repo.findAll();
    }

    public void addSubject(String code,String name, Semester semester) {
        if(code.length() == 0 || name.length() == 0)
            throw new IllegalArgumentException("Subject info is invaild");
        repo.save(new Subject(code,name,semester));
    }


    public void delSubject(int  id) {
        if(repo.findById(id) == null)
            throw new IllegalArgumentException("Subject id is invaild");

        Subject subject = repo.findById(id);
        List<Content> contents = subject.getContentList();
        for (int i = 0; i < contents.size(); i++)  {
            con.delContent(contents.get(i));
        }
        List<User> users = subject.getUsers();

        for (int i = 0; i < users.size(); i++) {
            usersLogic.delAssignment(users.get(i),id);
        }

        for (Review review :subject.getReviewList())
            rev.delete(review);

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

    public void editSubjectDetails(int id,String code, String name,int semester){
        if(repo.findById(id) == null)
            throw new IllegalArgumentException("Subject id is invaild");
        if(semester == 0)
            repo.findById(id).setSemester(Semester.SUMMER);
        else if(semester == 1)
            repo.findById(id).setSemester(Semester.WINTER);
        else if( semester == 2)
            repo.findById(id).setSemester(Semester.WINTER_SUMMER);
        else
            throw new IllegalArgumentException("Semester enum doesn't exist");
        repo.findById(id).setCode(code);
        repo.findById(id).setName(name);
        repo.save(repo.findById(id));
    }

    public void assignSubject(String username, String subject) {
        Optional<User> u = userRepository.findByUsername(username);

        if(u.equals(Optional.empty()))
            return;

        User user = u.get();
        Subject sub = repo.findByCode(subject);
        if(sub == null)
            throw new IllegalArgumentException("Subject id is invaild");
        sub.AddUser(user);
        user.AddSubject(sub);
        repo.save(sub);
        userRepository.save(user);
    }

    public boolean assignedSubejct(Subject sub,String username) {
        Optional<User> tmp = userRepository.findByUsername(username);
        if(tmp.equals(Optional.empty())) {
            return false;
        }
        for ( User u : sub.getUsers()) {
            if ( u.equals(tmp.get())) {
                return  true;
            }
        }
        return false;
    }

    public void addRating(String code, int rate, String text, String username) {
        if(user.findByUsername(username).get() == null)
            throw new IllegalArgumentException("User with such username doesn't exist");
        Review r = new Review(rate, text,user.findByUsername(username).get(),repo.findByCode(code));
        rev.save(r);
        repo.findByCode(code).addReview(r);
        repo.save(repo.findByCode(code));
    }

    public List<Review> getReviews(String code) {
        return repo.findByCode(code).getReviewList();
    }

    public void editRating (String code, int rate, String text, String username) {
        Subject subject = repo.findByCode(code);
        if(subject == null)
            throw new IllegalArgumentException("Subject code is invaild");
        List<Review> reviewList = subject.getReviewList();
        for(int i = 0; i < reviewList.size(); i++) {
            if(reviewList.get(i).getUser().getUsername().equals(username)) {
                reviewList.get(i).setRating(rate);
                reviewList.get(i).setText(text);
                rev.save(reviewList.get(i));
                repo.save(subject);
                break;
            }
        }
    }

/*    public List<Subject> getSubjectsMain () {
        List<Subject> subs = new ArrayList<Subject>();
        if(repo.findAll().size() > 3) {
            subs.add(repo.getOne(0));
            subs.add(repo.getOne(1));
            subs.add(repo.getOne(2));
        }
        return  subs;
    }*/

}
