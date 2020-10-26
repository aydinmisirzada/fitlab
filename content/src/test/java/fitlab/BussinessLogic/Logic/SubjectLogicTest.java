package fitlab.BussinessLogic.Logic;

import fitlab.Data.Model.Semester;
import fitlab.Data.Model.Subject;
import fitlab.Data.Model.Teacher;
import fitlab.Data.Repository.SubjectRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SubjectLogicTest {

    @Autowired
    SubjectLogic sub_repo;
    @Autowired
    SubjectRepository repo;
    @Test
    void averageRating() {
        List<Integer> ratings = new ArrayList<>();
        ratings.add(2);
        ratings.add(5);
        ratings.add(2);
        ratings.add(3);
        assertEquals(3,sub_repo.averageRating(ratings));
    }

    @Test
    void editSubjectDetails() {
        Subject sub = new Subject("BIE-LIN","Linear Algebra", Semester.WINTER);
        repo.save(sub);
        int id = repo.findByCode(sub.getCode()).getId();
        sub_repo.editSubjectDetails(id,"BIE-LIN","Linear Algebra",0);
        Subject tmp = repo.findById(id);
        assertEquals(tmp.getCode() , "BIE-LIN");
        assertEquals(tmp.getName() , "Linear Algebra");
        assertEquals(tmp.getSemester() , Semester.SUMMER);
        repo.delete(tmp);
    }
}