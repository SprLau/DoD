package table;

import utils.Config;

public class Task {
    private final Integer[] date;
    private final String description;

    public Task(String description, Integer... date) {
        this.date = date;
        this.description = description;
    }

    public Integer[] getDate() {
        return date;
    }

    public Integer getDateAsInt() {
        return date[0] * 10000 + date[1] * 100 + date[2];
    }

    public String getDateAsString() {
        return new Config().getMonths().get(date[1]) + " " +
                date[2] + stOrNdOrRdOrTh(date[2]) + ", " + date[0];
    }

    private String stOrNdOrRdOrTh(Integer day) {
        String dayAsStr = day.toString();
        return dayAsStr.codePointAt(dayAsStr.length() - 1) == '1' ? "st" :
                dayAsStr.codePointAt(dayAsStr.length() - 1) == '2' ? "nd" :
                        dayAsStr.codePointAt(dayAsStr.length() - 1) == '3' ? "rd" : "th";
    }

    public String getDescription() {
        return description;
    }
}
