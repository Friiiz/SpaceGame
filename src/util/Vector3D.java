package util;

public class Vector3D {
    private double x, y, z;

    public Vector3D(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public void set(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public void scalarMultiplication(double s) {
        x = x * s;
        y = y * s;
        z = z * s;
    }

    public static Vector3D scalarMultiplication(Vector3D v, double s) {
        return new Vector3D(v.x * s, v.y * s, v.z * s);
    }

    public void linearCombination(double s1, Vector3D v, double s2) {
        x = x * s1 + v.x * s2;
        y = y * s1 + v.y * s2;
        z = z * s1 + v.z * s2;
    }

    public static Vector3D linearCombination(Vector3D v1, double s1, Vector3D v2, double s2) {
        return new Vector3D(v1.x * s1 + v2.x * s2, v1.y * s1 + v2.y * s2, v1.z * s1 + v2.z * s2);
    }

    public void vectorMultiplication(Vector3D v) {
        x = x * v.x;
        y = y * v.y;
        z = z * v.z;
    }

    public static Vector3D vectorMultiplication(Vector3D v1, Vector3D v2) {
        return new Vector3D(v1.x * v2.x, v1.y * v2.y, v1.z * v2.z);
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

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }
}
