package service;

import model.Task;

import java.util.ArrayList;
import java.util.List;

public class InMemoryHistoryManager implements HistoryManager {
    private final List<Task> history = new ArrayList<>();
    private static final int SIZE_OF_HISTORY = 10;

    @Override
    public void add(Task task) {
        if (task == null) {
            return;
        }
        int countTasks = history.size();
        if (countTasks == SIZE_OF_HISTORY) {
            history.removeFirst();
        }
        history.add(task);
    }

    @Override
    public List<Task> getAll() {
        return new ArrayList<>(history);
    }
}