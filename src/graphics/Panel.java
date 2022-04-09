package graphics;

import javax.swing.*;
import java.awt.Graphics;
import java.awt.*;
import java.awt.image.BufferedImage;


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

        //BufferedImage image = component.currentFrame(deltaTime).getIMAGE();
        //int xScreenCoordinates = component.getXScreenCoordinates();
        //int yScreenCoordinates = component.getYScreenCoordinates();
        //int width = component.getWidth();
        //int height = component.getHeight();
        //Sprite currentFrame = component.currentFrame(deltaTime);
        //int sampleX1 = currentFrame.getSAMPLE_X1();
        //int sampleY1 = currentFrame.getSAMPLE_Y1();
        //int sampleX2 = currentFrame.getSAMPLE_X2();
        //int sampleY2 = currentFrame.getSAMPLE_Y2();

        //draw component
        //g2D.drawImage(image,
        //        xScreenCoordinates,
        //        yScreenCoordinates,
        //        xScreenCoordinates + width,
        //        yScreenCoordinates + height,
        //        sampleX1,
        //        sampleY1,
        //        sampleX2,
        //        sampleY2,
        //        null
        //);
    }

    public void update(double deltaTime) {
        this.deltaTime = deltaTime;
        repaint();
    }
}