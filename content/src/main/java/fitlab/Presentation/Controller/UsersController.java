package fitlab.Presentation.Controller;

import fitlab.BussinessLogic.Logic.UsersLogic;
import fitlab.Data.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UsersLogic usersLogic;

    @RequestMapping(value = "/{pathId}", method = RequestMethod.GET)
    public String getUserPage(@CookieValue(value = "username", defaultValue = "ses") String username, @PathVariable String pathId, Model model){
        User u = usersLogic.getUserByPath(pathId);
        if(u==null)      // If user is not exist return "USER NOT FOUND" page
            return "errorpage";

        model.addAttribute("error", username);
        model.addAttribute("user", u);
        return "userPage";
    }

    @RequestMapping(value = "/userEdit", method = RequestMethod.POST)
    public String editUserInfo(User user, Model model){
        String s = usersLogic.editUserByEmail(user);
        if(s.equals("une"))
            return "errorpage";
        else if(s.equals("path")) {
            model.addAttribute("error", "User with same URL exist, choose another one!");
            return "userPage";
        }
        else if(s.equals("user")) {
            model.addAttribute("error", "User with same username exist, choose another one!");
            return "userPage";
        }

        return "redirect:/users/"+user.getPathId();
    }

}
