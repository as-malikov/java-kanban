package model;

public class SubTask extends Task {
    private Epic epic;

    public SubTask(String title, Status status, String description, Epic epic) {
        super(title, status, description);
        this.epic = epic;
    }

    public SubTask(String title, Status status, String description) {
        super(title, status, description);
    }

    public Epic getEpic() {
        return epic;
    }
}
