import java.awt.Color;

public class Sphere extends Drawable {
    protected final Vector3d center;
    protected final double radius;
    protected final double rSq; // Radius squared

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
        rSq = Math.pow(radius, 2);
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
        /*
        * Computes the closest intersection point by using the method described at
        * https://www.cs.colostate.edu/~cs410/yr2017fa/more_progress/pdfs/cs410_F17_Lecture10_Ray_Sphere.pdf
        * page 10
         */
        //double rSq = Math.pow(radius, 2);
        double cSq = center.sub(ray.getPos()).squared();
        double t = center.sub(ray.getPos()).dot(ray.getDir());
        if(t<0){
            return -1;
        }
        Vector3d temp = ray.at(t);
        double bSq = ray.at(t).sub(center).normSq();
        //double bSq = ray.at(Math.sqrt(t)).sub(ray.getPos().sub(center)).normSq();
        if (bSq>Math.pow(radius, 2)){
            return -1;
        }
        double vSq = cSq-bSq;
        double d = Math.sqrt(rSq-(cSq-vSq));
        //return ray.getPos().add(ray.getDir().mult(Math.sqrt(vSq)-d));
        return Math.sqrt(vSq)-d;
    }

    /**
     * Computes the normal vector of the sphere at a given point. >The point does not have to belong to the sphere
     * @param point the point
     * @return the normal vector
     */
    public Vector3d normal(Vector3d point) {
        return point.sub(center).normalize();
    }

    public Sphere copy() {
        return new Sphere(center, radius, material);
    }

    public String toString() {
        return "Sphere{" +
                "center=" + center +
                ", radius=" + radius +
                ", rSq=" + rSq +
                '}';
    }
}
