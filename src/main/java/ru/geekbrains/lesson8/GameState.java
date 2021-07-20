package ru.geekbrains.lesson8;

import ru.geekbrains.lesson8.model.Move;
import ru.geekbrains.lesson8.model.Symbol;
import ru.geekbrains.lesson8.model.WinLine;

public class GameState {
    private static GameState instance;


    private int mapSize = 3;
    private int winLineLength = 3;
    private boolean initFlag = false;
    private boolean settingsCloseFlag = true;
    private boolean gameOver = false;
    private Symbol[][] gameMap;
    private Symbol currentSymbol = Symbol.X;
    private Move lastMachineStep = new Move();
    private WinLine realWinLine;



    private GameState()  {
        resetGameMap();
    }

    public static GameState getInstance() {
        if (instance == null) {
             instance = new GameState();
        }
        return instance;
    }

    public boolean isSettingsCloseFlag() {
        return settingsCloseFlag;
    }

    public void setSettingsCloseFlag(boolean settingsCloseFlag) {
        this.settingsCloseFlag = settingsCloseFlag;
    }

    public boolean isInitFlag() {
        return initFlag;
    }

    public void setInitFlag(boolean initFlag) {
        this.initFlag = initFlag;
    }

    public int getMapSize() {
        return mapSize;
    }

    public void setMapSize(int mapSize) {
        this.mapSize = mapSize;
    }

    public int getWinLineLength() {
        return winLineLength;
    }

    public void setWinLineLength(int winLineLength) {
        this.winLineLength = winLineLength;
    }

    public Symbol[][] getGameMap() {
        return gameMap;
    }

    public void setGameMap(Symbol[][] gameMap) {
        this.gameMap = gameMap;
    }

    public Symbol getCurrentSymbol() {
        return currentSymbol;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }

    public Move getLastMachineStep() {
        return lastMachineStep;
    }

    public WinLine getRealWinLine() {
        return realWinLine;
    }

    public void resetGameMap() {
        gameMap = new Symbol[mapSize][mapSize];
    }

    public void resetCurrentSymbol() {
        currentSymbol = Symbol.X;
    }

    public Symbol changeCurrentSymbol() {
        if (currentSymbol == Symbol.X) {
            currentSymbol = Symbol.O;
        }
        else {
            currentSymbol = Symbol.X;
        }

        return currentSymbol;
    }

    public void setRealWinLine(WinLine realWinLine) {
        this.realWinLine = realWinLine;
    }
}

