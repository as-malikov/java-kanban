package model;

public class Task {
    private String title;
    public Status status;
    private String description;
    int id;

    public Task(String title,  Status status, String description) {
        this.title = title;
        this.status = status;
        this.description = description;
    }

    public Task(int id, String title, Status status, String description) {
        this.id = id;
        this.title = title;
        this.status = status;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
