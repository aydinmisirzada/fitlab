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
}
