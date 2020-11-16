package fitlab.BussinessLogic.exeptions;

public class AdminWasFoundExeption extends Exception {
    public AdminWasFoundExeption() {
        super("Admin was found, cannot create a new one");
    }

    public AdminWasFoundExeption(String message) {
        super(message);
    }
}
