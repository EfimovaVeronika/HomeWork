package ru.geekbrains.lesson4;

import java.util.Random;
import java.util.Scanner;

public class MainHomeWork4 {
    public static int size;
    public static char[][] map;
    public static int dotToWin;
    public static int dotToWinMin = 3;
    public static int dotToWinMax = 6;
    public static int maxMap = 15;
    public static int minMap = 3;
    public static int x;
    public static int y;
    public static String currentPlayer;
    public static final char DOT_X = 'X';
    public static final char DOT_O = 'O';
    public static final String MAN = "Игрок";
    public static final String MACHINE = "Компьютер";
    public static final char DOT_EMPTY = '.';
    public static int minSymbolName = 2;
    public static String name;
    public static char currentSymbol;
    public static int counterDotToWin;
    public static final String DIRECTION_N = "N";
    public static final String DIRECTION_NE = "NE";
    public static final String DIRECTION_E = "E";
    public static final String DIRECTION_ES = "ES";
    public static final String DIRECTION_S = "S";
    public static final String DIRECTION_SW = "SW";
    public static final String DIRECTION_W = "W";
    public static final String DIRECTION_WN = "WN";

    public static Scanner console = new Scanner(System.in);
    public static Random random = new Random();


    public static void main(String[] args) {

        initGame();
        do {
            initMap();
            printMap();
            playGame();
        }
        while (restartGame());
    }

    // Инициализация поля и условия игры
    public static void initGame() {

        // Инициализация игрока
        System.out.println("Привет, Игрок! Представься!");
        name = console.nextLine();
        while (name.length() < minSymbolName) {
            System.out.println("Имя не может быть короче двух сиволов! Представься!");
            name = console.nextLine();
        }
        System.out.println("Привет, " + name);
    }

