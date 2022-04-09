package graphics;

import javax.swing.*;
import java.awt.*;

class Window extends JFrame {

    public Window() {
        //set bounds based on previously calculated window size, screen size and screen orientation
        if(Graphics.SCREEN_HEIGHT > Graphics.SCREEN_WIDTH) {
            setBounds(0, (Graphics.SCREEN_HEIGHT - Graphics.SCREEN_WIDTH) / 2, Graphics.WINDOW_WIDTH, Graphics.WINDOW_HEIGHT);
            setMinimumSize(Graphics.getWindowDimensions());
            setExtendedState(Frame.MAXIMIZED_HORIZ);
        } else {
            setBounds((Graphics.SCREEN_WIDTH - Graphics.SCREEN_HEIGHT) / 2, 0, Graphics.WINDOW_WIDTH, Graphics.WINDOW_HEIGHT);
            setMinimumSize(Graphics.getWindowDimensions());
            setExtendedState(Frame.MAXIMIZED_VERT);
        }
        setUndecorated(true);
        setVisible(true);
        setTitle("Test");
        setResizable(false);
    }
}
