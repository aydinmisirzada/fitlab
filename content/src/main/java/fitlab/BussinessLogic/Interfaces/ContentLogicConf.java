package fitlab.BussinessLogic.Interfaces;

import fitlab.Data.Model.ContentType;
import fitlab.Data.Model.Message;
import fitlab.Data.Model.Subject;
import org.springframework.ui.Model;

import java.util.List;

public interface ContentLogicConf {
     void addContent(String title, ContentType type, Subject sub);
     List<Message> contentMessageList(int page_id) ;
     Subject contentSubject(String code);
}
