package service;

import model.Epic;
import model.Status;
import model.SubTask;
import model.Task;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

public class InMemoryTaskManagerTest {
    InMemoryTaskManager memoryTaskManager;
    private Epic epic;

    // Checking create - Task, Epic, SubTask
    @BeforeEach
    @DisplayName("Задача, эпик и подзадача должны быть созданы")
    void init() {
        memoryTaskManager = new InMemoryTaskManager(Managers.getDefaultHistory());
        memoryTaskManager.create(new Task("new task", "desc")); // id = 0
        epic = memoryTaskManager.createEpic(new Epic("new epic", "desc")); // id = 1
        memoryTaskManager.createSubTask(new SubTask("new subTask", "desc", epic)); // id = 2
    }

    // Checking Managers
    @Test
    @DisplayName("Менеджеры должны совподать")
    void taskManagers() {
        InMemoryTaskManager inMemoryTaskManager = new InMemoryTaskManager(Managers.getDefaultHistory());
        inMemoryTaskManager.create(new Task("new task", "desc")); // id = 0
        Epic epic2 = inMemoryTaskManager.createEpic(new Epic("new epic", "desc")); // id = 1
        inMemoryTaskManager.createSubTask(new SubTask("new subTask", "desc", epic2)); // id = 2
        assertEqualsTaskManager(inMemoryTaskManager, memoryTaskManager, "Менеджеры должны совподать");
    }

    // Checking get by Id and create - Task, Epic, SubTask
    @Test
    @DisplayName("Задача должна совподать с полученой задачей")
    void shouldGetTask() {
        Task taskExpected = memoryTaskManager.create(new Task("new task", "desc"));
        Task actual = memoryTaskManager.get(0);
        assertEqualsTask(taskExpected, actual, "Таски должны совподать");
    }

    @Test
    @DisplayName("Эпик должен совподать с полученым эпиком")
    void shouldGetEpic() {
        Epic epicExpected = memoryTaskManager.createEpic(new Epic("new epic", "desc"));
        Epic actual = memoryTaskManager.getEpic(1);
        assertEqualsTask(epicExpected, actual, "Эпики должны совподать");
    }

    @Test
    @DisplayName("Подзадача должна совподать с полученой подзадачей")
    void shouldGetSubTask() {
        SubTask subTaskExpected = memoryTaskManager.createSubTask(new SubTask("new subTask", "desc", epic));
        SubTask actual = memoryTaskManager.getSubTask(2);
        assertEqualsTask(subTaskExpected, actual, "Подзадача должена совподать с полученой подзадачей");
    }

    // Checking get SubTasks by Id
    @Test
    @DisplayName("Подзадачи в эпике должны совподать с получеными подзадачами")
    void shouldGetSubTasksById() {
        Epic epicExpected = memoryTaskManager.createEpic(new Epic("new epic", "desc"));
        SubTask subTaskExpected = memoryTaskManager.createSubTask(new SubTask("new subTask", "desc", epicExpected));
        List<SubTask> subTasksExpected = epicExpected.getSubTasks();
        List<SubTask> actual = memoryTaskManager.getSubTasksById(1);
        for (SubTask subTask : actual) {
            assertEqualsTask(subTaskExpected, subTask, "Подзадачи в эпике должены совподать с " +
                    "получеными подзадачами");
        }
    }

    // Checking update  - Task, Epic, SubTask
    @Test
    @DisplayName("Задача должна быть обновлена")
    void shouldUpdateTask() {
        Task currentTask = memoryTaskManager.getAll().getFirst();
        Task taskExpected = new Task(currentTask.getId(), "update task", Status.NEW, "update desc");
        memoryTaskManager.update(taskExpected);
        Task actual = memoryTaskManager.getAll().getFirst();
        assertEqualsTask(taskExpected, actual, "Задача должна обновиться");
    }

    @Test
    @DisplayName("Эпик должен быть обновлен")
    void shouldUpdateEpic() {
        Epic currentEpic = memoryTaskManager.getAllEpics().getFirst();
        Epic epicExpected = new Epic(currentEpic.getId(), "update epic", Status.IN_PROGRESS, "update desc",
                currentEpic.getSubTasks());
        memoryTaskManager.updateEpic(epicExpected);
        Epic actual = memoryTaskManager.getAllEpics().getFirst();
        assertEqualsTask(epicExpected, actual, "Эпик должен обновиться");
    }

    @Test
    @DisplayName("Подзадача должна быть обновлена")
    void shouldUpdateSubTask() {
        SubTask currentSubTask = memoryTaskManager.getAllSubTasks().getFirst();
        SubTask subTaskExpected = new SubTask(currentSubTask.getId(), "update subTask", Status.DONE,
                "update desc", currentSubTask.getEpic());
        memoryTaskManager.updateSubTask(subTaskExpected);
        SubTask actual = memoryTaskManager.getAllSubTasks().getFirst();
        assertEqualsTask(subTaskExpected, actual, "Эпик должен обновиться");
    }

