package service;

import model.Epic;
import model.Status;
import model.SubTask;
import model.Task;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TaskManager {
    private HashMap<Integer, Task> tasks;
    private HashMap<Integer, Epic> epics;
    private HashMap<Integer, SubTask> subTasks;

    private int id = 0;

    public TaskManager() {
        this.tasks = new HashMap<>();
    }

    public Task create(Task task) {
        task.setId(generateId());
        tasks.put(task.getId(), task);
        return task;
    }

    public int generateId() {
        return id++;
    }

    public Task get(int id) {
        return tasks.get(id);
    }

    public void update(Task task) {
        tasks.put(task.getId(), task);
//        Task saved = tasks.get(task.getId());
//        saved.setTitle(task.getTitle());
//        saved.setStatus(task.getStatus());
//        saved.setDescription(task.getDescription());
    }

    public void updateEpic(Epic epic) {
//        Epic saved = epics.get(epic.getId());
//        epic.setStatus(saved.getStatus());
//        epic.setSubTasks(saved.getSubTasks());
//        epics.put(epic.getId(), epic);
        Epic saved = epics.get(epic.getId());
        if (saved == null) {
            return;
        }

        saved.setTitle(epic.getTitle());
        // ...
    }

    public  void updateSubTask(SubTask subTask) {
        Epic epic = subTask.getEpic();
        Epic savedEpic = epics.get(epic.getId());
        if (savedEpic == null) {
            return;
        }
        // TODO
//        calculateStatus(saveEpic);
        savedEpic.updateStatus();
        // ...
    }

    public List<Task> getAll() {
        return new ArrayList<>(tasks.values());
    }

    public void delete(int id) {
        tasks.remove(id);
    }

    public void deleteSubTask(int id) {
        SubTask removeSubTask = subTasks.remove(id);

        Epic epic = removeSubTask.getEpic();
        Epic epicSaved = epics.get(epic.getId());

        epicSaved.getSubTasks().remove(removeSubTask);
        calculateStatus(epicSaved);
    }

    private void calculateStatus(Epic epic) {
        epic.setStatus(Status.NEW);// TODO
    }

}
