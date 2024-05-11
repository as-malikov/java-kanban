import model.Epic;
import model.Status;
import model.SubTask;
import model.Task;
import service.InMemoryHistoryManager;
import service.InMemoryTaskManager;
import service.TaskManager;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        TaskManager taskManager = new InMemoryTaskManager(new InMemoryHistoryManager());

        // Test 1. Creating objects Task, Epic, SubTask
        Task task1 = taskManager.create(new Task("Новая задача 1", "описание задачи 1"));
        Task task2 = taskManager.create(new Task("Новая задача 2", "описание задачи 2"));

        Epic epic1 = taskManager.createEpic(new Epic("Новый эпик 1", "описание эпика 1"));
        Epic epic2 = taskManager.createEpic(new Epic("Новый эпик 2", Status.NEW, "описание эпика 2"));

        SubTask subTask1 = taskManager.createSubTask(new SubTask("Новая подзадача 1", Status.NEW, "описание подзадачи 1", epic1));
        SubTask subTask2 = taskManager.createSubTask(new SubTask("Новая подзадача 2", Status.NEW, "описание подзадачи 2", epic2));
        SubTask subTask3 = taskManager.createSubTask(new SubTask("Новая подзадача 3", Status.NEW, "описание подзадачи 3", epic1));
        SubTask subTask4 = taskManager.createSubTask(new SubTask("Новая подзадача 4", Status.NEW, "описание подзадачи 4", epic2));
        SubTask subTask5 = taskManager.createSubTask(new SubTask("Новая подзадача 5", Status.NEW, "описание подзадачи 5", epic2));
        SubTask subTask6 = taskManager.createSubTask(new SubTask("Новая подзадача 6", Status.NEW, "описание подзадачи 6", epic2));
        SubTask subTask7 = taskManager.createSubTask(new SubTask("Новая подзадача 7", Status.NEW, "описание подзадачи 7", epic2));
        SubTask subTask8 = taskManager.createSubTask(new SubTask("Новая подзадача 8", Status.NEW, "описание подзадачи 8", epic2));


       /* // Test 2. Get full list Task, Epic, SubTask
        System.out.println(">>> Test 2. Get full list Task, Epic, SubTask");
        System.out.println("Список всех задач:");
        printAllTasks(taskManager.getAll());
        System.out.println("Список всех эпиков:");
        printAllEpics(taskManager.getAllEpics());
        System.out.println("Список всех подзадач:");
        printAllSubTasks(taskManager.getAllSubTasks());
        System.out.println();

        // Test 3. Update Task, Epic, SubTask
        System.out.println(">>> Test 3. Update Task, Epic, SubTask");
        Task taskUpdate = new Task(task2.getId(), "Обновленная задача 2", Status.IN_PROGRESS, "Обновленное описание задачи 2");
        taskManager.update(taskUpdate);
        System.out.println("Update task2: " + taskUpdate);

        Epic epicUpdate = new Epic(epic2.getId(), "Обновленный эпик 2", "Обновленное описание эпика 2", epic2.getSubTasks());
        taskManager.updateEpic(epicUpdate);
        System.out.println("Update epic2: " + epic2);

        SubTask subTaskUpdate1 = new SubTask(subTask1.getId(), "Обновленная подзадача 1", Status.DONE, "Обновленное описание подзадачи 1", subTask1.getEpic());
        taskManager.updateSubTask(subTaskUpdate1);
        System.out.println("Update subTask1: " + subTaskUpdate1);

        SubTask subTaskUpdate2 = new SubTask(subTask2.getId(), "Обновленная подзадача 2", Status.IN_PROGRESS, "Обновленное описание подзадачи 2", subTask2.getEpic());
        taskManager.updateSubTask(subTaskUpdate2);
        System.out.println("Update subTask2: " + subTaskUpdate2);

        SubTask subTaskUpdate3 = new SubTask(subTask3.getId(), "Обновленная подзадача 3", Status.DONE, "Обновленное описание подзадачи 3", subTask3.getEpic());
        taskManager.updateSubTask(subTaskUpdate3);
        System.out.println("Update subTask3: " + subTaskUpdate3);
        System.out.println();

        System.out.println("Список всех эпиков, после изменения статуса в подзадаче:");
        printAllEpics(taskManager.getAllEpics());
        System.out.println();

        System.out.println("Список всех подзадач, после изменения статуса в подзадаче:");
        printAllSubTasks(taskManager.getAllSubTasks());
        System.out.println();

        // Test 4. Get by id Task, Epic, SubTask
        System.out.println(">>> Test 4. Get by id Task, Epic, SubTask");
        System.out.println("Get task by id: " + taskManager.get(1));
        System.out.println("Get epic by id: " + taskManager.getEpic(3));
        System.out.println("Get subTask by id: " + taskManager.getSubTask(5));
        System.out.println("Get SubTasks by ID: " + taskManager.getSubTasksById(2));
        System.out.println();

        // Test 5 and 6. Delete by id Task, Epic, SubTask
        System.out.println(">>> Test 5 and 6. Delete by id and Get full list Task, Epic, SubTask");
        taskManager.deleteById(1);
        taskManager.deleteEpicById(2);
        taskManager.deleteSubTaskById(5);

        // Test 6. Get full list Task, Epic, SubTask
        System.out.println("Список всех задач, после удаления по ID:");
        printAllTasks(taskManager.getAll());
        System.out.println("Список всех эпиков, после удаления по ID:");
        printAllEpics(taskManager.getAllEpics());
        System.out.println("Список всех подзадач, после удаления по ID:");
        printAllSubTasks(taskManager.getAllSubTasks());
        System.out.println();

        // Test 7. Deleting all Task, SubTask
        System.out.println(">>> Test 7. Deleting all Task, SubTask");
        taskManager.deleteAll();
        taskManager.deleteAllSubTasks();

        System.out.println("Список всех задач, после удаления всех задач:");
        printAllTasks(taskManager.getAll());
        System.out.println("Список всех эпиков, после удаления всех подзадач:");
        printAllEpics(taskManager.getAllEpics());
        System.out.println("Список всех подзадач, после удаления всех подзадач:");
        printAllSubTasks(taskManager.getAllSubTasks());
        System.out.println();

        // Test 8. Deleting all Epic
        System.out.println(">>> Test 8. Deleting all Epic");
        taskManager.deleteAllEpics();
        System.out.println("Список всех эпиков, после удаления всех эпиков:");
        printAllEpics(taskManager.getAllEpics());*/

        // Checking get History
        taskManager.get(0);
        taskManager.get(1);

        taskManager.getEpic(2);
        taskManager.getEpic(3);

        taskManager.getSubTask(4);
        taskManager.getSubTask(5);
        taskManager.getSubTask(6);
        taskManager.getSubTask(7);
        taskManager.getSubTask(9);
        taskManager.getSubTask(10);
        taskManager.getSubTask(11);

        taskManager.get(0);
        taskManager.get(1);

        taskManager.getEpic(2);
        taskManager.getEpic(3);

        printAllTasks(taskManager);
    }

    private static void printAllTasks(TaskManager taskManager) {
        System.out.println("1) Задачи:");
        printAllTasks(taskManager.getAll());
        System.out.println("2) Эпики:");
        printAllEpics(taskManager.getAllEpics());
        System.out.println("3) Подзадачи:");
        printAllSubTasks(taskManager.getAllSubTasks());
        System.out.println("4) История:");
        printHistory(taskManager.getHistory());
    }

        static void printAllTasks(List<Task> tasks) {
        for (Task task : tasks) {
            System.out.println(task);
        }
    }

    static void printAllEpics(List<Epic> epics) {
        for (Epic epic : epics) {
            System.out.println(epic);
        }
    }

    static void printAllSubTasks(List<SubTask> subTasks) {
        for (SubTask subTask : subTasks) {
            System.out.println(subTask);
        }
    }

    static void printHistory(List<Task> histories) {
        for (Task history : histories) {
            System.out.println("- " + history);
        }
    }
}
