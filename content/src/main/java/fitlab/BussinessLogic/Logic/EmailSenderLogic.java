package fitlab.BussinessLogic.Logic;

import fitlab.BussinessLogic.Logic.exceptions.EmailSendException;
import fitlab.BussinessLogic.Logic.exceptions.UserNotFoundException;
import fitlab.BussinessLogic.services.MailSenderService;
import fitlab.Data.Model.Role;
import fitlab.Data.Model.User;
import fitlab.Data.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmailSenderLogic {
    @Autowired
    MailSenderService mailSender;
    @Autowired
    UserRepository userRepository;

    public void sendByEmail(String email, String message, String subject) throws EmailSendException {
        try {
            mailSender.send(email, message, subject);
        }catch (Exception e){
            System.err.println("Something wtong with Email sening to " + email);
            throw new EmailSendException();
        }
    }

    public void sendByUsername(String username, String message, String subject) throws EmailSendException {
        Optional<User> u = userRepository.findByUsername(username);

        if(u.equals(Optional.empty()))
            throw new UserNotFoundException();

        String email = u.get().getEmail();
        try {
            mailSender.send(email, message, subject);
        }catch (Exception e){
            System.err.println("Something wtong with Email sening to " + email);
            throw new EmailSendException();
        }
    }

    public void sendAdminOnly(String message, String subject) throws EmailSendException {
        List<User> admins = userRepository.findAllByRole(Role.ADMIN);
        for( User a : admins) {
            String email = a.getEmail();
            try {
                mailSender.send(email, message, subject);
            } catch (Exception e) {
                System.err.println("Something wtong with Email sening to " + email);
                throw new EmailSendException();
            }
        }
    }

    public void sendEveryoneInSystem(String message, String subject) throws EmailSendException {
        List<User> users = userRepository.findAll();;

        for( User u : users) {
            String email = u.getEmail();
            try {
                mailSender.send(email, message, subject);
            } catch (Exception e) {
                System.err.println("Something wtong with Email sening to " + email);
                throw new EmailSendException();
            }
        }
    }
}
