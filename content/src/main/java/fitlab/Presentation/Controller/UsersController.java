package fitlab.Presentation.Controller;

import fitlab.BussinessLogic.Logic.UsersLogic;
import fitlab.Data.Model.Role;
import fitlab.Data.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UsersLogic usersLogic;

    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(method = RequestMethod.GET)
    public String getUsers(Model model){
        List<User> u = usersLogic.getAllUsers();

        model.addAttribute("users", u);
        return "allUsers";
    }

    @RequestMapping(value = "/{pathId}", method = RequestMethod.GET)
    public String getUserPage(@PathVariable String pathId,Integer id, Model model){
        User u = usersLogic.getUserByPath(pathId);
        if(u==null)      // If user is not exist return "USER NOT FOUND" page
            return "errorpage";

        model.addAttribute("error", 0);
        model.addAttribute("user", u);
        return "userPage";
    }

    @RequestMapping(value = "/userEdit", method = RequestMethod.POST)
    public String editUserInfo(User user, Boolean userRole, Model model){
        if(userRole == null) userRole = false;
        String s = usersLogic.editUserById(user, userRole);
        if(s.equals("une"))
            return "errorpage";
        else if(s.equals("path")) {
            model.addAttribute("error", 1);
            return "userPage";
        }
        else if(s.equals("username")) {
            model.addAttribute("error", 2);
            return "userPage";
        }

        return "redirect:/users/"+user.getPathId();
    }

    @RequestMapping(value = "/{pathId}", method = RequestMethod.POST, params = {"id"})
    public String delAssignment(@PathVariable String pathId, @RequestParam int  id) {
        User u = usersLogic.getUserByPath(pathId);
        if(u == null)  return "errorpage";
        usersLogic.delAssignment(u,id);
        return "redirect:/users/" + u.getPathId();
    }


}
