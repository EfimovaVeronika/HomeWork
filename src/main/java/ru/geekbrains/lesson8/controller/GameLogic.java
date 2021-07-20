package ru.geekbrains.lesson8.controller;

import ru.geekbrains.lesson8.GameState;
import ru.geekbrains.lesson8.model.Direction;
import ru.geekbrains.lesson8.model.Gamer;
import ru.geekbrains.lesson8.model.WinLine;

import java.util.Random;

public class GameLogic {
    private final Random random = new Random();
    private final GameState gameState = GameState.getInstance();


    //Выбор первого игрока
    public Gamer chooseFirstPlayer() {

        int randomHuman = random.nextInt(100);
        int randomMachine = random.nextInt(100);

        while (randomHuman == randomMachine) {
            randomHuman = random.nextInt(100);
            randomMachine = random.nextInt(100);
        }
        if (randomHuman > randomMachine) {
            return Gamer.MAN;
        } else {
            return Gamer.MACHINE;
        }
    }

    // Ход компьютера
    public void playMachine() {
        int x;
        int y;

        do {
             x = random.nextInt(gameState.getMapSize());
             y = random.nextInt(gameState.getMapSize());
        } while (!isCellValid(x, y));

        gameState.getGameMap()[x][y] = gameState.getCurrentSymbol();
        gameState.changeCurrentSymbol();

        gameState.getLastMachineStep().setX(x);
        gameState.getLastMachineStep().setY(y);
    }

    //Ход человека
    public void playMan(int x, int y) {
        if (isCellValid(x, y)) {
            gameState.getGameMap()[x][y] = gameState.getCurrentSymbol();
            gameState.changeCurrentSymbol();
        }
    }

    // Проверка ячейки
    public boolean isCellValid(int x, int y) {
        if (gameState.getGameMap()[x][y] == null) {
            return true;
        }
        return false;
    }

    // проверка на победу
    public boolean checkWin(int x, int y) {
        WinLine winLine = new WinLine();
        winLine.setX1(x);
        winLine.setY1(y);
        
        winLine = checkNeighbor(x, y, Direction.N, winLine);
        if (gameState.getWinLineLength() <= winLine.getWinLineLength()) {
            gameState.setRealWinLine(winLine);
            return true;
        }
        else {
            winLine = checkNeighbor(x, y, Direction.S, winLine);
            if (gameState.getWinLineLength() < winLine.getWinLineLength()) {
                gameState.setRealWinLine(winLine);
                return true;
            }
        }

        winLine = new WinLine();
        winLine.setX1(x);
        winLine.setY1(y);
        winLine = checkNeighbor(x, y, Direction.E, winLine);
        if (gameState.getWinLineLength() <= winLine.getWinLineLength()) {
            gameState.setRealWinLine(winLine);
            return true;
        }
        else {
            winLine = checkNeighbor(x, y, Direction.W, winLine);
            if (gameState.getWinLineLength() < winLine.getWinLineLength()) {
                gameState.setRealWinLine(winLine);
                return true;
            }
        }

        winLine = new WinLine();
        winLine.setX1(x);
        winLine.setY1(y);
        winLine = checkNeighbor(x, y, Direction.NE, winLine);
        if (gameState.getWinLineLength() <= winLine.getWinLineLength()) {
            gameState.setRealWinLine(winLine);
            return true;
        }
        else {
            winLine = checkNeighbor(x, y, Direction.SW, winLine);
            if (gameState.getWinLineLength() < winLine.getWinLineLength()) {
                gameState.setRealWinLine(winLine);
                return true;
            }
        }

        winLine = new WinLine();
        winLine.setX1(x);
        winLine.setY1(y);
        winLine = checkNeighbor(x, y, Direction.ES, winLine);
        if (gameState.getWinLineLength() <= winLine.getWinLineLength()) {
            gameState.setRealWinLine(winLine);
            return true;
        }
        else {
            winLine = checkNeighbor(x, y, Direction.WN, winLine);
            if (gameState.getWinLineLength() < winLine.getWinLineLength()) {
                gameState.setRealWinLine(winLine);
                return true;
            }
        }
        return false;
    }

    // Метод для поиска линий из одинаковых символов
    public WinLine checkNeighbor(int x, int y, Direction direction, WinLine winLine) {
        winLine.setX2(x);
        winLine.setY2(y);

        switch (direction) {
            case N: {
                if (y > 0 && gameState.getGameMap()[x][y] == gameState.getGameMap()[x][y - 1]) {
                    winLine = checkNeighbor(x, y - 1, Direction.N, winLine);
                }
            } break;
            case NE: {
                if ( y > 0 && x < gameState.getMapSize() - 1 && gameState.getGameMap()[x][y] ==gameState.getGameMap()[x + 1][y - 1]) {
                    winLine = checkNeighbor(x + 1, y - 1, Direction.NE, winLine);
                }
            } break;
            case E: {
                if ( x < gameState.getMapSize() - 1  && gameState.getGameMap()[x][y] == gameState.getGameMap()[x + 1][y]) {
                    winLine = checkNeighbor(x + 1, y, Direction.E, winLine);
                }
            } break;
            case ES: {
                if ( y < gameState.getMapSize() - 1 && x < gameState.getMapSize() - 1 && gameState.getGameMap()[x][y] == gameState.getGameMap()[x + 1][y + 1]) {
                    winLine = checkNeighbor(x + 1, y + 1, Direction.ES, winLine);
                }
            } break;
            case S: {
                if ( y < gameState.getMapSize() - 1  &&gameState.getGameMap()[x][y] == gameState.getGameMap()[x][y + 1]) {
                    winLine = checkNeighbor(x, y + 1, Direction.S, winLine);
                }
            } break;
            case SW: {
                if ( y < gameState.getMapSize() - 1 && x > 0 && gameState.getGameMap()[x][y] == gameState.getGameMap()[x - 1][y + 1]) {
                    winLine = checkNeighbor(x - 1, y + 1, Direction.SW, winLine);
                }
            } break;
            case W: {
                if ( x > 0 && gameState.getGameMap()[x][y] == gameState.getGameMap()[x - 1][y]) {
                    winLine = checkNeighbor(x - 1, y, Direction.W, winLine);
                }
            } break;
            case WN: {
                if ( y > 0 && x > 0 && gameState.getGameMap()[x][y] == gameState.getGameMap()[x - 1][y - 1]) {
                    winLine = checkNeighbor(x - 1, y - 1, Direction.WN, winLine);
                }
            } break;
        }

        int winLineLength = winLine.getWinLineLength();
        winLineLength++;
        winLine.setWinLineLength(winLineLength);

        return winLine;
    }

    //Проверка на ничью
    public boolean isMapFull() {
        for (int i = 0; i < gameState.getMapSize(); i++) {
            for (int j = 0; j < gameState.getMapSize(); j++) {
                if (gameState.getGameMap()[i][j] == null)
                    return false;
            }
        }
        return true;
    }
}

