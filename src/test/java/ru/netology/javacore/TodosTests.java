package ru.netology.javacore;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.*;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TodosTests {

    @ParameterizedTest
    @MethodSource("testSourse1")
    public void addTaskTest(String task, List<String> expected) {
        Todos todos = new Todos();
        List<String> result = todos.addTask(task);
        assertEquals(expected, result);
    }

    private static Stream<Arguments> testSourse1() {

        return Stream.of(
                Arguments.of("Учёба", Arrays.asList("Учёба")),
                Arguments.of("Работа", Arrays.asList("Работа"))
        );
    }

    @ParameterizedTest
    @MethodSource("testSourse2")
    public void removeTaskTest(String task, List<String> expected) {
        Todos todos = new Todos();
        todos.setTasks(new ArrayList<>(Arrays.asList("Учёба", "Работа", "Спорт")));
        List<String> result = todos.removeTask(task);
        assertEquals(expected, result);
    }

    private static Stream<Arguments> testSourse2() {
        return Stream.of(
                Arguments.of("Работа", new ArrayList<>(Arrays.asList("Учёба", "Спорт"))),
                Arguments.of("Спорт", new ArrayList<>(Arrays.asList("Учёба", "Работа")))
        );
    }

    @ParameterizedTest
    @MethodSource("testSourse3")
    public void getAllTasksTest(Todos todos, String expected) {
        todos.setTasks(new ArrayList<>(Arrays.asList("Учёба", "Работа", "Спорт", "Акробатика")));
        String result = todos.getAllTasks();
        assertEquals(expected, result);
    }

    private static Stream<Arguments> testSourse3() {
        Todos todos = new Todos();
        todos.setTasks(new ArrayList<>(Arrays.asList("Учёба", "Работа", "Спорт", "Акробатика")));
        return Stream.of(
                Arguments.of(todos, "Акробатика, Работа, Спорт, Учёба"));
    }
}
