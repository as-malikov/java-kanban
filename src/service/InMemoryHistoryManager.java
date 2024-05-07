package service;

import model.Task;

import java.util.List;

public class InMemoryHistoryManager implements HistoryManager {
    @Override
    public void add(Task task) {
            task.getClass();
    }

    @Override
    public List<Task> getAll() {
        return List.of();
    }
}