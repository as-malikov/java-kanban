package service;

import model.Epic;
import model.SubTask;
import model.Task;

import java.util.ArrayList;
import java.util.List;

public interface TaskManager {
    // Creating objects Task, Epic, SubTask
    Task create(Task task);

    Epic createEpic(Epic epic);

    SubTask createSubTask(SubTask subTask);

    // Get Task, Epic, SubTask and SubTasks by id
    Task get(int id);

    Epic getEpic(int id);

    SubTask getSubTask(int id);

    ArrayList<SubTask> getSubTasksById(int id);

    // Update Task, Epic, SubTask
    void update(Task task);

    void updateEpic(Epic epic);

    void updateSubTask(SubTask subTask);

    // Get full list Task, Epic, SubTask
    List<Task> getAll();

    List<Epic> getAllEpics();

    List<SubTask> getAllSubTasks();

    // Full deleting  Task, Epic, SubTask
    void deleteAll();

    void deleteAllEpics();

    void deleteAllSubTasks();

    // Deleting by id Task, Epic, SubTask
    void deleteById(int id);

    void deleteEpicById(int id);

    void deleteSubTaskById(int id);

    List<Task> getHistory();
}
