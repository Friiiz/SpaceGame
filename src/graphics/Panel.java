package graphics;

import game.GameObject;

import javax.swing.*;
import java.awt.Graphics;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.LinkedList;


import static main.Main.*;

class Panel extends JPanel {
    RenderingHints antiAliasing = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    RenderingHints textAntiAliasing = new RenderingHints(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
    RenderingHints fractionalMetrics = new RenderingHints(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_ON);
    private double deltaTime;

    public Panel(Color background, JFrame container) {
        setBackground(background);
        setBounds(0, 0, container.getContentPane().getWidth(), container.getContentPane().getHeight());
        container.add(this);
        deltaTime = 0;
        addKeyListener(inputHandler);
        addMouseListener(inputHandler);
        addMouseMotionListener(inputHandler);
        setFocusable(true);
        grabFocus();
        setFocusTraversalKeysEnabled(false);
    }

    @Override
    public void paintComponent(Graphics g) {
        //set up graphics object
        Graphics2D g2D = (Graphics2D) g;
        g2D.setRenderingHints(antiAliasing);
        g2D.setRenderingHints(textAntiAliasing);
        g2D.setRenderingHints(fractionalMetrics);
        g2D.setFont(new Font("Courier New", Font.BOLD, getHeight() / 40));

        //reset canvas
        super.paintComponent(g2D);

        LinkedList<GameObject> gameObjects = new LinkedList<>();
        gameObjects.add(new GameObject());
        Scene testScene = new Scene(gameObjects);
        testScene.update(deltaTime);

        testScene.getBatch().forEach(gameObject -> {
            BufferedImage image = gameObject.getAnimation().currentSprite(deltaTime).getIMAGE();
            int xScreenCoordinates = (int) gameObject.getTransform().getX();
            int yScreenCoordinates = (int) gameObject.getTransform().getY();
            int width = (int) gameObject.getTransform().getWidth();
            int height = (int) gameObject.getTransform().getHeight();
            Sprite currentFrame = gameObject.getAnimation().currentSprite(deltaTime);
            int sampleX1 = currentFrame.getSAMPLE_X1();
            int sampleY1 = currentFrame.getSAMPLE_Y1();
            int sampleX2 = currentFrame.getSAMPLE_X2();
            int sampleY2 = currentFrame.getSAMPLE_Y2();

            g2D.drawImage(image,
                    xScreenCoordinates,
                    yScreenCoordinates,
                    xScreenCoordinates + width,
                    yScreenCoordinates + height,
                    sampleX1,
                    sampleY1,
                    sampleX2,
                    sampleY2,
                    null
            );
        });

    }

    public void update(double deltaTime) {
        this.deltaTime = deltaTime;
        repaint();
    }
}