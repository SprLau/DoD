package utils;

import java.util.ArrayList;
import java.util.HashMap;

public class Config {
    private final ArrayList<String> functions;
    private final HashMap<Integer, String> months;

    public Config() {
        this.functions = new ArrayList<>();
        this.months = new HashMap<>();
        init();
    }

    private void init() {
        this.functions.add("Query All Tasks.");
        this.functions.add("Query All Tasks on a Certain Date.");
        this.functions.add("Add a Task.");
        this.functions.add("Kill a Task.");
        this.functions.add("Exit.");

        this.months.put(1, "Jan");
        this.months.put(2, "Feb");
        this.months.put(3, "Mar");
        this.months.put(4, "Apr");
        this.months.put(5, "May");
        this.months.put(6, "Jun");
        this.months.put(7, "Jul");
        this.months.put(8, "Aug");
        this.months.put(9, "Sep");
        this.months.put(10, "Oct");
        this.months.put(11, "Nov");
        this.months.put(12, "Dec");
    }

    public ArrayList<String> getFunctions() {
        return this.functions;
    }

    public HashMap<Integer, String> getMonths() {
        return this.months;
    }
}
