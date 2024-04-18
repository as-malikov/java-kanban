package model;

import java.util.ArrayList;
import java.util.List;

public class Epic extends Task {
    private List<SubTask> subTasks = new ArrayList<>();

    public Epic(String title, String description) {
        super(title, description);
    }

    public Epic(String title, Status status, String description) {
        super(title, description);
        super.status = status;
    }

    public List<SubTask> getSubTasks() {
        return subTasks;
    }

    public void addTasks(SubTask subTask) {

    }

    public void removeTask(SubTask subTask) {

    }

    public void updateTasks(SubTask subTask) {
        status = Status.NEW;
    }

    public void updateStatus() {
        if (status == Status.DONE) {
            status = Status.IN_PROGRESS;
        }
    }

    @Override
    public String toString() {
        return "Epic{" +
                "id=" + getId() +
                ", title='" + getTitle() + '\'' +
                ", status=" + status +
                ", description='" + getDescription() + '\'' +
                '}';
    }
}
