package fitlab.Presentation.Controller;

import fitlab.BussinessLogic.Logic.EmailSenderLogic;
import fitlab.BussinessLogic.Logic.exceptions.EmailSendException;
import fitlab.BussinessLogic.Logic.exceptions.UserNotFoundException;
import fitlab.BussinessLogic.services.MailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    EmailSenderLogic emailSender;

    @RequestMapping(method = RequestMethod.GET)
    public String showEmailSenderPage(){
        return "emailSender";
    }

    @RequestMapping(value="/result", method = RequestMethod.GET)
    public String showEmailSenderResult(@RequestParam(name = "r") Boolean result, Model model){
        model.addAttribute("result", result.toString());
        return "emailSenderResult";
    }

    @RequestMapping(value="/send" ,method = RequestMethod.POST)
    public ModelAndView sendEmail( String emailTo, String username, String email,
                                   String subject, String message ) throws EmailSendException {
        ModelAndView modelAndView = new ModelAndView("redirect:/email/result");
        if(emailTo.equals("email"))
            emailSender.sendByEmail(email, message, subject);
        else if(emailTo.equals("username")){
            try {
                emailSender.sendByUsername(username, message, subject);
            }
            catch (UserNotFoundException e){
                modelAndView.addObject("r", "false");
                return modelAndView;
            }
        }
        else if(emailTo.equals("admin")) {
            try {
                emailSender.sendAdminOnly(message, subject);
            } catch (EmailSendException e){
                modelAndView.addObject("r", "false");
                return modelAndView;
            }
        }
        else if(emailTo.equals("all")) {
            try {
                emailSender.sendEveryoneInSystem(message, subject);
            } catch (EmailSendException e){
                modelAndView.addObject("r", "false");
                return modelAndView;
            }
        }

        modelAndView.addObject("r", "true");
        return modelAndView;
    }
}
