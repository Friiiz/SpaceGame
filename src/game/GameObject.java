package game;

import graphics.Sprite;
import util.InputHandler;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;

public final class GameObject {

    private Transform transform;
    private Animation animation;
    private PlayerController playerController;
    private Collider collider;

    public GameObject () {
        transform = new Transform(0, 0, 0, 1, 1);
        animation = new Animation(true);
        try {
            animation.addFrame(1, new Sprite(ImageIO.read(new File("resources\\images\\maggot.png")), 0, 0, 16, 16));
        } catch (IOException e) {
            e.printStackTrace();
        }
        playerController = new PlayerController(new InputHandler());
        collider = new Collider(transform);
    }
    
    public void update(double deltaTime) {

    }

    public Transform getTransform() {
        return transform;
    }

    public void setTransform(Transform transform) {
        this.transform = transform;
    }

    public Animation getAnimation() {
        return animation;
    }

    public void setAnimation(Animation animation) {
        this.animation = animation;
    }

    public PlayerController getPlayerController() {
        return playerController;
    }

    public void setPlayerController(PlayerController playerController) {
        this.playerController = playerController;
    }

    public Collider getCollider() {
        return collider;
    }

    public void setCollider(Collider collider) {
        this.collider = collider;
    }
}
