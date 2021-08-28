package table;

import exceptions.DuplicatedTaskException;

import java.util.ArrayList;
import java.util.HashMap;

public class Table {
    private final HashMap<Integer, Task> idToTaskMap;
    private final HashMap<Integer, ArrayList<String>> dateToDescriptionsMap;

    public Table() {
        idToTaskMap = new HashMap<>();
        dateToDescriptionsMap = new HashMap<>();
    }

    public Integer getTableSize() {
        return idToTaskMap.size();
    }

    public void queryAll() {
        System.out.println("There Are " + this.getTableSize() + " Tasks in Total.");
        int cnt = 0;
        for (Integer key : this.idToTaskMap.keySet()) {
            cnt++;
            System.out.println(cnt + ". " + this.idToTaskMap.get(key).getDescription() +
                    " - " + this.idToTaskMap.get(key).getDateAsString());
        }
    }

    public void queryADay(Integer date) {
        ArrayList<String> tem = this.dateToDescriptionsMap.get(date);

        try {
            System.out.println("There Are " + tem.size() + " Tasks in Total.");
        } catch (NullPointerException e) {
            System.out.println("There Are 0 Tasks in Total.");
            return;
        }
        int cnt = 0;
        for (String str : tem) {
            cnt++;
            System.out.println(cnt + ". " + str);
        }
    }

    public void addTask(Task task) {
        Integer hash = (task.getDescription() + task.getDateAsString()).hashCode();
        if (idToTaskMap.containsKey(hash)) {
            new DuplicatedTaskException();
        } else {
            this.idToTaskMap.put(hash, task);
            ArrayList<String> tem = this.dateToDescriptionsMap.get(task.getDateAsInt());
            try {
                tem.add(task.getDescription());
            } catch (NullPointerException e) {
                tem = new ArrayList<>();
                tem.add(task.getDescription());
            }
            this.dateToDescriptionsMap.put(task.getDateAsInt(), tem);
            System.out.println("* Added Successfully! *");
        }
    }

    public HashMap<Integer, Task> getIdToTaskMap() {
        return this.idToTaskMap;
    }

    public void removeTask(Task task) {
        this.idToTaskMap.remove((task.getDescription() + task.getDateAsString()).hashCode());
        int date = task.getDateAsInt();
        ArrayList<String> tem = this.dateToDescriptionsMap.get(date);
        tem.remove(task.getDescription());
        this.dateToDescriptionsMap.put(date, tem);
    }
}
