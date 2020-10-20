package fitlab.Presentation.Controller;

import fitlab.BussinessLogic.Logic.RegistrationLogic;
import fitlab.Data.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RegistrationController {

    @Autowired
    RegistrationLogic rl;

    @RequestMapping(method = RequestMethod.GET, value = "/registration")
    public String registration(){
        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String addUser(User user, Model model){
        Boolean b = rl.addUser(user);
        if(!b) model.addAttribute("error", "User with this email or username already exists!");
        model.addAttribute("user", user);
        return "redirect:/login";
    }

}
