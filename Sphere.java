public class Sphere extends Drawable {
    protected final Vector3d center;
    protected final double radius;

    /**
     * Initializes a new Sphere object with the given parameters.
     * @param center the center of the sphere
     * @param radius the radius of the sphere
     * @param material the material of the sphere
     */
    public Sphere(Vector3d center, double radius, Material material){
        this.center = new Vector3d(center);
        this.radius = radius;
        this.material = material;
    }

    public double closestIntersectionPoint(Ray ray, double min, double max){
        Vector3d toCenter = ray.pos.sub(center);
        double a = 1;
        double halfB = toCenter.dot(ray.dir);
        double c = toCenter.normSq()-radius*radius;

        double quarterDelta = halfB*halfB-a*c;
        if(quarterDelta<0){
            return -1;
        }
        double root = (-halfB-Math.sqrt(quarterDelta))/a;
        if (root<min || root > max){
            root = (-halfB+Math.sqrt(quarterDelta))/a;
            if(root<min || root > max){
                return -1;
            }
        }
        return root;
    }

    public Vector3d normal(Vector3d point) {
        return point.sub(center).normalize();
    }

    Vector3d getUVCoordinates(Vector3d point) {
        Vector3d toPoint = point.sub(center);
        // We convert to polar coordinates
        double r = toPoint.norm();
        double theta = Math.acos(toPoint.z/r);
        double phi = Math.atan(toPoint.y/toPoint.x);
        return new Vector3d(phi, theta, 0);
    }

    public Sphere copy() {
        return new Sphere(center, radius, material);
    }

    public String toString() {
        return "Sphere{" +
                "center=" + center +
                ", radius=" + radius +
                ", material=" + material +
                '}';
    }
}
