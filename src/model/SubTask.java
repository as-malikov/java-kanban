package model;

public class SubTask extends Task {
    private Epic epic;

    public SubTask(String title, Status status, String description, Epic epic) {
        super(title, description);
        this.epic = epic;
    }

    public SubTask(String title, Status status, String description) {
        super(title, description);
        super.status = status;
    }

    public Epic getEpic() {
        return epic;
    }

    @Override
    public String toString() {
        return "SubTask{" +
                "id=" + getId() +
                ", title='" + getTitle() + '\'' +
                ", status=" + status +
                ", description='" + getDescription() + '\'' +
                ", \nepic=" + epic +
                '}';
    }
}
