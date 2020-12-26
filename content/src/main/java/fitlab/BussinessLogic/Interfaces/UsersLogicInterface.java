package fitlab.BussinessLogic.Interfaces;

import fitlab.Data.Model.User;

import java.util.List;

public interface UsersLogicInterface {
    User getUserByPath(String path);
    String editUserById(User user, Boolean role) throws Exception;
    List<User> getAllUsers();
}
