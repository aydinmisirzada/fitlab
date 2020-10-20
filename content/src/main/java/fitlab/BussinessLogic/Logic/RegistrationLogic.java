package fitlab.BussinessLogic.Logic;

import fitlab.Data.Model.User;
import fitlab.Data.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationLogic {

    @Autowired
    UserRepository userRepository;

    public boolean addUser(User user){
//        User u = userRepository.findByEmailAndUsername(user.getEmail(), user.getUsername());
//        if(u != null) return false;

        user.setRole("USER");
        userRepository.save(user);
        return true;
    }
}
