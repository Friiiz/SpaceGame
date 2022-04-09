package util;

import java.awt.event.*;

public final class InputHandler implements KeyListener, MouseListener, MouseMotionListener {
    //keys
    private boolean keyUp, keyLeft, keyDown, keyRight;

    //mouse buttons
    private boolean buttonLeft, buttonRight, buttonMiddle;

    //mouse movement
    private int mouseX, mouseY, lastMouseX, lastMouseY;

    @Override
    public void keyTyped(KeyEvent keyEvent) {
        int key = keyEvent.getKeyCode();

    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        int key = keyEvent.getKeyCode();

        if (key == KeyEvent.VK_ESCAPE) {
            System.exit(69);
        }
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {
        int key = keyEvent.getKeyCode();

    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        int button = mouseEvent.getButton();

    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {
        int button = mouseEvent.getButton();

    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {
        int button = mouseEvent.getButton();

    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseDragged(MouseEvent mouseEvent) {
        int button = mouseEvent.getButton();
        lastMouseX = mouseX;
        lastMouseY = mouseY;
        mouseX = mouseEvent.getX();
        mouseY = mouseEvent.getY();

    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {
        lastMouseX = mouseX;
        lastMouseY = mouseY;
        mouseX = mouseEvent.getX();
        mouseY = mouseEvent.getY();

    }

    public boolean isKeyUp() {
        return keyUp;
    }

    public boolean isKeyLeft() {
        return keyLeft;
    }

    public boolean isKeyDown() {
        return keyDown;
    }

    public boolean isKeyRight() {
        return keyRight;
    }

    public boolean isButtonLeft() {
        return buttonLeft;
    }

    public boolean isButtonRight() {
        return buttonRight;
    }
}
