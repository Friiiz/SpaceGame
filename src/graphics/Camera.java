package graphics;

import game.GameObject;
import util.InputHandler;

import java.util.LinkedList;
import java.util.List;

public class Camera {

    private double x, y, zoom; //zoom: 1 -> 1 tile = 100 pixels ...

    public Camera(double x, double y) {
        this.x = x;
        this.y = y;
        zoom = 1.0d;
    }

    public List<GameObject> scan(List<GameObject> gameObjects) {
        LinkedList<GameObject> batch = new LinkedList<>();
        gameObjects.forEach(gameObject -> {
            GameObject clone = gameObject;
            clone.getTransform().setX(clone.getTransform().getX() * zoom * 100 - this.x * zoom * 100);
            clone.getTransform().setY(clone.getTransform().getY() * zoom * 100 - this.y * zoom * 100);
            clone.getTransform().setWidth(clone.getTransform().getWidth() * zoom * 100);
            clone.getTransform().setHeight(clone.getTransform().getHeight() * zoom * 100);

            if(!(clone.getTransform().getX() > Graphics.SCREEN_WIDTH
            || clone.getTransform().getX() + clone.getTransform().getWidth() < 0
            || clone.getTransform().getY() > Graphics.SCREEN_HEIGHT
            || clone.getTransform().getY() + clone.getTransform().getHeight() < 0)) {
                batch.add(clone);
            }
        });
        return batch;
    }

    public void update(double deltaTime) {

    }
}
