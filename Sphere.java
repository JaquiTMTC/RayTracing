import java.awt.Color;

public class Sphere extends Drawable {
    protected final Vector3d center;
    protected final double radius;

    // Precomputed values

    //private double cSq;

    /**
     * Initializes a new Sphere object with the given parameters.
     * @param _center the center of the sphere
     * @param _radius the radius of the sphere
     * @param material the material of the sphere
     */
    public Sphere(Vector3d _center, double _radius, Material material){
        center = new Vector3d(_center);
        radius = _radius;
        this.material = material;
    }

//    public boolean intersects(Ray ray) {
//        double rSq = Math.pow(radius, 2);
//        double cSq = center.sub2(ray.getPos()).squared2();
//        double t = ray.getPos().sub2(center).dot(ray.getDir());
//        double bSq = ray.at(t).sub2(ray.getPos().sub2(center)).normSq();
//        return bSq>=
//    }

//    /**
//     * Computes values that will not change during all the rendering process,
//     * this method must be called in order for closestIntersectionPoint to work
//     * @param pos the position of the camera
//     */
//    public void precomputeCamera(Vector3d pos){
//        cSq = center.sub(pos).squared();
//    }

    /**
     * Computes the parameter of the closest intersection point given en certain ray, you can access the intersection
     * point by using ray.at on the return value.
     * /!\ In order to work for this method, the method precomputeCamera must have been previously called.
     * @param ray the ray to check intersection with
     */
    public double closestIntersectionPoint(Ray ray) {
        Vector3d toCenter = ray.pos.sub(center);
        double a = 1;
        double halfB = toCenter.dot(ray.dir);
        double c = toCenter.normSq()-radius*radius;

        double quarterDelta = halfB*halfB-a*c;
        if(quarterDelta<0){
            return -1;
        }
        double root = (-halfB-Math.sqrt(quarterDelta))/a;
        if (root<0.0001){
            root = (-halfB+Math.sqrt(quarterDelta))/a;
            if(root<0.0001){
                return -1;
            }
        }
//        if(root<0){
//            root = (-halfB+Math.sqrt(quarterDelta))/a;
//        }
        return root;
    }

    /**
     * Computes the normal vector of the sphere at a given point. >The point does not have to belong to the sphere
     * @param point the point
     * @return the normal vector
     */
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
                '}';
    }
}
