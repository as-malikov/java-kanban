package model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Эпик")
public class SubTaskTest {

    private Epic epic;
    private SubTask subTask;
    private SubTask subTaskExpected;

    @BeforeEach
    void init() {
        epic = new Epic("name", Status.NEW, "desc");
        subTask = new SubTask("name",  Status.NEW, "desc", epic);
        subTaskExpected = new SubTask("name", Status.NEW, "desc", epic);
    }

    @Test
    @DisplayName("должен совподать с своей копией")
    void shouldEqualsWithCopy() {
        assertEqualsTask(subTaskExpected, subTask, "Таски должны совподать");
    }

    private static void assertEqualsTask(Task expected, Task actual, String message) {
        assertEquals(expected.getId(), actual.getId(), message + ", id");
        assertEquals(expected.getTitle(), actual.getTitle(), message + ", title");
        assertEquals(expected.getDescription(), actual.getDescription(), message + ", description");
    }
}
