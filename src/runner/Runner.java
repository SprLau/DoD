package runner;

import exceptions.NullOptionException;
import table.Table;
import table.Task;
import utils.Printer;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Runner {
    private final Table table;
    private final Printer printer;
    private final Scanner scanner;

    public Runner() {
        this.table = new Table();
        this.printer = new Printer();
        this.scanner = new Scanner(System.in);
    }

    private int safeInputInt() {
        int res = 0;
        boolean valid;
        do {
            try {
                res = scanner.nextInt();
                valid = true;
            } catch (InputMismatchException e) {
                System.out.println("* Invalid Input! *");
                System.out.print("Re-Input: ");
                scanner.next();
                valid = false;
            }
        } while (!valid);
        return res;
    }

    private void queryAll() {
        table.queryAll();
    }

    private void queryDay() {
        System.out.print("Year: ");
        int year = safeInputInt();
        System.out.print("Month: ");
        int month = safeInputInt();
        System.out.print("Day: ");
        int day = safeInputInt();
        table.queryADay(year * 10000 + month * 100 + day);
    }

    private void addTask() {
        System.out.print("Year: ");
        int year = safeInputInt();
        System.out.print("Month: ");
        int month = safeInputInt();
        System.out.print("Day: ");
        int day = safeInputInt();
        Integer[] dateSet = {year, month, day};
        System.out.print("Task: ");
        scanner.nextLine();
        String description = scanner.nextLine();
        table.addTask(new Task(description, dateSet));
    }

    private void killTask() {
        if (this.table.getTableSize() == 0) {
            System.out.println("Now the Table Is Empty! Add Some First!");
            return;
        }
        HashMap<Integer, Task> noToTaskMap = new HashMap<>();
        int cnt = 0;
        System.out.println("Currently, There Are: ");
        for (Task task : this.table.getIdToTaskMap().values()) {
            cnt++;
            noToTaskMap.put(cnt, task);
            System.out.println(cnt + ". " + task.getDescription() + " - " + task.getDateAsString());
        }
        System.out.println("--- End. ---");
        System.out.print("Which One To Be Killed: ");
        int target = safeInputInt();
        if (target > cnt) {
            System.out.println("* Out of Range! *");
            return;
        }
        table.removeTask(noToTaskMap.get(target));
    }

    public void start()
            throws NullOptionException {
        boolean run = true;
        while (run) {
            printer.printFunctionsInterface();
            System.out.print("Option: ");
            int catchOpt = safeInputInt();
            switch (catchOpt) {
                case 1 -> queryAll();
                case 2 -> queryDay();
                case 3 -> addTask();
                case 4 -> killTask();
                case 5 -> run = false;
                default -> throw new NullOptionException();
            }
        }
    }
}
