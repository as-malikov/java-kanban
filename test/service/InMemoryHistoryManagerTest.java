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


    @BeforeEach
    void init() {
        historyManager = new InMemoryHistoryManager();
        memoryTaskManager = new InMemoryTaskManager(historyManager);
        memoryTaskManager.create(new Task("new task", "desc"));
        Epic epic = memoryTaskManager.createEpic(new Epic("new epic", "desc"));
        memoryTaskManager.createSubTask(new SubTask("new subTask", "desc", epic));
    }

    @Test
    @DisplayName("Должен добавить и получить список из 10 последних просмотренных задач, эпиков, подзадач")
    void shouldAddToHistory() {
        for (int i = 0; i < 4; i++) {
            historyManager.add(memoryTaskManager.get(0));
            historyManager.add(memoryTaskManager.getEpic(1));
            historyManager.add(memoryTaskManager.getSubTask(2));
        }
        int countHistoryExpected = historyManager.getAll().size();
        int countActual = 10;
        assertEquals(countHistoryExpected, countActual, "Должен добавить и получить список последних просмотренных 10 задач, эпиков, подзадач");
    }
}
