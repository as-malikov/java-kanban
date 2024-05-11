package model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Таск")
public class TaskTest {
    private Task task;
    private Task taskExpected;

    @BeforeEach
    void init() {
        task = new Task("name",  "desc");
        taskExpected = new Task("name", "desc");
    }

    @Test
    @DisplayName("должен совподать с своей копией")
    void shouldEqualsWithCopy() {
        assertEqualsTask(taskExpected, task, "Таски должны совподать");
    }

    private static void assertEqualsTask(Task expected, Task actual, String message) {
        assertEquals(expected.getId(), actual.getId(), message + ", id");
        assertEquals(expected.getTitle(), actual.getTitle(), message + ", title");
        assertEquals(expected.getDescription(), actual.getDescription(), message + ", description");
    }
}
