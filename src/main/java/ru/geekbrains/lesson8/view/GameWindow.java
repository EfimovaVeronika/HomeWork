package ru.geekbrains.lesson8.view;

import ru.geekbrains.lesson8.GameState;
import ru.geekbrains.lesson8.controller.GameLogic;
import ru.geekbrains.lesson8.model.Gamer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameWindow extends JFrame {
    public static final String GAME_TITLE = "Крестики-Нолики";
    public static final int WINDOW_HEIGHT = 440;
    public static final int WINDOW_WIDTH = 400;
    public static final String BUTTON_LABEL_SETTINGS = "Настройки";
    public static final String BUTTON_LABEL_EXIT = "Выход";
    public static final String BUTTON_LABEL_NEW_GAME = "Новая игра";
    private GameLogic gameLogic = new GameLogic();



    public GameWindow() {
        GameWindow thisFrame = this;

        setTitle(GAME_TITLE);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        // Распологаем окно в центре экрана
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int) screenSize.getWidth();
        int height = (int) screenSize.getHeight();
        setBounds(width / 2  - WINDOW_WIDTH / 2, height / 2 - WINDOW_HEIGHT / 2, WINDOW_WIDTH, WINDOW_HEIGHT);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 3 ));

        GamePanel gamePanel = new GamePanel();

        JButton settingsButton = new JButton(BUTTON_LABEL_SETTINGS);
        settingsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(GameState.getInstance().isSettingsCloseFlag()) {
                    GameState.getInstance().setSettingsCloseFlag(false);
                    new SettingsWindow();
                }

            }
        });

        JButton exitButton = new JButton(BUTTON_LABEL_EXIT);
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                thisFrame.dispose();
            }
        });

        JButton newGameButton = new JButton(BUTTON_LABEL_NEW_GAME);
        newGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GameState.getInstance().setInitFlag(true);
                GameState.getInstance().resetCurrentSymbol();
                GameState.getInstance().resetGameMap();
                GameState.getInstance().setGameOver(false);
                gamePanel.repaint();

                if (gameLogic.chooseFirstPlayer() == Gamer.MACHINE) {
                    gameLogic.playMachine();
                    gamePanel.repaint();
                }
            }
        });

        buttonPanel.add(newGameButton);
        buttonPanel.add(settingsButton);
        buttonPanel.add(exitButton);


        add(buttonPanel, BorderLayout.SOUTH);
        add(gamePanel, BorderLayout.CENTER);

        setVisible(true);
    }


}
