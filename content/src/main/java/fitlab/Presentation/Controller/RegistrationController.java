package fitlab.Presentation.Controller;

import fitlab.BussinessLogic.Logic.RegistrationLogic;
import fitlab.Data.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RegistrationController {

    @Autowired
    RegistrationLogic rl;


    @RequestMapping(method = RequestMethod.GET, value = "/registration")
    public String registration(Model model){
        model.addAttribute("error", "");
        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String addUser(User user, Model model){
        String s = rl.addUser(user);
        if(s.equals("username")){
            s = "User with this username already exists!";
            model.addAttribute("error", s);
            return "registration";
        }
        if(s.equals("email")){
            s = "User with this email already exists!";
            model.addAttribute("error", s);
            return "registration";

        }
        
        return "redirect:/activation";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/activate/{activationCode}")
    public String accountActivation(@PathVariable String activationCode, Model model){
        boolean isActivated = rl.checkActivation(activationCode);

        if(isActivated)
            model.addAttribute("error", "User activated successfully!");
        else
            model.addAttribute("error", "User activation FAILED!");

        return "login";
    }

}
