public class Vector3d {
    double x;
    double y;
    double z;

    public Vector3d(){
        x = 0;
        y = 0;
        z = 0;
    }

    public Vector3d(double _x, double _y, double _z){
        x = _x;
        y = _y;
        z = _z;
    }

    public Vector3d normalize(){
        double norm = norm();
        return new Vector3d(x/norm, y/norm, z/norm);
    }

    public double norm(){
        return Math.sqrt(Math.pow(x, 2)+Math.pow(y, 2)+Math.pow(z, 2));
    }

    public double normSq(){
        return Math.pow(x, 2)+Math.pow(y, 2)+Math.pow(z, 2);
    }

    public double dot(Vector3d v){
        return x*v.x+y*v.y+z*v.z;
    }

    public Vector3d cross(Vector3d v){
        return new Vector3d(y*v.z-z*v.y, z*v.x-x*v.z, x*v.y-y*v.x);
    }

    public Vector3d add(Vector3d v){
        return new Vector3d(x+v.x, y+v.y, z+v.z);
    }

    public Vector3d sub(Vector3d v){
        return new Vector3d(x-v.x, y-v.y, z-v.z);
    }

    public double squared(){
        return dot(this);
    }

    public Vector3d mult(double t){
        return new Vector3d(t*x, t*y, t*z);
    }

    public Vector3d copy(){
        return new Vector3d(x, y, z);
    }

    public double angle(Vector3d v){
        return Math.acos(dot(v)/(norm()*v.norm()));
    }

    public String toString(){
        return "("+x+", "+y+", "+z+")";
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vector3d vector3d = (Vector3d) o;
        return Double.compare(vector3d.x, x) == 0 && Double.compare(vector3d.y, y) == 0 && Double.compare(vector3d.z, z) == 0;
    }
}
