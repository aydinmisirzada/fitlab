package fitlab.BussinessLogic.Logic;

import fitlab.Data.Model.Teacher;
import fitlab.Data.Repository.TeacherRepository;
import fitlab.FitLabApplication;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeacherLogicTest {
    @Autowired
    TeacherRepository t_repo;
    @Autowired
    TeacherLogic l_repo;
    @Test
    void addRating() {

    }

    @Test
    void getReviews() {
    }

    @Test
    void findDup() {
        Teacher tec = new Teacher("John","Wick","jock");
        t_repo.save(tec);
        assertEquals(false, l_repo.tecDuplicate("jock"));
        assertEquals(true, l_repo.tecDuplicate("jock1"));
        t_repo.delete(tec);
    }

    @Test
    void editTeacherDetails() {
        Teacher tec = new Teacher("John","Wick","jock");
        t_repo.save(tec);
        int id = t_repo.findByUsername(tec.getUsername()).getId();
        l_repo.editTeacherDetails(id,"Elvis","Presley","elsley");
        Teacher tmp = t_repo.findById(id);
        assertEquals(tmp.getName() , "Elvis");
        assertEquals(tmp.getSurname() , "Presley");
        assertEquals(tmp.getUsername() , "elsley");
        t_repo.delete(tec);
    }
}