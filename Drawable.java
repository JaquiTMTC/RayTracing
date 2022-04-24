import java.awt.Color;

public abstract class Drawable {
    Material material;
    //abstract boolean intersects(Ray ray);
    abstract double closestIntersectionPoint(Ray ray);
    abstract Vector3d normal(Vector3d point);
    //abstract void precomputeCamera(Vector3d pos);
    abstract Drawable copy();

    abstract Vector3d getUVCoordinates(Vector3d point);
}
