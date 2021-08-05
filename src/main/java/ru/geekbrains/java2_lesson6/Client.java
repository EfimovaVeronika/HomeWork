package ru.geekbrains.java2_lesson6;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 8189);
            System.out.println("Подключено к серверу");

            Thread receiveThread = new Thread(() -> {
                while (true) {
                    try {
                        String str = new BufferedReader(new InputStreamReader(socket.getInputStream())).readLine();
                        System.out.println("Сервер: " + str);
                    } catch (IOException e) {
                        try {
                            socket.close();
                            System.out.println("Соединение с сервером потеряно");

                            break;
                        } catch (IOException ex) {
                            ex.printStackTrace();
                            break;
                        }
                    }
                }
            });


            Thread sendThread = new Thread(() -> {
                while (true) {
                    try {
                        Scanner scanner = new Scanner(System.in);
                        String str = scanner.nextLine();

                        PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
                        printWriter.println(str);

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });

            receiveThread.start();
            sendThread.setDaemon(true);
            sendThread.start();

            receiveThread.join();

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

}
