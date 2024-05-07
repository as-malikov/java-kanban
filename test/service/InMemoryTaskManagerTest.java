package service;

import model.Task;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Collections;
import java.util.List;

public class InMemoryTaskManagerTest {
    InMemoryTaskManager memoryTaskManager;
    private Task task;

//    @Test
//    void taskManager() {
//        EmptyHistoryManager historyManager = new EmptyHistoryManager();
//        InMemoryTaskManager inMemoryTaskManager = new InMemoryTaskManager(historyManager);
//
//        assertEqualsTaskManager(inMemoryTaskManager, memoryTaskManager, "Менеджеры должны совпадать");
//        assertEqualsInMemoryTaskManager(inMemoryTaskManager, memoryTaskManager, "Менеджеры должны совпадать");
//    }

    @BeforeEach
    void init() {
        EmptyHistoryManager historyManager = new EmptyHistoryManager();
        memoryTaskManager = new InMemoryTaskManager(historyManager);
        task = memoryTaskManager.create(new Task("Новая задача 1", "описание задачи 1"));
    }

    @Test
    void shouldGetTasks() {
        // подготовка данных
        // тестируем
        List<Task> all = memoryTaskManager.getAll();
        // проверяем
        assertEquals(all.size(), 1);
        assertEquals(all.get(0), task);
    }

    private static void assertEqualsInMemoryTaskManager(InMemoryTaskManager expected, InMemoryTaskManager actual, String message) {
        assertEquals(expected.tasks, actual.tasks, message + ", tasks");
    }

    private static void assertEqualsTaskManager(TaskManager expected, TaskManager actual, String message) {
        assertEquals(expected.getAll(), actual.getAll(), message + ", tasks");
    }

    private static class EmptyHistoryManager implements HistoryManager {
        @Override
        public List<Task> getAll() {
            return Collections.emptyList();
        }

        @Override
        public void add(Task task) {
        }
    }
}
