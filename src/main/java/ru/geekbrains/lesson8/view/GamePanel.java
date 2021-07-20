package ru.geekbrains.lesson8.view;

import ru.geekbrains.lesson8.GameState;
import ru.geekbrains.lesson8.controller.GameLogic;
import ru.geekbrains.lesson8.model.Symbol;
import ru.geekbrains.lesson8.model.WinLine;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GamePanel extends JPanel {
    private int cellHeight;
    private int cellWight;
    private GameState gameState;
    private GameLogic gameLogic = new GameLogic();

    public GamePanel() {
        gameState = GameState.getInstance();

        setBackground(Color.DARK_GRAY);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                if (gameState.isGameOver()) {
                    return;
                }

                int x = e.getX() / cellWight;
                int y = e.getY() / cellHeight;

                if (!gameLogic.isCellValid(x, y)) {
                    return;
                }
                gameLogic.playMan(x, y);

                if (gameLogic.checkWin(x, y)) {
                    gameState.setGameOver(true);
                    repaint();
                    return;
                }
                if (gameLogic.isMapFull()) {
                    repaint();
                    return;
                }

                gameLogic.playMachine();

                if (gameLogic.checkWin(gameState.getLastMachineStep().getX(), gameState.getLastMachineStep().getY())) {
                    gameState.setGameOver(true);
                    repaint();
                    return;
                }
                if (gameLogic.isMapFull()) {
                    repaint();
                    return;
                }
                repaint();

            }
        });

    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);

        if (GameState.getInstance().isInitFlag()) {
            paintMap(graphics);

            for (int i = 0; i < gameState.getMapSize(); i++) {
                for (int j = 0; j < gameState.getMapSize(); j++) {
                    if (gameState.getGameMap()[i][j] != null) {
                        if (gameState.getGameMap()[i][j] == Symbol.X) {
                            paintX(graphics, i, j);
                        } else {
                            paintO(graphics, i, j);
                        }
                    }
                }
            }

            if (gameState.isGameOver()) {
                paintWinLine(graphics, gameState.getRealWinLine());
            }
        }
    }


    private void paintMap(Graphics graphics) {
        int panelHeight = getHeight();
        int panelWight = getWidth();

        cellHeight = panelHeight / GameState.getInstance().getMapSize();
        cellWight = panelWight / GameState.getInstance().getMapSize();


        graphics.setColor(Color.LIGHT_GRAY);
        ((Graphics2D) graphics).setStroke(new BasicStroke(2f));

        for (int i = 1; i < GameState.getInstance().getMapSize(); i++) {
            graphics.drawLine(i * cellWight, 0, i * cellWight, panelHeight);
        }

        for (int i = 1; i < GameState.getInstance().getMapSize(); i++) {
            graphics.drawLine(0, i * cellHeight, panelWight, i * cellHeight);
        }
    }


    private void paintX(Graphics graphics, int x, int y) {

        graphics.setColor(Color.WHITE);
        ((Graphics2D) graphics).setStroke(new BasicStroke(5f));

        graphics.drawLine(x * cellWight, y * cellHeight, (x + 1) * cellWight, (y + 1) * cellHeight);
        graphics.drawLine((x + 1) * cellWight, y * cellHeight, x * cellWight, (y + 1) * cellHeight);
    }

    private void paintO(Graphics graphics, int x, int y) {
        graphics.setColor(Color.WHITE);
        ((Graphics2D) graphics).setStroke(new BasicStroke(5f));

        graphics.drawOval(x * cellWight, y * cellHeight, cellWight, cellHeight);
    }

    private void paintWinLine(Graphics graphics, WinLine winLine) {
        graphics.setColor(Color.RED);
        ((Graphics2D) graphics).setStroke(new BasicStroke(3f));

        graphics.drawLine(
                winLine.getX1() * cellWight + cellWight / 2,
                winLine.getY1() * cellHeight + cellHeight/ 2,
                winLine.getX2() * cellWight + cellWight/ 2,
                winLine.getY2() * cellHeight + cellHeight/ 2);
    }
}
