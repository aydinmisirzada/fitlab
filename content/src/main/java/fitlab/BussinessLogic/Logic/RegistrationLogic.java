package fitlab.BussinessLogic.Logic;

import fitlab.BussinessLogic.Interfaces.RegistrationLogicInterface;
import fitlab.BussinessLogic.services.MailSenderService;
import fitlab.Data.Model.Role;
import fitlab.Data.Model.User;
import fitlab.Data.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class RegistrationLogic implements RegistrationLogicInterface {

    @Autowired
    UserRepository userRepository;

    @Autowired
    MailSenderService mailSender;

    @Value("${mail.message.activation}")
    String message;

    public String addUser(User user){
        Optional<User> u = userRepository.findByUsername(user.getUsername());
        if(!u.equals(Optional.empty())) return "username";
        u = userRepository.findByEmail(user.getEmail());
        if(!u.equals(Optional.empty())) return "email";

        user.setRole(Role.USER);
        user.setPathId(user.getUsername()+UUID.randomUUID().toString());
        user.setActivationCode(UUID.randomUUID().toString());
        userRepository.save(user);

        if(!user.getEmail().isEmpty()){
            String newMessage = String.format(message, user.getUsername(), user.getActivationCode());
            mailSender.send(user.getEmail(),newMessage, "Activation code");
        }
        return "t";
    }

    public boolean checkActivation(String activationCode) {
        Optional<User> u = userRepository.findByActivationCode(activationCode);
        if(u.equals(Optional.empty())) return false;

        u.get().setActivationCode("");
        userRepository.save(u.get());
        return true;
    }
}
