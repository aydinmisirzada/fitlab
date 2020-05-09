package fitlab.Controller;

import fitlab.BussinessLogic.ContentLogic;
import fitlab.BussinessLogic.MessageLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class ContentPageController {
    @Autowired
    ContentLogic c_repo;
    @Autowired
    MessageLogic m_repo;

    @RequestMapping("/subjects/{subject}/{type}/{page_id}")
    public String page(@PathVariable String subject, @PathVariable String type, @PathVariable int page_id, Model model) {
        return c_repo.pageContent(subject,type,page_id,model);
    }

    @PostMapping("/subjects/{subject}/{type}/{page_id}")
    public String pageAddMessage(@PathVariable String subject, @PathVariable String type, @PathVariable int page_id, @RequestParam String author, @RequestParam String text) {
        m_repo.pageAddMessage(subject,type,page_id,author,text);
        return "redirect:" + "/subjects/" + subject + "/" + type + "/" + page_id;
    }


}
