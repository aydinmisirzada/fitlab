package fitlab.BussinessLogic.Logic;

import fitlab.Data.Model.User;
import fitlab.Data.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class UserLogic {
    @Autowired
    UserRepository repo;

    public User getUser(String username) {
        Optional<User> u = repo.findByUsername(username);
        if(u.equals(Optional.empty()))
            return null;
        else
            return u.get();
    }
}
