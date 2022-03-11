import java.awt.Color;

public class Plane extends Drawable{
    private Vector3d normal;
    private Vector3d center;

    public Plane(Vector3d _normal, Vector3d _center, Color _color, boolean _isReflective){
        normal = new Vector3d(_normal);
        center = new Vector3d(_center);
        color = _color;
        isReflective = _isReflective;
    }

    /**
     * Finds the parameter of the intersection between a ray and the plane
     * @param ray the ray
     * @return the distance if it intersects, -1 if it doesn't intersect
     */
    double closestIntersectionPoint(Ray ray) {
        if(ray.getDir().dot(normal)==0){ // If ray is parallel to plane
            return -1; // We do not consider important the case where the camera is in the plane (where the ray should intersect the plane)
        }
        return center.sub(ray.getPos()).dot(normal)/ray.getDir().dot(normal);
    }

    Vector3d normal(Vector3d point) {
        return new Vector3d(normal);
    }

    Drawable copy() {
        return new Plane(normal, center, color, isReflective);
    }
}
