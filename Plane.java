import java.awt.Color;
import java.util.Objects;

public class Plane extends Drawable{
    private Vector3d normal;
    private Vector3d center;

    public Plane(Vector3d _normal, Vector3d _center, Material material){

        normal = new Vector3d(_normal);
        center = new Vector3d(_center);
        this.material = material;
    }

    /**
     * Finds the parameter of the intersection between a ray and the plane
     * @param ray the ray
     */
    double closestIntersectionPoint(Ray ray) {
        if (ray.getDir().dot(normal) == 0) { // If ray is parallel to plane
            return -1; // We do not consider important the case where the camera is in the plane (where the ray should intersect the plane)
        }
        return center.sub(ray.getPos()).dot(normal)/ray.getDir().dot(normal);
    }

    Vector3d normal(Vector3d point) {
        return new Vector3d(normal);
    }

    Drawable copy() {
        return new Plane(normal, center, material);
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Plane plane = (Plane) o;
        return Objects.equals(normal, plane.normal) && Objects.equals(center, plane.center);
    }

    public String toString() {
        return "Plane{" +
                "material=" + material +
                ", normal=" + normal +
                ", center=" + center +
                '}';
    }
}
