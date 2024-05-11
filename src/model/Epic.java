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

    public Epic(int id, String title, String description, List<SubTask> subTasks) {
        super(id, title, description);
        this.subTasks = subTasks;
    }

    public Epic(int id, String title, Status status, String description, List<SubTask> subTasks) {
        super(id, title, description);
        this.status = status;
        this.subTasks = subTasks;
    }

    public List<SubTask> getSubTasks() {
        return subTasks;
    }

    public void addTasks(SubTask subTask) {
        subTasks.add(subTask);
    }

    public void removeTask(SubTask subTask) {
        subTasks.remove(subTask);
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
