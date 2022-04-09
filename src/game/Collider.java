package game;

import java.awt.geom.Rectangle2D;

public final class Collider extends Component {

    private Rectangle2D.Double colliderShape;
    private boolean isActive;

    public Collider(double x, double y, double width, double height) {
        colliderShape = new Rectangle2D.Double(x, y, width, height);
    }

    public Collider(Transform transform) {
        colliderShape = new Rectangle2D.Double(transform.getX(), transform.getY(), transform.getWidth(), transform.getHeight());
    }

    @Override
    protected void update(double deltaTime) {
        super.update(deltaTime);
    }

    public boolean collides(Collider collider) {
        return colliderShape.contains(collider.colliderShape) || colliderShape.intersects(collider.colliderShape);
    }

    public Rectangle2D.Double getColliderShape() {
        return colliderShape;
    }

    public void setColliderShape(Rectangle2D.Double colliderShape) {
        this.colliderShape = colliderShape;
    }

    public boolean activate() {
        return isActive;
    }

    public void deactivate(boolean active) {
        isActive = active;
    }
}


