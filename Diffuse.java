import java.awt.*;

public class Diffuse extends Material{

    public Diffuse(Color color){
        this.color = color;
    }

    public Diffuse(){
        this.color = Color.BLACK;
    }

    public Color getColor(HitInfo info, Scene scene){
        Vector3d toLight = scene.light.sub(info.position);
        double lightDistance = toLight.norm();
        Ray toLightRay = new Ray(info.position, toLight);
        HitInfo infoLight = scene.getIntersection(toLightRay);
        double angle = info.normal.angle(toLight)*7/8;
        if(infoLight != null && infoLight.t <= lightDistance){  // If we are in the shadow of an object, we render black
            angle = (Math.PI/2)*7/8;
        }

        // We get the color of a point based on the color of the object and the angle of the surface to the light
        double rColor = Math.max(getPrimaryColor(info).getRed() * Math.cos(angle), 0);
        double gColor = Math.max(getPrimaryColor(info).getGreen() * Math.cos(angle), 0);
        double bColor = Math.max(getPrimaryColor(info).getBlue() * Math.cos(angle), 0);
        return new Color((int) rColor, (int) gColor, (int) bColor);
    }

    protected Color getPrimaryColor(HitInfo info) {
        return color;
    }

    boolean bounces(HitInfo info) {
        return false;
    }

    Ray[] bouncedRays(HitInfo info) {
        return new Ray[0];
    }

    double[] getCoeffs(HitInfo info) {
        return new double[0];
    }

}
