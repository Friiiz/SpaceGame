package graphics;

import javax.swing.*;
import java.awt.*;

import static graphics.Graphics.SCREEN_HEIGHT;
import static graphics.Graphics.SCREEN_WIDTH;

class Window extends JFrame {

    public Window() {
        setBounds(0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);
        setMinimumSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        setExtendedState(Frame.MAXIMIZED_BOTH);
        setUndecorated(true);
        setVisible(true);
        setTitle("Test");
        setResizable(false);
    }
}
