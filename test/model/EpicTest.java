package model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Эпик")
public class EpicTest {
    @Test
    @DisplayName("должен совподать с своей копией")
    void shouldEqualsWithCopy() {
        Epic epic = new Epic("name", Status.NEW, "desc");
        Epic epicExpected = new Epic("name1", Status.NEW, "desc");
        assertEquals(epicExpected, epic, "Эпики должны совподать"); // НЕ ВЕРНО
        assertEqualsTask(epicExpected, epic, "Эпики должны совподать"); // ВЕРНО
    }
    private static void assertEqualsTask(Task expected, Task actual, String message) {
        assertEquals(expected.getId(), actual.getId(), message + ", id");
        assertEquals(expected.getTitle(), actual.getTitle(), message + ", title");
    }
}
