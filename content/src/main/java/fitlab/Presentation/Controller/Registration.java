package fitlab.Presentation.Controller;

import fitlab.Data.Model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class Registration {

    @RequestMapping(method = RequestMethod.GET, value = "/registration")
    public String registration(){
        return "registration";
    }

    @RequestMapping("/registration")
    public String addUser(User user){
        return "redirect:/login";
    }

}
