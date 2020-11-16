package fitlab.BussinessLogic.exeptions;

public class AdminWasFoundException extends Exception {
    public AdminWasFoundException() {
        super("Admin was found, cannot create a new one");
    }

    public AdminWasFoundException(String message) {
        super(message);
    }
}
