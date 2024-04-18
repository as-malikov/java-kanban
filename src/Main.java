import model.Epic;
import model.Status;
import model.SubTask;
import model.Task;
import service.TaskManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Main {

    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager();

        // Test creating objects Task, Epic, SubTask
        Task task1 = taskManager.create(new Task("Новая задача 1", "описание задачи 1"));
        System.out.println("Create task 1: " + task1);

        Task task2 = taskManager.create(new Task("Новая задача 2", "описание задачи 2"));
        System.out.println("Create task 2: " + task2);

        Epic epic1 = taskManager.createEpic(new Epic("Новый эпик 1", "описание эпика 1"));
        System.out.println("Create epic 1: " + epic1);

        Epic epic2 = taskManager.createEpic(new Epic("Новый эпик 2", Status.NEW, "описание эпика 2"));
        System.out.println("Create epic 2: " + epic2);

        SubTask subTask1 = taskManager.createSubTask(new SubTask("Новая подзадача 1", Status.NEW, "описание подзадачи 1", epic1));
        System.out.println("Create subTask 1: " + subTask1);

        SubTask subTask2 = taskManager.createSubTask(new SubTask("Новая подзадача 2", Status.NEW, "описание подзадачи 2", epic2));
        System.out.println("Create subTask 2: " + subTask2);
        System.out.println();

        // Get full list Task, Epic, SubTask
        System.out.println("Список всех задач:");
        printAllTasks(taskManager.getAll());
        System.out.println("Список всех эпиков:");
        printAllEpics(taskManager.getAllEpics());
        System.out.println("Список всех подзадач:");
        printAllSubTasks(taskManager.getAllSubTasks());
        System.out.println();

        // Get by id Task, Epic, SubTask
        System.out.println("Get task by id: " + taskManager.get(1));
        System.out.println("Get epic by id: " + taskManager.getEpic(3));
        System.out.println("Get subTask by id: " + taskManager.getSubTask(5));
        System.out.println();

        // Delete by id Task, Epic, SubTask
        taskManager.deleteById(1);
        taskManager.deleteEpicById(2);
        taskManager.deleteSubTaskById(5);

        // Get full list Task, Epic, SubTask
        System.out.println("Список всех задач, после удаления по ID:");
        printAllTasks(taskManager.getAll());
        System.out.println("Список всех эпиков, после удаления по ID:");
        printAllEpics(taskManager.getAllEpics());
        System.out.println("Список всех подзадач, после удаления по ID:");
        printAllSubTasks(taskManager.getAllSubTasks());
        System.out.println();

        // Deleting all Task, Epic, SubTask
        taskManager.deleteAll();
        taskManager.deleteAllEpics();

        // Get full list Task, Epic, SubTask
        System.out.println("Список всех задач, после удаления всех задач:");
        printAllTasks(taskManager.getAll());
        System.out.println("Список всех эпиков, после удаления всех эпиков:");
        printAllEpics(taskManager.getAllEpics());
        System.out.println("Список всех подзадач, после удаления всех подзадач:");
        printAllSubTasks(taskManager.getAllSubTasks());




//        Task taskFromManager = taskManager.get(task.getId());
//        System.out.println("Get task: " + taskFromManager);
//
//        taskFromManager.setTitle("New title");
//        taskManager.update(taskFromManager);
//        System.out.println("Update task: " + taskFromManager);
//
//        Task taskUpdate = new Task(taskFromManager.getId(), "Новая задача Обновление", Status.DONE, taskFromManager.getDescription());
//
//        taskManager.delete(taskFromManager.getId());
//        System.out.println("Delete: " + task);
//
//        Epic epic = taskManager.createEpic(new Epic("Новый эпик", Status.NEW, "Описание"));
//        System.out.println("Create epic: " + epic);
//
//        SubTask subTask = taskManager.createSubTask(new SubTask("Новая подзадача", Status.IN_PROGRESS, "Новое описание подзадачи", epic));
//        System.out.println("Create subTask: " + subTask);



    }

    static void printAllTasks(List<Task> tasks) {
        for (Object task : tasks) {
            System.out.println(task);
        }
    }

    static void printAllEpics(List<Epic> epics) {
        for (Object epic : epics) {
            System.out.println(epic);
        }
    }

    static void printAllSubTasks(List<SubTask> subTasks) {
        for (Object subTask : subTasks) {
            System.out.println(subTask);
        }
    }

}
