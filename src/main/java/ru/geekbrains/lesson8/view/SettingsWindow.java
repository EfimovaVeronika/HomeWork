package ru.geekbrains.lesson8.view;

import ru.geekbrains.lesson8.GameState;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class SettingsWindow extends JFrame {
    public static final String GAME_SETTINGS_TITLE = "Настройки";
    public static final int WINDOW_HEIGHT = 300;
    public static final int WINDOW_WIDTH = 300;
    public static final String SAVE_BUTTON_LABEL = "Сохранить";
    public static final String SIZE_SLIDER_TITLE = "Размер игрового поля";
    public static final String DOT_TO_WIN_TITLE = "Количество выйгрышных фишек";
    public static final int MAX_SIZE_MAP = 15;
    public static final int MIN_SIZE_MAP = 3;
    public static final int DEFAULT_SIZE = 3;
    public static final int MAX_SIZE_LINE_WIN = 5;

    public SettingsWindow() {
        SettingsWindow thisFrame = this;

        setTitle(GAME_SETTINGS_TITLE);

        // Распологаем окно в центре экрана
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int) screenSize.getWidth();
        int height = (int) screenSize.getHeight();
        setBounds(width / 2 - WINDOW_WIDTH / 2, height / 2 - WINDOW_HEIGHT / 2, WINDOW_WIDTH, WINDOW_HEIGHT);

        JPanel sliderPanel = new JPanel();
        sliderPanel.setLayout(new GridLayout(4, 1 ));


        JSlider sizeSlider = new JSlider(MIN_SIZE_MAP, MAX_SIZE_MAP, DEFAULT_SIZE);
        sizeSlider.setMajorTickSpacing(1);
        sizeSlider.setPaintTicks(true);
        sizeSlider.setPaintLabels(true);

        int realMaxSizeWinLine = sizeSlider.getValue() <= MAX_SIZE_LINE_WIN ? sizeSlider.getValue() : MAX_SIZE_LINE_WIN;

        JSlider dotToWinSlider = new JSlider(MIN_SIZE_MAP, realMaxSizeWinLine, MIN_SIZE_MAP);
        dotToWinSlider.setMajorTickSpacing(1);
        dotToWinSlider.setPaintTicks(true);
        dotToWinSlider.setPaintLabels(true);

        sliderPanel.add(new Label(SIZE_SLIDER_TITLE));
        sliderPanel.add(sizeSlider);
        sliderPanel.add(new Label(DOT_TO_WIN_TITLE));
        sliderPanel.add(dotToWinSlider);


        sizeSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int realMaxSizeWinLine = sizeSlider.getValue() <= MAX_SIZE_LINE_WIN ? sizeSlider.getValue() : MAX_SIZE_LINE_WIN;
                dotToWinSlider.setMaximum(realMaxSizeWinLine);

            }
        });

        add(sliderPanel, BorderLayout.CENTER);




        // Смена значения флага, определяющего состояние окна настроек, на true при щелчке по крестику.
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                GameState.getInstance().setSettingsCloseFlag(true);

            }
        });

        JButton saveButton = new JButton(SAVE_BUTTON_LABEL);
        add(saveButton, BorderLayout.SOUTH);

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GameState.getInstance().setSettingsCloseFlag(true);

                GameState.getInstance().setMapSize(sizeSlider.getValue());
                GameState.getInstance().setWinLineLength(dotToWinSlider.getValue());

                thisFrame.dispose();
            }
        });



        setVisible(true);
    }
}
