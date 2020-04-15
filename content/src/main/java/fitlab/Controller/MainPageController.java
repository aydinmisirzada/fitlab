package fitlab.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainPageController {

    // A method to direct to the main page
    @GetMapping("/")
    public String mainPage () {
        return "index";
    }

}
