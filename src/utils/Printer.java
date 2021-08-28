package utils;

public class Printer {
    private final Config config;

    public Printer() {
        this.config = new Config();
    }

    public void printFunctionsInterface() {
        System.out.println("***************************************");
        Integer cnt = 0;
        for (String str : config.getFunctions()) {
            cnt++;
            System.out.println(cnt + ". " + str);
        }
        System.out.println("***************************************");
    }
}
