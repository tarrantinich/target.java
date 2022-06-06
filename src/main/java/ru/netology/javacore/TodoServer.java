//package ru.netology.javacore;
//
//import com.google.gson.Gson;
package ru.netology.javacore;

import com.google.gson.Gson;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TodoServer {
    private int port;
    private Todos todos;

    public TodoServer(int port, Todos todos) {
        this.port = port;
        this.todos = todos;
    }

    public void start() throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(8989);) { // стартуем сервер один(!) раз
            while (true) { // в цикле(!) принимаем подключения
                try (
                        Socket socket = serverSocket.accept();
                        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                        PrintWriter out = new PrintWriter(socket.getOutputStream());
                ) {
                    // обработка одного подключения
                    System.out.println("New connection accepted");
                    String name = in.readLine();
                    Gson g = new Gson();
                    JsonTask jsonTask = g.fromJson(name, JsonTask.class);
                    if (jsonTask.getType().equals("ADD")) {
                        todos.addTask(jsonTask.getTask());
                    } else if (jsonTask.getType().equals("REMOVE")) {
                        todos.removeTask(jsonTask.getTask());
                    }
                    out.println(todos.getAllTasks());
                }
            }
        } catch (IOException e) {
            System.out.println("Не могу стартовать сервер");
            e.printStackTrace();
        }
    }
}
