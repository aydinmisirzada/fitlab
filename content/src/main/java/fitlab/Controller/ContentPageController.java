package fitlab.Controller;

import fitlab.BussinessLogic.Logic.ContentLogic;
import fitlab.BussinessLogic.Interfaces.MessageLogicConf;
import fitlab.Data.Model.Message;
import fitlab.Data.Model.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class ContentPageController {
    @Autowired
    ContentLogic c_repo;
    @Autowired
    MessageLogicConf m_repo;

    @RequestMapping("/subjects/{subject}/{type}/{page_id}")
    public String page(@PathVariable String subject, @PathVariable String type, @PathVariable int page_id, Model model) {
        Subject sub = c_repo.contentSubject(subject);
        List<Message> messages = c_repo.contentMessageList(page_id);

        if(sub == null) return "errorpage";

        model.addAttribute("subject",sub);
        model.addAttribute("messages",messages);
        return "page";
    }

    @PostMapping("/subjects/{subject}/{type}/{page_id}")
    public String pageAddMessage(@PathVariable String subject, @PathVariable String type, @PathVariable int page_id, @RequestParam String author, @RequestParam String text) {
        m_repo.pageAddMessage(subject,type,page_id,author,text);
        return "redirect:" + "/subjects/" + subject + "/" + type + "/" + page_id;
    }


}
