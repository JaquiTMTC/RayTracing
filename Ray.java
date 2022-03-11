public class Ray {

    protected Vector3d pos;
    protected Vector3d dir;


    public Ray(Vector3d _pos, Vector3d _dir){
        pos = _pos.copy();
        dir = _dir.copy().normalize();
    }

    /*** Getters and Setters ***/

    public Vector3d getPos() {
        return pos.copy();
    }

    public Vector3d getDir() {
        return dir.copy();
    }


    /**
     * Returns the vector to the point of the ray a parameter t
     * @param t the parameter of the ray
     * @return the vector to the point of the ray a parameter t
     */
    public Vector3d at(double t){
        return pos.add(dir.mult(t));
    }

    public Ray bounce(Vector3d point, Vector3d normal){
//        Vector3d diff = normal.add(dir);
//        Vector3d newDir = dir.mult(-1).add(diff.mult(2));
//        return new Ray(pos, newDir);

        Vector3d cross = dir.cross(normal); // The normal to the plane containing the vectors
        Vector3d parallel = normal.cross(cross).normalize();
        Vector3d tangentialDiff = parallel.mult(normal.add(dir).dot(parallel)*2);
        Vector3d newDir = dir.mult(-1).add(tangentialDiff);
        return new  Ray(pos, newDir);

//        Vector3d normalDiff = normal.mult(2*normal.dot(dir));
//        Vector3d newDir = dir.add(normalDiff);
//        return new Ray(pos, newDir);
    }
}
