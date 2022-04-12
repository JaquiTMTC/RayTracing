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
        for(Drawable geo: returnList){
            returnList.add(geo.copy());

        }

        //for(int i=0; i< returnArray.length; i++){
            //returnArray[i] = geometry[i].copy();
        //}
        return returnList;
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
