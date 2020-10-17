package fitlab.Presentation.Controller;

import fitlab.BussinessLogic.Interfaces.TeacherLogicConf;
import fitlab.BussinessLogic.Logic.ContentLogic;
import fitlab.BussinessLogic.Interfaces.MessageLogicConf;
import fitlab.Data.Model.Message;
import fitlab.Data.Model.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//The class controls chat page
@Controller
public class ContentPageController {

    @Autowired
    ContentLogic c_repo;
    @Autowired
    MessageLogicConf m_repo;
    @Autowired
    TeacherLogicConf t_repo;
    /**
     * The method is used to return a content page
     * @param subject This is the subject name from the link
     * @param type This is the subject type from the link
     * @param page_id This is the subject id from the link
     * @param model This is a variable used by the framework
     * @return Method returns the name of the html page from templates
     */
    @RequestMapping("/subjects/{subject}/{type}/{page_id}")
    public String page(@PathVariable String subject, @PathVariable String type, @PathVariable int page_id, Model model) {
        Subject sub = c_repo.contentSubject(subject);
        List<Message> messages = c_repo.contentMessageList(page_id);

        if(sub == null) return "errorpage";

        model.addAttribute("messages",messages);
        return "page";
    }

    /**
     * The method is used to add a message to the forum
     * @param subject This is the subject name from the link
     * @param type This is the subject type from the link
     * @param page_id This is the subject id from the link
     * @param author This is authors name
     * @param text This is text
     * @return Method returns the name of the html page from templates ( in this case it redirects the page )
     */
    @PostMapping("/subjects/{subject}/{type}/{page_id}")
    public String pageAddMessage(@PathVariable String subject, @PathVariable String type, @PathVariable int page_id, @RequestParam String author, @RequestParam String text) {
        m_repo.pageAddMessage(page_id,author,text);
        return "redirect:" + "/subjects/" + subject + "/" + type + '/' + page_id;
    }
    @RequestMapping("/teachers/{id}/reviews")
    public String teacherContentPage(@PathVariable int id,  Model model) {
        model.addAttribute("messages",t_repo.getContent(id).getMessageList());
        return "page";
    }

    @PostMapping("/teachers/{id}/reviews")
    public String pageAddMessageTeacher(@PathVariable int id, @RequestParam String author, @RequestParam String text) {
        int tmp = t_repo.getContent(id).getId();
        m_repo.pageAddMessage(tmp,author,text);
        return "redirect:" + "/teachers/" + id + "/reviews";
    }


    @PostMapping(value = "/subjects/{subject}" , params = "id")
    public String delSubject(@PathVariable String subject, @RequestParam int  id) {
        c_repo.delContent(c_repo.getCon(id));
        return "redirect:/subjects/" + subject;
    }


}
