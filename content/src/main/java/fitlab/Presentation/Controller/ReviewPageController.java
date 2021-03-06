package fitlab.Presentation.Controller;

import fitlab.BussinessLogic.Interfaces.MessageLogicConf;
import fitlab.BussinessLogic.Interfaces.TeacherLogicConf;
import fitlab.BussinessLogic.Logic.ContentLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ReviewPageController {

    @Autowired
    TeacherLogicConf t_repo;


    @RequestMapping("/teachers/{id}/reviews")
    public String teacherContentPage(@PathVariable int id, Model model,  Authentication auth) {

        model.addAttribute("reviews",t_repo.getReviews(id));
        model.addAttribute("user",auth.getName());
        model.addAttribute("teacher",t_repo.getTeacher(id));
        return "review";
    }


    @PostMapping(value = "/teachers/{id}/reviews", params = "rating")
    public String teacherRating(@PathVariable int id, @RequestParam int rating, @RequestParam String text, Authentication auth, Model model) {
        if(t_repo.findDup(id,auth.getName()) == false)  {
            model.addAttribute("error", "You can't add more reviews");
            model.addAttribute("reviews",t_repo.getReviews(id));
            model.addAttribute("user",auth.getName());
            model.addAttribute("teacher",t_repo.getTeacher(id));
            return "review";
        }
        t_repo.addRating(id, rating, text, auth.getName());
        return "redirect:/teachers/" + id + "/reviews";
    }



}
