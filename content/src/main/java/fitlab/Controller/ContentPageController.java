package fitlab.Controller;

import fitlab.Model.Content;
import fitlab.Model.ContentType;
import fitlab.Model.Message;
import fitlab.Model.Subject;
import fitlab.Repository.ContentRepository;
import fitlab.Repository.MessageRepository;
import fitlab.Repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ContentPageController {
    @Autowired
    SubjectRepository repo;
    @Autowired
    ContentRepository con_repo;
    @Autowired
    MessageRepository mes_repo;

    @RequestMapping("/subjects/{subject}/{type}/{page_id}")
    public String page(@PathVariable String subject, @PathVariable String type, @PathVariable int page_id, Model model) {
        List<Message> messages =  con_repo.findById(page_id).getMessageList();
        Subject sub = repo.findByCode(subject);
        model.addAttribute("subject",sub);
        model.addAttribute("messages",messages);
        return "page";
    }

    @PostMapping("/subjects/{subject}/{type}/{page_id}")
    public String pageAddMessage(@PathVariable String subject, @PathVariable String type, @PathVariable int page_id, @RequestParam String author, @RequestParam String text, Model model) {
        Message message = new Message(text,author,con_repo.findById(page_id));
        mes_repo.save(message);
        con_repo.save(con_repo.findById(page_id));
        return "redirect:" + "/subjects/" + subject + "/" + type + "/" + page_id;
    }


}
