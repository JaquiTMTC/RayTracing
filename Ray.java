public class Ray {

    protected Vector3d pos;
    protected Vector3d dir;

    public Ray(Vector3d pos, Vector3d dir){
        this.pos = new Vector3d(pos);
        this.dir = new Vector3d(dir).normalize();
    }

    /**
     * Returns the vector to the point of the ray a parameter t
     * @param t the parameter of the ray
     * @return the vector to the point of the ray a parameter t
     */
    public Vector3d at(double t){
        return pos.add(dir.mult(t));
    }

    /** Bounces the ray on a surface
     * @param point the point where the ray bounces
     * @param normal The normal to the surface
     * @return the bounced ray
     */
    public Ray bounce(Vector3d point, Vector3d normal){
        Vector3d cross = dir.cross(normal); // The normal to the plane containing the vectors
        Vector3d parallel = normal.cross(cross).normalize();
        Vector3d tangentialDiff = parallel.mult(normal.add(dir).dot(parallel)*2);
        Vector3d newDir = dir.mult(-1).add(tangentialDiff);
        return new Ray(point, newDir);
    }

    @Override
    public String toString() {
        return "Ray{" +
                "pos=" + pos +
                ", dir=" + dir +
                '}';
    }

    // Getters & setters

    public Vector3d getPos() {
        return new Vector3d(pos);
    }

    public Vector3d getDir() {
        return new Vector3d(dir);
    }
}
