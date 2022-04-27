import java.util.Objects;

public class Plane extends Drawable{
    private Vector3d normal;
    private Vector3d center;

    /**
     * Creates a plane given the following parameters
     * @param normal the normal of the plane
     * @param center a point of the plane
     * @param material the material of the plane
     */
    public Plane(Vector3d normal, Vector3d center, Material material){
        this.normal = new Vector3d(normal);
        this.center = new Vector3d(center);
        this.material = material;
    }

    double closestIntersectionPoint(Ray ray, double min, double max) {
        if(ray.getDir().dot(normal)==0){ // If ray is parallel to plane
            return -1; // We do not consider important the case where the camera is in the plane (where the ray should intersect the plane)
        }
        double t = center.sub(ray.getPos()).dot(normal)/ray.getDir().dot(normal);
        if(t<min || t>max){
            return -1;
        }
        return t;
    }

    Vector3d normal(Vector3d point) {
        return new Vector3d(normal);
    }

    Drawable copy() {
        return new Plane(normal, center, material);
    }

    Vector3d getUVCoordinates(Vector3d point) {
        Vector3d xDir;
        Vector3d yDir;
        if(normal.isColinear(Vector3d.ZDIR)){
            xDir = Vector3d.XDIR;
            yDir = Vector3d.YDIR;
        } else {
            xDir = normal.cross(Vector3d.ZDIR).normalize();
            yDir = normal.cross(xDir).normalize();
        }
        Vector3d toPoint = point.sub(center);
        return new Vector3d(toPoint.dot(xDir), toPoint.dot(yDir), 0);
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

    public Vector3d getCenter() {
        return new Vector3d(center);
    }
}
