public class Scene {
    protected Drawable[] geometry;
    protected Vector3d light;
    public Scene(Drawable[] _geometry, Vector3d light_pos){
        geometry = _geometry;
        light = light_pos;
    }

    public Drawable[] getGeometry() {
        Drawable[] returnArray = new Drawable[geometry.length];
        for(int i=0; i< returnArray.length; i++){
            returnArray[i] = geometry[i].copy();
        }
        return returnArray;
    }

    public Vector3d getLight() {
        return new Vector3d(light);
    }
}
