import java.awt.*;

public class Diffuse extends Material{

    public Diffuse(Color color){
        this.color = color;
    }

    public Color getColor(Vector3d pos, Vector3d normal, Scene scene, Camera cam){
        Vector3d toLight = scene.light.sub(pos);
        double lightDistance = toLight.norm();
        Ray toLightRay = new Ray(pos, toLight);
        Object[] toLightIntersection = cam.getIntersection(scene, toLightRay);
        double angle = normal.angle(toLight);
        if((double) toLightIntersection[0] <= lightDistance){  // If we are in the shadow of an object, we render black
            angle = 2*Math.PI/6;
            //return Color.red;
        }

        // We get the color of a point based on the color of the object and the angle of the surface to the light
        double rColor = Math.max(color.getRed() * Math.cos(angle), 0);
        double gColor = Math.max(color.getGreen() * Math.cos(angle), 0);
        double bColor = Math.max(color.getBlue() * Math.cos(angle), 0);
        return new Color((int) rColor, (int) gColor, (int) bColor);
    }

    boolean bounces() {
        return false;
    }

    Ray bouncedRay(Ray ray, Vector3d normal, Vector3d pos) {
        return null;
    }
}
