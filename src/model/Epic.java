package model;

import java.util.ArrayList;
import java.util.List;

public class Epic extends Task {
    List<SubTask> subTasks = new ArrayList<>();

    public Epic(String title, String description, Status status) {
        super(title, description, status);
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

}
