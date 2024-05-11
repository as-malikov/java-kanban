package service;

import model.Epic;
import model.Status;
import model.SubTask;
import model.Task;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InMemoryHistoryManagerTest {
    InMemoryTaskManager memoryTaskManager;
    private Task task1;
    private Epic epic;
    private SubTask subTask;

    @BeforeEach
    void init() {
        HistoryManager historyManager = new InMemoryHistoryManager();
        memoryTaskManager = new InMemoryTaskManager(historyManager);
        task1 = memoryTaskManager.create(new Task("new task", "desc"));
        epic = memoryTaskManager.createEpic(new Epic("new epic", "desc"));
        subTask = memoryTaskManager.createSubTask(new SubTask("new subTask", "desc", epic));
    }

}