    // Checking get all -  Task, Epic, SubTask
    @Test
    @DisplayName("Должны получить все задачи")
    void shouldGetAllTasks() {
        int countTaskExpected = memoryTaskManager.getAll().size();
        int countActual = 1;
        assertEquals(countTaskExpected, countActual, "Должен получить все задачи");
    }

    @Test
    @DisplayName("Должны получить все эпики")
    void shouldGetAllEpics() {
        int countEpicExpected = memoryTaskManager.getAllEpics().size();
        int countActual = 1;
        assertEquals(countEpicExpected, countActual, "Должен получить все эпики");
    }

    @Test
    @DisplayName("Должны получить все подзадачи")
    void shouldGetAllSubTasks() {
        int countSubTaskExpected = memoryTaskManager.getAllSubTasks().size();
        int countActual = 1;
        assertEquals(countSubTaskExpected, countActual, "Должен получить все подзадачи");
    }

    // Checking delete all -  Task, Epic, SubTask
    @Test
    @DisplayName("Должны удалить все задачи")
    void shouldDeleteAllTasks() {
        memoryTaskManager.deleteAll();
        int countTaskExpected = memoryTaskManager.getAll().size();
        int countActual = 0;
        assertEquals(countTaskExpected, countActual, "Должен удалить все задачи");
    }

    @Test
    @DisplayName("Должны удалить все эпики")
    void shouldDeleteAllEpics() {
        memoryTaskManager.deleteAllEpics();
        int countEpicExpected = memoryTaskManager.getAllEpics().size();
        int countActual = 0;
        assertEquals(countEpicExpected, countActual, "Должен удалить все эпики");
    }

    @Test
    @DisplayName("Должны удалить все подзадачи")
    void shouldDeleteAllSubTasks() {
        memoryTaskManager.deleteAllSubTasks();
        int countSubTaskExpected = memoryTaskManager.getAllSubTasks().size();
        int countActual = 0;
        assertEquals(countSubTaskExpected, countActual, "Должен удалить все подзадачи");
    }

    // Checking delete by ID -  Task, Epic, SubTask
    @Test
    @DisplayName("Должен удалить задачу по id")
    void shouldDeleteByIdTasks() {
        memoryTaskManager.deleteById(0);
        int countTaskExpected = memoryTaskManager.getAll().size();
        int countActual = 0;
        assertEquals(countTaskExpected, countActual, "Должен удалить все задачи");
    }

    @Test
    @DisplayName("Должен удалить эпик по id")
    void shouldDeleteByIdEpics() {
        memoryTaskManager.deleteEpicById(1);
        int countEpicExpected = memoryTaskManager.getAllEpics().size();
        int countActual = 0;
        assertEquals(countEpicExpected, countActual, "Должен удалить эпик по id");
    }

    @Test
    @DisplayName("Должен удалить подзадачи по id")
    void shouldDeleteByIdSubTasks() {
        memoryTaskManager.deleteSubTaskById(2);
        int countSubTaskExpected = memoryTaskManager.getAllSubTasks().size();
        int countActual = 0;
        assertEquals(countSubTaskExpected, countActual, "Должен удалить подзадачи по id");
    }

    // Checking get history
    @Test
    @DisplayName("Должены получить список последних просмотренных 10 задач, эпиков, подзадач")
    void shouldGetHistory() {
        for (int i = 0; i < 4; i++) {
            memoryTaskManager.get(0);
            memoryTaskManager.getEpic(1);
            memoryTaskManager.getSubTask(2);
        }
        int countHistoryExpected = memoryTaskManager.getHistory().size();
        int countActual = 10;
        assertEquals(countHistoryExpected, countActual, "Должен получить список последних просмотренных " +
                "10 задач, эпиков, подзадач");
    }

    private static void assertEqualsTask(Task expected, Task actual, String message) {
        assertEquals(expected.getTitle(), actual.getTitle(), ", title");
        assertEquals(expected.getStatus(), actual.getStatus(), ", status");
        assertEquals(expected.getDescription(), actual.getDescription(), ", description");
    }

    private static void assertEqualsTaskManager(InMemoryTaskManager expected, InMemoryTaskManager actual,
                                                        String message) {
        assertEquals(expected.getAll().toString(), actual.getAll().toString(), message + ", tasks;");
        assertEquals(expected.getAllEpics().toString(), actual.getAllEpics().toString(), message + ", epics;");
        assertEquals(expected.getAllSubTasks().toString(), actual.getAllSubTasks().toString(), message + ", subTasks;");
    }
}
