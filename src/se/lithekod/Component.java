package se.lithekod;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;

/**
 * Created by henning on 15-04-15.
 */
public class Component extends JComponent {
    public Game game;
    public static final int WIDTH = 600;
    public static final int HEIGHT = 600;
    public BufferedImage player;

    public Component(Game game) {
        this.game = game;
        setInput();
        try {
            player = ImageIO.read(new File(FileSystems.getDefault().getPath(
                    "datar", "GlowingNugget.png").toUri()));
        } catch (IOException e) {
            System.out.println("Image not found");
            player = new BufferedImage(50, 50, BufferedImage.TYPE_3BYTE_BGR);
        }
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(WIDTH, HEIGHT);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.RED);
        g2.fillRect(0, 0, WIDTH, HEIGHT);
        Point pos = game.getPosition();
        g2.setColor(Color.BLUE);
        g2.drawImage(player, pos.x - game.radius/2, pos.y - game.radius/2,
                game.radius, game.radius, null);
    }
    private void setInput() {
        getInputMap().put(KeyStroke.getKeyStroke("UP"), "UP");
        getActionMap().put("UP", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.move(Direction.UP, true);
            }
        });
        getInputMap().put(KeyStroke.getKeyStroke("released UP"), "no UP");
        getActionMap().put("no UP", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.move(Direction.UP, false);
            }
        });
        getInputMap().put(KeyStroke.getKeyStroke("DOWN"), "DOWN");
        getActionMap().put("DOWN", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.move(Direction.DOWN, true);
            }
        });
        getInputMap().put(KeyStroke.getKeyStroke("released DOWN"), "no DOWN");
        getActionMap().put("no DOWN", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.move(Direction.DOWN, false);
            }
        });
        getInputMap().put(KeyStroke.getKeyStroke("LEFT"), "LEFT");
        getActionMap().put("LEFT", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.move(Direction.LEFT, true);
            }
        });
        getInputMap().put(KeyStroke.getKeyStroke("released LEFT"), "no LEFT");
        getActionMap().put("no LEFT", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.move(Direction.LEFT, false);
            }
        });
        getInputMap().put(KeyStroke.getKeyStroke("RIGHT"), "RIGHT");
        getActionMap().put("RIGHT", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.move(Direction.RIGHT, true);
            }
        });
        getInputMap().put(KeyStroke.getKeyStroke("released RIGHT"), "no RIGHT");
        getActionMap().put("no RIGHT", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.move(Direction.RIGHT, false);
            }
        });
    }
}
