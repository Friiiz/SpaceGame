package main;

import util.InputHandler;

public final class Main {
    public static boolean isRunning = false;
    public static InputHandler inputHandler;
    private static final int MAX_FRAME_RATE = java.awt.GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode().getRefreshRate();
    private static final double MIN_FRAME_TIME = 1.0 / (double) MAX_FRAME_RATE;

    public static void main(String[] args) {
        init();
        loop();
    }

    public static void init() {
        inputHandler = new InputHandler();
        //Graphics.setUp();
        isRunning = true;
    }

    public static void loop() {
        double startTime = System.nanoTime();
        double deltaTime = 0.0d;
        double frameTimeLeft = MIN_FRAME_TIME;

        while (isRunning) {
            if (deltaTime > 0 && frameTimeLeft < 0) {

                frameTimeLeft = MIN_FRAME_TIME;
            }

            deltaTime = (System.nanoTime() - startTime) / 1E9;
            frameTimeLeft -= deltaTime;

            startTime = System.nanoTime();
        }
    }
}