    // Инициализация поля игры
    public static void initMap() {
        // Инициализация поля игры
        System.out.println(name + ", укажи размер поля для игры (от " + minMap + " до " + maxMap + ").");
        size = console.nextInt();
        while (size < minMap || size > maxMap) {
            System.out.println("Поле для игры не может быть меньше " + minMap + " и больше " + maxMap + ". Введи правильную размерность!");
            size = console.nextInt();
        }

        // Инициализация количества фишек
        if (size == dotToWinMin) {
            System.out.println(name + ", тебе нужно собрать " + dotToWinMin + " фишки для победы.");
            size = dotToWinMin;
            dotToWin = dotToWinMin;
        }
        if (size > dotToWinMin && size <= dotToWinMax) {
            if (size <= dotToWinMax) {
                System.out.println(name + ", сколько фишек нужно собрать для победы? Выбери число от " + dotToWinMin + " до " + size + ".");
                dotToWin = console.nextInt();
                while (dotToWin < dotToWinMin || dotToWin > size) {
                    System.out.println("Ты выбрал не верное число. Выбери число от " + dotToWinMin + " до " + size + ".");
                    dotToWin = console.nextInt();
                }
            }
        }
        if (size > dotToWinMax) {
            System.out.println(name + ", сколько фишек нужно собрать для победы? Выбери число от " + dotToWinMin + " до " + dotToWinMax + ".");
            dotToWin = console.nextInt();
            while (dotToWin < dotToWinMin || dotToWin > dotToWinMax) {
                System.out.println("Ты выбрал не верное число. Выбери число от " + dotToWinMin + " до " + dotToWinMax + ".");
                dotToWin = console.nextInt();
            }
        }

        map = new char[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }

    // Заполнение поля игры
    public static void printMap() {
        System.out.print(" ");
        for (int i = 0; i < size; i++) {
            System.out.print("  " + (i + 1));
        }
        System.out.println();
        for (int i = 0; i < size; i++) {
            System.out.print((i + 1) + "  ");
            for (int j = 0; j < size; j++) {
                System.out.print(map[j][i] + "  ");
            }
            System.out.println();
        }
    }

    // Выбираем игрока, делающего первый ход. Возвращает MAN, если победил человек, MACHINE - если машина.
    public static String chooseFirstPlayer() {
        System.out.println("Кто будет ходить первым? Бросим жребий!");
        int randomHuman = random.nextInt(100);
        System.out.println(name + " выбрасывает " + randomHuman + "!");
        int randomMachine = random.nextInt(100);
        System.out.println(randomMachine + " выпало Компьютеру!");

        while (randomHuman == randomMachine) {
            System.out.println("Выпавшие числа равны! Пробуем еще раз!");
            randomHuman = random.nextInt(100);
            System.out.println(name + " выбрасывает " + randomHuman + "!");
            randomMachine = random.nextInt(100);
            System.out.println(randomMachine + " выпало Компьютеру!");
        }
        if (randomHuman > randomMachine) {
            System.out.println(name + " ходит первым(ой)!");

            return MAN;
        } else {
            System.out.println("Первым ходит компьютер!");

            return MACHINE;
        }
    }

    // Ход человека
    public static void playMan() {
        System.out.println("Введи координаты x, y");
        do {
            x = console.nextInt() - 1;
            y = console.nextInt() - 1;
        } while (!isCellValid());
        map[x][y] = currentSymbol;
        printMap();
    }

    // Ход компьютера
    public static void playMachine() {
        do {
            x = random.nextInt(size);
            y = random.nextInt(size);
        } while (!isCellValid());
        map[x][y] = currentSymbol;
        printMap();
        System.out.println("Компьютер походил в точку " + (x + 1) + " " + (y + 1));
    }

    // Ход игры
    public static void playGame() {
        currentPlayer = chooseFirstPlayer();
        currentSymbol = DOT_X;

        while (true) {
            if (currentPlayer.equals(MAN)) {
                playMan();
            }
            else {
                playMachine();
            }

            if (checkWin()) {
                System.out.println("Победил " + (currentPlayer.equals(MAN) ? "игрок - " + name + "!" : "Компьютер!"));
                return;
            }
            if (isMapFull()) {
                return;
            }

            currentPlayer = currentPlayer.equals(MACHINE) ? MAN : MACHINE;
            currentSymbol = currentSymbol == DOT_X ? DOT_O : DOT_X;
        }
    }

    // Проверка ячейка
    public static boolean isCellValid() {
        if (x < 0 || y < 0 || x >= size || y >= size) {
            return false;
        }
        if (map[x][y] == DOT_EMPTY) {
            return true;
        }
        return false;
    }

    // проверка на победу
    public static boolean checkWin() {
       counterDotToWin = 1;
       checkNeighbor(x, y, DIRECTION_N);
       if (dotToWin <= counterDotToWin) {
           return true;
       }
       else {
           checkNeighbor(x, y, DIRECTION_S);
           if (dotToWin <= counterDotToWin) {
               return true;
           }
       }

        counterDotToWin = 1;
        checkNeighbor(x, y, DIRECTION_E);
        if (dotToWin <= counterDotToWin) {
            return true;
        }
        else {
            checkNeighbor(x, y, DIRECTION_W);
            if (dotToWin <= counterDotToWin) {
                return true;
            }
        }

        counterDotToWin = 1;
        checkNeighbor(x, y, DIRECTION_NE);
        if (dotToWin <= counterDotToWin) {
            return true;
        }
        else {
            checkNeighbor(x, y, DIRECTION_SW);
            if (dotToWin <= counterDotToWin) {
                return true;
            }
        }

        counterDotToWin = 1;
        checkNeighbor(x, y, DIRECTION_ES);
        if (dotToWin <= counterDotToWin) {
            return true;
        }
        else {
            checkNeighbor(x, y, DIRECTION_WN);
            if (dotToWin <= counterDotToWin) {
                return true;
            }
        }
        return false;
    }

    // Метод для проверки на победу
    public static void checkNeighbor(int x, int y, String direction) {
        switch (direction) {
            case DIRECTION_N: {
                if ( y > 0 && map[x][y] == map[x][y - 1]) {
                    checkNeighbor(x, y - 1, DIRECTION_N);
                    counterDotToWin++;
                }
            } break;
            case DIRECTION_NE: {
                if ( y > 0 && x < size - 1 && map[x][y] == map[x + 1][y - 1]) {
                    checkNeighbor(x + 1, y - 1, DIRECTION_NE);
                    counterDotToWin++;
                }
            } break;
            case DIRECTION_E: {
                if ( x < size - 1  && map[x][y] == map[x + 1][y]) {
                    checkNeighbor(x + 1, y, DIRECTION_E);
                    counterDotToWin++;
                }
            } break;
            case DIRECTION_ES: {
                if ( y < size - 1 && x < size - 1 && map[x][y] == map[x + 1][y + 1]) {
                    checkNeighbor(x + 1, y + 1, DIRECTION_ES);
                    counterDotToWin++;
                }
            } break;
            case DIRECTION_S: {
                if ( y < size - 1  && map[x][y] == map[x][y + 1]) {
                    checkNeighbor(x, y + 1, DIRECTION_S);
                    counterDotToWin++;
                }
            } break;
            case DIRECTION_SW: {
                if ( y < size - 1 && x > 0 && map[x][y] == map[x - 1][y + 1]) {
                    checkNeighbor(x - 1, y + 1, DIRECTION_SW);
                    counterDotToWin++;
                }
            } break;
            case DIRECTION_W: {
                if ( x > 0 && map[x][y] == map[x - 1][y]) {
                    checkNeighbor(x - 1, y, DIRECTION_W);
                    counterDotToWin++;
                }
            } break;
            case DIRECTION_WN: {
                if ( y > 0 && x > 0 && map[x][y] == map[x - 1][y - 1]) {
                    checkNeighbor(x - 1, y - 1, DIRECTION_WN);
                    counterDotToWin++;
                }
            } break;
        }
    }

    // Перезапуск игры
    public static boolean restartGame() {
        String yesString = "да";
        System.out.println("Изволите повторить игру? да/нет");
        console.nextLine();
        String answer = console.nextLine();
        if (answer.equalsIgnoreCase(yesString)) {
            return true;
        }
        else {
            System.out.println("Ну ооооок =(");
            return false;
        }
    }

    // Проверка на ничью
    public static boolean isMapFull() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (map[i][j] == DOT_EMPTY) return false;
            }
        }
        System.out.println("Ничья!");
        return true;
    }

}





