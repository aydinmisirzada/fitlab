package fitlab.BussinessLogic;

import fitlab.Model.Message;
import fitlab.Repository.ContentRepository;
import fitlab.Repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageLogic {
    @Autowired
    ContentRepository con_repo;
    @Autowired
    MessageRepository mes_repo;


    public void pageAddMessage( String subject,String type, int page_id, String author, String text) {
        Message message = new Message(text,author,con_repo.findById(page_id));
        mes_repo.save(message);
        con_repo.save(con_repo.findById(page_id));
    }
}
