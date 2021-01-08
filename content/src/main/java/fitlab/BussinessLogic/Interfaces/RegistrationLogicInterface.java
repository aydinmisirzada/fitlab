package fitlab.BussinessLogic.Interfaces;

import fitlab.Data.Model.User;

public interface RegistrationLogicInterface {
    String addUser(User user);
    boolean checkActivation(String activationCode);
}
