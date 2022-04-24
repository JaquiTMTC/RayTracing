public class HitInfo {
    public final double t;
    public final Vector3d position;
    public final Ray rayIn;
    public final Drawable closestObject;
    public final Vector3d normal;

    public HitInfo(double t, Ray rayIn, Drawable closestObject){
        this.t = t;
        this.rayIn = rayIn;
        this.closestObject = closestObject;
        position = rayIn.at(t);
        normal = closestObject.normal(position);
    }
}
