package fitlab.BussinessLogic.Logic;

import com.netflix.discovery.converters.Auto;
import fitlab.Data.Model.Content;
import fitlab.Data.Model.ContentType;
import fitlab.Data.Model.Semester;
import fitlab.Data.Model.Subject;
import fitlab.Data.Repository.ContentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ContentLogicTest {

    @Autowired
    ContentLogic con;
    @Autowired
    ContentRepository repo;
    @Test
    void changeTitle() {
        Subject sub = new Subject("BIE-LIN","Lnear Algebra", Semester.SUMMER);
        Content content = new Content("TMP", ContentType.HOMEWORK);
        repo.save(content);
        con.changeTitle(content.getId(),"THIS");
        assertEquals("THIS",repo.findById(content.getId()));
        repo.delete(content);
    }
}