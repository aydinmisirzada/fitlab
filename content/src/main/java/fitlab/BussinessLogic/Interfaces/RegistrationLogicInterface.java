package fitlab.BussinessLogic.Interfaces;

import fitlab.Data.Model.User;

public interface RegistrationLogicInterface {
    void addUser(User user);
    boolean checkActivation(String activationCode);
}
