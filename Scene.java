import java.util.LinkedList;
public class Scene {
    public LinkedList<Drawable> geometry;
    public Vector3d light;
    public Scene(LinkedList<Drawable> geometry, Vector3d light_pos){
        this.geometry = geometry;
        light = light_pos;
    }

    public HitInfo getIntersection(Ray ray){
        double tMin = Double.MAX_VALUE;
        double t;
        Drawable closestObject = null;

        for(Drawable obj: geometry){
            // The min value is empirically the value which dos not produces visual artifacts
            t = obj.closestIntersectionPoint(ray, 0.000000000001, tMin);
            if(t>0){
                tMin = t;
                closestObject = obj;
            }
        }
        if(closestObject==null){
            return null;
        }

        return new HitInfo(tMin, ray, closestObject);
    }
}
