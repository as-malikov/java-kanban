package service;

import model.Epic;
import model.Status;
import model.SubTask;
import model.Task;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class InMemoryTaskManager implements TaskManager {
    HashMap<Integer, Task> tasks;
    HashMap<Integer, Epic> epics;
    HashMap<Integer, SubTask> subTasks;
    private final HistoryManager historyManager;

    private int seq = 0;

    public InMemoryTaskManager(HistoryManager historyManager) {
        this.historyManager = historyManager;
        this.tasks = new HashMap<>();
        this.epics = new HashMap<>();
        this.subTasks = new HashMap<>();
    }

    // Creating objects Task, Epic, SubTask
    @Override
    public Task create(Task task) {
        task.setId(generateId());
        tasks.put(task.getId(), task);
        return task;
    }

    @Override
    public Epic createEpic(Epic epic) {
        epic.setId(generateId());
        epics.put(epic.getId(), epic);
        return epic;
    }

    @Override
    public SubTask createSubTask(SubTask subTask) {
        subTask.setId(generateId());
        subTasks.put(subTask.getId(), subTask);
        Epic epic = epics.get(subTask.getEpic().getId());
        epic.addTasks(subTask);
        calculateStatus(epic);
        return subTask;
    }

    private int generateId() {
        return seq++;
    }

    // Get Task, Epic, SubTask and SubTasks by id
    @Override
    public Task get(int id) {
        return tasks.get(id);
    }

    @Override
    public Epic getEpic(int id) {
        return epics.get(id);
    }

    @Override
    public SubTask getSubTask(int id) {
        return subTasks.get(id);
    }

    @Override
    public ArrayList<SubTask> getSubTasksById(int id) {
        return new ArrayList<SubTask>(epics.get(id).getSubTasks());
    }

    // Update Task, Epic, SubTask
    @Override
    public void update(Task task) {
        if (tasks.get(task.getId()) == null) {
            return;
        }
        tasks.put(task.getId(), task);
    }

    @Override
    public void updateEpic(Epic epic) {
        Epic saved = epics.get(epic.getId());
        if (saved == null) {
            return;
        }
        saved.setTitle(epic.getTitle());
        saved.setDescription(epic.getDescription());
    }

    @Override
    public void updateSubTask(SubTask subTask) {
        Epic epic = subTask.getEpic();
        Epic savedEpic = epics.get(epic.getId());
        if (savedEpic == null) {
            return;
        }
        epic.removeTask(subTasks.get(subTask.getId()));
        subTasks.put(subTask.getId(), subTask);
        epic.addTasks(subTask);
        calculateStatus(epic);
    }

    // Get full list Task, Epic, SubTask
    @Override
    public List<Task> getAll() {
        return new ArrayList<>(tasks.values());
    }

    @Override
    public List<Epic> getAllEpics() {
        return new ArrayList<>(epics.values());
    }

    @Override
    public List<SubTask> getAllSubTasks() {
        return new ArrayList<>(subTasks.values());
    }

    // Full deleting  Task, Epic, SubTask
    @Override
    public void deleteAll() {
        tasks.clear();
    }

    @Override
    public void deleteAllEpics() {
        epics.clear();
        subTasks.clear();
    }

    @Override
    public void deleteAllSubTasks() {
        subTasks.clear();
        for (Epic epic : epics.values()) {
            epic.getSubTasks().clear();
        }
    }

    // Deleting by id Task, Epic, SubTask
    @Override
    public void deleteById(int id) {
        tasks.remove(id);
    }

    @Override
    public void deleteEpicById(int id) {
        Epic epic = epics.get(id);
        if (epic == null) {
            return;
        }

        for (SubTask subTask : epic.getSubTasks()) {
            subTasks.remove(subTask.getId());
        }
        epics.remove(id);
    }

    @Override
    public void deleteSubTaskById(int id) {
        SubTask removeSubTask = subTasks.remove(id);

        Epic epic = removeSubTask.getEpic();
        Epic epicSaved = epics.get(epic.getId());

        epicSaved.getSubTasks().remove(removeSubTask);
        calculateStatus(epicSaved);
    }

    private void calculateStatus(Epic epic) {
        if (epic.getSubTasks().isEmpty()) {
            epic.setStatus(Status.NEW);
            return;
        }

        int countStatusDone = 0;
        int countStatusNew = 0;

        for (SubTask subTask : epic.getSubTasks()) {
            if (subTask.getStatus() == Status.DONE) {
                countStatusDone++;
            } else if (subTask.getStatus() == Status.NEW) {
                countStatusNew++;
            }
        }

        if (countStatusNew == epic.getSubTasks().size()) {
            epic.setStatus(Status.NEW);
        } else if (countStatusDone == epic.getSubTasks().size()) {
            epic.setStatus(Status.DONE);
        } else {
            epic.setStatus(Status.IN_PROGRESS);
        }
    }
}
