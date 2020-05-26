package fitlab.BussinessLogic.Logic;

import fitlab.BussinessLogic.Interfaces.ContentLogicConf;
import fitlab.Data.Model.Content;
import fitlab.Data.Model.ContentType;
import fitlab.Data.Model.Message;
import fitlab.Data.Model.Subject;
import fitlab.Data.Repository.ContentRepository;
import fitlab.Data.Repository.MessageRepository;
import fitlab.Data.Repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;

@Service
public class ContentLogic implements ContentLogicConf {

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


    public List<Message> contentMessageList(int page_id) {
        return repo.findById(page_id).getMessageList();
    }

    public Subject contentSubject(String code) {
        return  s_repo.findByCode(code);
    }

}
