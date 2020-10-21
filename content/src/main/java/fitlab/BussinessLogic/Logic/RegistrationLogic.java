package fitlab.BussinessLogic.Logic;

import fitlab.Data.Model.User;
import fitlab.Data.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RegistrationLogic {

    @Autowired
    UserRepository userRepository;

    public String addUser(User user){
        Optional<User> u = userRepository.findByUsername(user.getUsername());
        if(!u.equals(Optional.empty())) return "username";
        u = userRepository.findByEmail(user.getEmail());
        if(!u.equals(Optional.empty())) return "email";

        user.setRole("USER");
        userRepository.save(user);
        return "t";
    }
}
