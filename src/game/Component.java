package game;

public abstract sealed class Component permits Animation, Collider, PlayerController, Transform {

    protected double lastUpdate;

    protected void update(double deltaTime) {
        lastUpdate = System.nanoTime();
    }
}
