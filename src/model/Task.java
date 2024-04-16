package model;

public class Task {
    private String title;
    private String description;
    private int id;
    SubTask subTask;

    public Task(String title, String description, int id, SubTask subTask) {
        this.title = title;
        this.description = description;
        this.id = id;
        this.subTask = subTask;
    }

}
