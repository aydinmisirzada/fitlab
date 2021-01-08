package fitlab.Presentation.Controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/email")
@PreAuthorize("hasAuthority('ADMIN')")
public class EmailSenderController {

    @RequestMapping(method = RequestMethod.GET)
    public String showEmailSenderPage(){
        return "emailSender";
    }
    /*@RequestMapping(method = RequestMethod.GET)
    public String showEmailSenderPage(@RequestParam(required = false, name = "an") Boolean result, Model model){
        model.addAttribute("result", result.toString().equals(null) ? "" : result.toString());
        return "emailSender";
    }*/

    @RequestMapping(value="/result", method = RequestMethod.GET)
    public String showEmailSenderResult(@RequestParam(required = true, name = "an") Boolean result, Model model){
        model.addAttribute("result", result.toString());
        return "emailSenderResult";
    }

    @RequestMapping(value="/send" ,method = RequestMethod.POST)
    public ModelAndView sendEmail(String emailTo, String username, String email, String subject, String message, Model model ){
        System.err.println(emailTo + " " + subject + " " + message);

        ModelAndView modelAndView = new ModelAndView("redirect:/email/result");
        modelAndView.addObject("an", "false");
        return modelAndView;
    }
}
