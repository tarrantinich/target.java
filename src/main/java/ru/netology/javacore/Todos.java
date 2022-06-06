package ru.netology.javacore;

import java.util.*;

public class Todos {
    private List<String> tasks = new ArrayList<>();

    public void setTasks(List<String> tasks) {
        this.tasks = tasks;
    }

    public List<String> getTasks() {
        return tasks;
    }

    public List<String> addTask(String task) {
        tasks.add(task);
        return tasks;
    }

    public List<String> removeTask(String task) {
        tasks.remove(task);
        return tasks;
    }

    public String getAllTasks() {
        tasks.sort((String o1, String o2) -> o1.toString().compareTo(o2.toString()));
        String actualTasks = "";
        for (String task : tasks) {
            if (task != tasks.get(tasks.size() - 1)) {
                actualTasks += task + " ";
            } else {
                actualTasks += task;
            }
        }
        return actualTasks;
    }

    public String toString() {
        StringBuilder stb = new StringBuilder();
        for (int i = 0; i < tasks.size(); i++) {
            stb.append(tasks.get(i)).append(String.format(" "));
        }
        return stb.toString();
    }
}
