package service;

import model.Epic;
import model.SubTask;
import model.Task;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InMemoryHistoryManagerTest {
    HistoryManager historyManager;
    InMemoryTaskManager memoryTaskManager;
    Task task;
    Epic epic;
    SubTask subTask;

    @BeforeEach
    void init() {
        historyManager = new InMemoryHistoryManager();
        memoryTaskManager = new InMemoryTaskManager(historyManager);
        task = new Task("new task", "desc");
        epic = memoryTaskManager.createEpic(new Epic("new epic", "desc"));
        subTask = (new SubTask("new subTask", "desc", epic));
    }

    @Test
    @DisplayName("Должен добавить и получить список из 10 последних просмотренных задач, эпиков, подзадач")
    void shouldAddToHistory() {
        for (int i = 0; i < 4; i++) {
            historyManager.add(task);
            historyManager.add(epic);
            historyManager.add(subTask);
        }
        int countHistoryExpected = historyManager.getAll().size();
        int countActual = 10;
        assertEquals(countHistoryExpected, countActual, "Должен добавить и получить список последних просмотренных 10 задач, эпиков, подзадач");
    }
}
