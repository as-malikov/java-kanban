package service;

import model.SubTask;
import model.Task;

import java.util.ArrayList;
import java.util.List;

public class InMemoryHistoryManager implements HistoryManager {
    private final List<Task> history = new ArrayList<>();

    @Override
    public void add(Task task) {
        int countTasks = history.size();
        if(countTasks == 10) {
            history.removeFirst();
            history.add(task);
        } else if (countTasks < 10) {
            history.add(task);
        }
    }

    @Override
    public List<Task> getAll() {
        return history;
    }
}