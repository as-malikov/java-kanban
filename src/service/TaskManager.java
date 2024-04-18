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

    private int seq = 0;

    public TaskManager() {
        this.tasks = new HashMap<>();
        this.epics = new HashMap<>();
        this.subTasks = new HashMap<>();
    }

    // Creating objects Task, Epic, SubTask
    public Task create(Task task) {
        task.setId(generateId());
        tasks.put(task.getId(), task);
        return task;
    }

    public Epic createEpic(Epic epic) {
        epic.setId(generateId());
        epics.put(epic.getId(), epic);
        return epic;
    }

    public SubTask createSubTask(SubTask subTask) {
        subTask.setId(generateId());
        subTasks.put(subTask.getId(), subTask);
        Epic epic = epics.get(subTask.getEpic().getId());
        epic.addTasks((subTask));
        epic.updateStatus();
        return subTask;
    }

    public int generateId() {
        return seq++;
    }

    public Task get(int id) {
        return tasks.get(id);
    }

    public Epic getEpic(int id) {
        return epics.get(id);
    }

    public SubTask getSubTask(int id) {
        return subTasks.get(id);
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
        saved.setDescription(epic.getDescription());
        // ... вычислить статус и проверить подзадачи
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

    // Get full list Task, Epic, SubTask
    public List<Task> getAll() {
        return new ArrayList<>(tasks.values());
    }

    public List<Epic> getAllEpics() {
        return new ArrayList<>(epics.values());
    }

    public List<SubTask> getAllSubTasks() {
        return new ArrayList<>(subTasks.values());
    }

    // Full deleting  Task, Epic, SubTask
    public void deleteAll() {
        tasks.clear();
    }

    public void deleteAllEpics() {
        epics.clear();
        deleteAllSubTasks();
    }

    public void deleteAllSubTasks() {
        subTasks.clear();
    }

    // Deleting by id Task, Epic, SubTask
    public void deleteById(int id) {
        tasks.remove(id);
    }

    public void deleteEpicById(int id) {
        epics.remove(id);
    }

    public void deleteSubTaskById(int id) {
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
