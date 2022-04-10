package util;

public class Vector2D {
    private double x, y;

    public Vector2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void set(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void scalarMultiplication(double s) {
        x = x * s;
        y = y * s;
    }

    public static Vector2D scalarMultiplication(Vector2D v, double s) {
        return new Vector2D(v.x * s, v.y * s);
    }

    public void linearCombination(double s1, Vector2D v, double s2) {
        x = x * s1 + v.x * s2;
        y = y * s1 + v.y * s2;
    }

    public static Vector2D linearCombination(Vector2D v1, double s1, Vector2D v2, double s2) {
        return new Vector2D(v1.x * s1 + v2.x * s2, v1.y * s1 + v2.y * s2);
    }

    public void vectorMultiplication(Vector2D v) {
        x = x * v.x;
        y = y * v.y;
    }

    public static Vector2D vectorMultiplication(Vector2D v1, Vector2D v2) {
        return new Vector2D(v1.x * v2.x, v1.y * v2.y);
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }
}
