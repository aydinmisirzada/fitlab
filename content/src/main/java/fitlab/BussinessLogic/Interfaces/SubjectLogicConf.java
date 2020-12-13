package fitlab.BussinessLogic.Interfaces;

import fitlab.Data.Model.ContentType;
import fitlab.Data.Model.Review;
import fitlab.Data.Model.Semester;
import fitlab.Data.Model.Subject;
import org.springframework.ui.Model;

import java.util.List;

/**
 * Interface for all operations with subjects
 */
public interface SubjectLogicConf {
     /**
      * The method is used to find a subject from database
      * @param subject Is a code of the subject written in text form
      * @return Method returns an object of found subject
      */
     Subject SearchSubjects(String subject);

     /**
      * The method is used to change the description of the subject
      * @param subject This is a code of the subject written in text form
      * @param description
      * @return returns an object of the subject with edited description
      */
     Subject SubjectEditDescription( String subject, String description);

     /**
      * The method is used to add a page to the subject
      * @param subject This is a code of the subject written in text form
      * @param title This is the name of the page
      * @param type This is a type of the page (homework,test,exam)
      * @return returns an object of the subject
      */
     Subject SubjectAddPage(String subject, String title, ContentType type);

     /**
      * The method is used to return all subjects
      * @return Returns the list of subjects
      */
     List<Subject> SearchList();

     /**
      * The method is used to add a subject to the subject list
      * @param code This is a code of the subject written in text form
      * @param name This is a name of the subject
      * @param semester This is semester
      */
     void addSubject(String code,String name, Semester semester);

     /**
      * The method is used to delete a subject to the subject list
      * @param id This is id of the subject which is to be deleted
      */
     void delSubject(int  id);

     Boolean subDuplicate(String code,String name);
     List<Review> getReviews(String code);
     public void addRating(String code, int rate, String text, String username);
}
