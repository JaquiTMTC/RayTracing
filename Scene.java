import java.util.LinkedList;
public class Scene {
    protected LinkedList<Drawable> geometry;
    protected Vector3d light;
    public Scene(LinkedList<Drawable> _geometry, Vector3d light_pos){
        geometry = _geometry;
        light = light_pos;
    }

    public LinkedList<Drawable> getGeometry() {
        LinkedList<Drawable> returnList = new LinkedList<Drawable>();
        for(Drawable geo: geometry){
            returnList.add(geo.copy());
        }
        return returnList;
    }

    public HitInfo getIntersection(Ray ray){
        double tMin = Double.MAX_VALUE;
        double t;
        Drawable closestObject = null;

        for(Drawable obj: geometry){
            t = obj.closestIntersectionPoint(ray);
            if(t>0.0001 && t<tMin){
                tMin = t;
                closestObject = obj;
            }
        }
        if(closestObject==null){
            return null;
        }

        return new HitInfo(tMin, ray, closestObject);
    }

    // version ancienne avec tableau
    //public Drawable[] getGeometry() {
    // Drawable[]returnArray = new Drawable[geometry.length];
    // for(int i=0; i<returnArray.length; i++){
    //returnArray[i]=geometry[i].copy();
    //}
    //return returnArray; }

    public Vector3d getLight() {
        return new Vector3d(light);
    }
}
