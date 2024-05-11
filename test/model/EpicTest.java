package model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Эпик")
public class EpicTest {
    private Epic epic;
    private Epic epicExpected;
    private SubTask subTask;

    @BeforeEach
    void init() {
        epic = new Epic("name", Status.NEW, "desc");
        epicExpected = new Epic("name", Status.NEW, "desc");
        subTask = new SubTask("nameSubTask", Status.NEW, "desc", epic);
    }

    @Test
    @DisplayName("должен совподать с своей копией")
    void shouldEqualsWithCopy() {
        assertEqualsTask(epicExpected, epic, "Эпики должны совподать");
    }

    private static void assertEqualsTask(Task expected, Task actual, String message) {
        assertEquals(expected.getId(), actual.getId(), message + ", id");
        assertEquals(expected.getTitle(), actual.getTitle(), message + ", title");
        assertEquals(expected.getDescription(), actual.getDescription(), message + ", description");
    }

    @Test
    @DisplayName("должен вернуть пустой список подзадач в эпике")
    void shouldGetSubTasks() {
        assertEquals(epic.getSubTasks().size(), 0, "Должен вернуть пустой список подзадач в эпике");
    }

    @Test
    @DisplayName("одна подзадача должна добавляться в эпик")
    void shouldAddOneSubTask() {
        epic.addTasks(subTask);
        assertEquals(epic.getSubTasks().size(), 1, "Должна добавиться одна подзадача в эпик");
    }

    @Test
    @DisplayName("должна удалится одна подзадача")
    void shouldRemoveOneSubTask() {
        epic.removeTask(subTask);
        assertEquals(epic.getSubTasks().size(), 0, "Должна удалится одна подзадача");
    }
}
