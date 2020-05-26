package fitlab.BussinessLogic.Interfaces;

import fitlab.Data.Model.ContentType;
import fitlab.Data.Model.Semester;
import fitlab.Data.Model.Subject;
import org.springframework.ui.Model;

import java.util.List;

public interface SubjectLogicConf {
     Subject SearchSubjects(String subject);
     Subject SubjectEditDescription( String subject, String description);
     Subject SubjectAddPage(String subject, String title, ContentType type);
     List<Subject> SearchList();
     void addSubject(String code,String name, Semester semester);
     void delSubject(int  id);
}
