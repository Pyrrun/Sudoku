package gui.buttons;

import game.Game;
import game.Timer;
import gui.Frame;
import gui.Gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class EasyButton extends JButton implements ActionListener {
    private Frame frame;
    private Game game;

    public EasyButton() {
        super("Easy");
        this.frame = Gui.getGuiInstance().getFrame();
        this.game = Game.getGameInstance();
        this.setBackground(new Color(219, 225, 204));
        this.setBounds((frame.getWidth() / 2) - 100, (frame.getHeight() / 2) - 100, 200, 50);
        this.addActionListener(this::actionPerformed);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (game.getMode().equals("Hex")) {
            frame.getPlayPanel().createBoardView(16);
        } else {
            frame.getPlayPanel().createBoardView(9);
        }
        frame.getDifficultyPanel().setVisible(false);
        game.setDifficulty("Easy");
        try {
            game.start();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        frame.setContentPane(frame.getPlayPanel());
        frame.getPlayPanel().setVisible(true);
    }
}
