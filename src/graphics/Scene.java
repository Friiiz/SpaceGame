package graphics;

import game.GameObject;

import java.util.LinkedList;
import java.util.List;

public class Scene {

    private List<GameObject> gameObjects;
    private Camera camera;
    private boolean isDirty;
    private boolean isVisible;

    public Scene(LinkedList<GameObject> gameObjects) {
        this.gameObjects = gameObjects;
        camera = new Camera(0, 0);
        isDirty = true;
        isVisible = false;
    }

    public Scene() {
        gameObjects = new LinkedList<>();
        camera = new Camera(0, 0);
        isDirty = true;
        isVisible = false;
    }

    public List<GameObject> getBatch() {
        return camera.scan(gameObjects);
    }

    public void update(double deltaTime) {
        camera.update(deltaTime);
    }

    public List<GameObject> getGameObjects() {
        return gameObjects;
    }

    public void setGameObjects(List<GameObject> gameObjects) {
        this.gameObjects = gameObjects;
    }

    public Camera getCamera() {
        return camera;
    }

    public void setCamera(Camera camera) {
        this.camera = camera;
    }

    public boolean isDirty() {
        return isDirty;
    }

    public void setDirty(boolean dirty) {
        this.isDirty = dirty;
    }

    public boolean isVisible() {
        return isVisible;
    }

    public void setVisible(boolean visible) {
        isVisible = visible;
    }
}
