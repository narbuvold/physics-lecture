package se.lithekod;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Main {
    private static double lastUpdate;

    public static void main(String[] args) {
        final Game game = new Game();
        JFrame frame = new JFrame("PLACEHOLDER");
        final Component component = new Component(game);
        frame.setLayout(new BorderLayout());
        frame.add(component, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        lastUpdate = System.currentTimeMillis();

        AbstractAction doOneStep = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double currentTime = System.currentTimeMillis();
                game.update(currentTime - lastUpdate);
                lastUpdate = currentTime;
                component.repaint();
            }
        };

        Timer timer = new Timer(17, doOneStep);
        timer.setCoalesce(true);
        timer.start();


        frame.setVisible(true);

    }
}