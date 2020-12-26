package fitlab.BussinessLogic.Logic;

import fitlab.BussinessLogic.Interfaces.UsersLogicInterface;
import fitlab.Data.Model.OwnUserDetails;
import fitlab.Data.Model.Role;
import fitlab.Data.Model.Subject;
import fitlab.Data.Model.User;
import fitlab.Data.Repository.SubjectRepository;
import fitlab.Data.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsersLogic implements UsersLogicInterface {
    @Autowired
    UserRepository userRepository;
    @Autowired
    SubjectRepository subjectRepository;
    OwnUserDetails oud;

    public User getUserByPath(String path){
        Optional<User> u = userRepository.findByPathId(path);

        if(u.equals(Optional.empty()) ||
                (!checkAccount(u.get().getId()) && !oud.getRole().equals(Role.ADMIN)))
            throw new NullPointerException("User does not exist");
//            return null;

        return u.get();
    }

    private boolean checkAccount(Integer id){
        oud = (OwnUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(oud.getUserId().equals(id))
            return true;

        return false;
    }

    public boolean editUserById(User user, Boolean role){
        Optional<User> u = userRepository.findById(user.getId());

        if (u.equals(Optional.empty()))
            throw new IllegalArgumentException("une"); //user not exist
        if (!u.get().getPathId().equals(user.getPathId())) {
            Optional<User> tmp = userRepository.findByPathId(user.getPathId());
            if (!tmp.equals(Optional.empty()))
                throw new IllegalArgumentException("path");
        } else if (!u.get().getUsername().equals(user.getUsername())) {
            Optional<User> tmp = userRepository.findByUsername(user.getUsername());
            if (!tmp.equals(Optional.empty()))
                throw new IllegalArgumentException("username"); //username exist
        }

        if(role)
            user.setRole(Role.ADMIN);
        else
            user.setRole(Role.USER);

        u.get().setUser(user);
        userRepository.save(u.get());

        //Make changes in authentication of spring security
        if(checkAccount(u.get().getId())) {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            OwnUserDetails userDetails = (OwnUserDetails) authentication.getPrincipal();
            userDetails.setOwnUserDetails(u.get());
        }

        return true;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public void delAssignment(User u, int id){
        Subject subject = subjectRepository.findById(id);
        if(subject == null)
            return;
        subject.delUser(u);
        u.delSubject(subject);
        subjectRepository.save(subject);
        userRepository.save(u);
    }

    public User getUser(String username) {
        Optional<User> u = userRepository.findByUsername(username);
        if(u.equals(Optional.empty()))
            return null;
        else
            return u.get();
    }
}
