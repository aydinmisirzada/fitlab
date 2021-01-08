package fitlab.Presentation.Controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/email")
@PreAuthorize("hasAuthority('ADMIN')")
public class EmailSenderController {

    @RequestMapping(method = RequestMethod.GET)
    public String showEmailSenderPage(){
        return "emailSender";
    }

    @RequestMapping(value="/send" ,method = RequestMethod.POST)
    public String sendEmail(String emailTo, String username, String email, String subject, String message ){
        System.err.println(emailTo + " " + subject + " " + message);
        return "emailSender";
    }
}
