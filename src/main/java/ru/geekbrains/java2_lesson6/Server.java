package ru.geekbrains.java2_lesson6;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    private static final int PORT = 8189;

    private static ServerSocket socketListener;
    private static Socket socket;

    public static void main(String[] args) {
        try {
            socketListener = new ServerSocket(PORT);
            System.out.println("Сервер запущен");

            socket = socketListener.accept();
            System.out.println("Клиент подключился");

            Thread receiveThread = new Thread(() -> {
                while (true) {
                    try {
                        String str = new BufferedReader(new InputStreamReader(socket.getInputStream())).readLine();
                        System.out.println("Клиент: " + str);
                    } catch (IOException e) {
                        try {
                            socket.close();
                            System.out.println("Соединение с клиентом потеряно");

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
        } finally {
            try {
                socket.close();
                socketListener.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
