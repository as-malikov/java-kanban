package model;

import java.util.ArrayList;
import java.util.List;

public class Epic extends Task {
    List<SubTask> subTasks = new ArrayList<>();

    public Epic(String title, String description) {
        super(title, null, description);
    }

    public Epic(String title, Status status, String description) {
        super(title, status, description);
    }

    public List<SubTask> getSubTasks() {
        return subTasks;
    }

    public void setSubTasks(List<SubTask> subTasks) {
        this.subTasks = subTasks;
    }

    public void addTasks(SubTask subTask) {

    }

    public void removeTask(SubTask subTask) {

    }

    public void updateTasks(SubTask subTask) {
        status = Status.NEW;
    }

    public void updateStatus() {
    }
}
