package fitlab.BussinessLogic;

import fitlab.Model.Content;
import fitlab.Model.ContentType;
import fitlab.Model.Message;
import fitlab.Model.Subject;
import fitlab.Repository.ContentRepository;
import fitlab.Repository.MessageRepository;
import fitlab.Repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;

@Service
public class ContentLogic {

    @Autowired
    ContentRepository repo;

    @Autowired
    MessageRepository mes_repo;
    @Autowired
    SubjectRepository s_repo;

    public void addContent( String title, ContentType type, Subject sub) {
        Content con = new Content(title, type);
        con.setSubject(sub);
        repo.save(con);
    }

    public String pageContent(String subject,String type, int page_id, Model model) {
        if(subject.isEmpty() || type.isEmpty() || page_id < 0) return "errorpage";
        List<Message> messages =  repo.findById(page_id).getMessageList();
        Subject sub = s_repo.findByCode(subject);
        model.addAttribute("subject",sub);
        model.addAttribute("messages",messages);
        return "page";
    }

}
