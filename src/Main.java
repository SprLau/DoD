import exceptions.NullOptionException;
import runner.Runner;

public class Main {
    public static void main(String[] args)
            throws NullOptionException {
        Runner runner = new Runner();
        runner.start();
    }
}
