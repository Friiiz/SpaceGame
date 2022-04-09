package graphics;

import java.awt.*;

public class Graphics {
    protected static Window window;
    protected static Panel renderer;
    public static final int SCREEN_WIDTH = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
    public static final int SCREEN_HEIGHT = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
    public static final int WINDOW_WIDTH = (int) getWindowDimensions().getWidth();
    public static final int WINDOW_HEIGHT = (int) getWindowDimensions().getHeight();

    private Graphics() {
        throw new IllegalStateException("This class is static and can not be instantiated.");
    }

    public static void setUp() {
        window = new Window();
        renderer = new Panel(Color.LIGHT_GRAY, window);
    }

    public static void update(double deltaTime) {
        renderer.update(deltaTime);
    }

    //calculate window dimensions for centered window based on screen size and orientation
    public static Dimension getWindowDimensions() {
        Dimension dimensions = new Dimension();
        if(SCREEN_HEIGHT > SCREEN_WIDTH) {
            dimensions.setSize(SCREEN_WIDTH, SCREEN_WIDTH);
        } else {
            dimensions.setSize(SCREEN_HEIGHT, SCREEN_HEIGHT);
        }
        return dimensions;
    }

    public static void reset() {
        renderer.grabFocus();
    }
}
