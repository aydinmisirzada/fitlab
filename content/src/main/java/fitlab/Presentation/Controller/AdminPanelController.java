package fitlab.Presentation.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/admin")
public class AdminPanelController {

    @RequestMapping(method = RequestMethod.GET)
    public String showAdminPanel(Model model){

        return "admin";
    }
}
