package graphics;

import java.awt.*;

public class Graphics {
    protected static Window window;
    protected static Panel renderer;
    public static final int SCREEN_WIDTH = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
    public static final int SCREEN_HEIGHT = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();

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

    public static void reset() {
        renderer.grabFocus();
    }
}
