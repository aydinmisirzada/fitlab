package fitlab.BussinessLogic.Interfaces;

import fitlab.Data.Model.Content;
import fitlab.Data.Model.ContentType;
import fitlab.Data.Model.Message;
import fitlab.Data.Model.Subject;
import org.springframework.ui.Model;

import java.util.List;

/**
 * Interface for subject page content
 */
public interface ContentLogicConf {

     /**
      * The method is used to add a page to the subject
      * @param title is the name of the page
      * @param type is a type of the page (homework,test,exam)
      * @param sub is a subject object where to add a page
      */
     void addContent(String title, ContentType type, Subject sub);

     /**
      * The method is used to return the list of messages
      * @param page_id is id of the page
      * @return is the list of messages on the page
      */
     List<Message> contentMessageList(int page_id) ;

     /**
      * The method is used to return the object of the subject
      * @param code is code of the subject
      * @return subject object
      */
     Subject contentSubject(String code);

     void delContent(Content con);
     Content getCon(int id);
}
