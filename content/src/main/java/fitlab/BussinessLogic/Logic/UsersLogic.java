package fitlab.BussinessLogic.Logic;

import fitlab.Data.Model.User;
import fitlab.Data.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsersLogic {
    @Autowired
    UserRepository userRepository;

    public User getUserByPath(String path){
        Optional<User> u = userRepository.findByPathId(path);
        if(u.equals(Optional.empty())) return null;

        return u.get();
    }

    public String editUserByEmail(User user) {
        Optional<User> u = userRepository.findByEmail(user.getEmail());
        if(u.equals(Optional.empty())) return "une"; //user not exist

        if(!u.get().getPathId().equals(user.getPathId())){
            Optional<User> tmp = userRepository.findByPathId(user.getPathId());
            if(!tmp.equals(Optional.empty()))
                return "path";  //path exist
        }
        else if(!u.get().getUsername().equals(user.getUsername())){
            Optional<User> tmp = userRepository.findByUsername(user.getUsername());
            if(!tmp.equals(Optional.empty()))
                return "username";  //path exist
        }
        u.get().setUser(user);
        userRepository.save(u.get());
//        SecurityContextHolder.getContext().getAuthentication();
//        SecurityContextHolder.getContext().setAuthentication((Authentication) u.map(OwnUserDetails::new).get());
        return "true";
    }
}
