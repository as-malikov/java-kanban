package service;

public class TaskManager {


    int currentId = 0;

    public int generationId() {
        return currentId++;
    }

}
