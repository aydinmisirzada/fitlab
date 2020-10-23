package fitlab.Presentation.Controller;

import fitlab.BussinessLogic.Logic.UsersLogic;
import fitlab.Data.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UsersLogic usersLogic;

    @RequestMapping(value = "/{pathId}", method = RequestMethod.GET)
    public String getUserPage(@PathVariable String pathId, Model model){
        User u = usersLogic.getUserByPath(pathId);
        /*if(u==null)      // If user is not exist return "USER NOT FOUND" page
            return "errorpage";*/

        model.addAttribute("user", u);
        return "userPage";
    }

}
