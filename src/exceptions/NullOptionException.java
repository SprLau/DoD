package exceptions;

public class NullOptionException extends Exception {
    public NullOptionException() {
        System.out.println("* No Such Option! *");
    }
}
