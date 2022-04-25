import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedList;

public class Glass extends Material{

    public double index;

    public Glass(double index){
        this.index = index;
        color = Color.GREEN;
    };

    public boolean bounces() {
        return true;
    }

    public double[] getCoeffs(HitInfo info){
        boolean outside = info.rayIn.dir.dot(info.normal) < 0; // Is the ray coming from outside
        double[] coeffs;
        if(canRefract(info)){
            coeffs = new double[2];
            if(outside){
                double i = info.rayIn.dir.angle(info.normal.mult(-1));
                double sinr = Math.sin(i) / index;
                double cosr = Math.sqrt(1 - Math.pow(sinr, 2));
                double r = Math.asin(sinr);
                coeffs[0] = 0.5*(Math.pow(Math.tan(i-r), 2)/Math.pow(Math.tan(i+r), 2))+0.5*(Math.pow(Math.sin(i-r), 2)/Math.pow(Math.sin(i+r), 2));
            } else {
                double i = info.rayIn.dir.angle(info.normal);
                double sinr = Math.sin(i) * index;
                double cosr = Math.sqrt(1 - Math.pow(sinr, 2));
                double r = Math.asin(sinr);
                coeffs[0] = 0.5*(Math.pow(Math.tan(i-r), 2)/Math.pow(Math.tan(i+r), 2))+0.5*(Math.pow(Math.sin(i-r), 2)/Math.pow(Math.sin(i+r), 2));
            }
            //System.out.println(coeffs[0]);
            coeffs[1] = 1-coeffs[0];
//            coeffs[0] = (1-Math.abs(info.rayIn.dir.dot(info.normal)));
//            coeffs[1] = (Math.abs(info.rayIn.dir.dot(info.normal)));
        } else {
            coeffs = new double[1];
            coeffs[0] = 1;
        }
        return coeffs;
    }

    public Ray[] bouncedRays(HitInfo info) {
        Ray[] rays;

        if(canRefract(info)) { // Refracted ray
            boolean outside = info.rayIn.dir.dot(info.normal) < 0; // Is the ray coming from outside
            rays = new Ray[2];
            if (outside) { // Ray coming from outside the material
                double i = info.rayIn.dir.angle(info.normal.mult(-1));
                double sinr = Math.sin(i) / index;
                double cosr = Math.sqrt(1 - Math.pow(sinr, 2));
                Vector3d tangent1 = info.rayIn.dir.cross(info.normal);
                Vector3d tangent2 = info.normal.cross(tangent1).normalize();

                Vector3d refractedDir = tangent2.mult(sinr).add(info.normal.mult(-cosr));
                rays[1] = new Ray(info.position, refractedDir);
            } else { // Ray coming from inside the material
                double i = info.rayIn.dir.angle(info.normal);
                double sinr = Math.sin(i) * index;
                double cosr = Math.sqrt(1 - Math.pow(sinr, 2));
                Vector3d tangent1 = info.rayIn.dir.cross(info.normal);
                Vector3d tangent2 = info.normal.cross(tangent1).normalize();

                Vector3d refractedDir = tangent2.mult(sinr).add(info.normal.mult(cosr));
                rays[1] = new Ray(info.position, refractedDir);
            }
        } else {
            rays = new Ray[1];
        }

        // Reflected ray
        rays[0] = info.rayIn.bounce(info.position, info.normal);
//        Vector3d cross = info.rayIn.dir.cross(info.normal); // The normal to the plane containing the vectors
//        Vector3d parallel = info.normal.cross(cross).normalize();
//        Vector3d tangentialDiff = parallel.mult(info.normal.add(info.rayIn.dir).dot(parallel)*2);
//        Vector3d newDir = info.rayIn.dir.mult(-1).add(tangentialDiff);
//        rays.add(new Ray(info.position, newDir));

        return rays;
    }

    private boolean canRefract(HitInfo info){
        boolean outside = info.rayIn.dir.dot(info.normal) < 0; // Is the ray coming from outside
        boolean canRefract;
        if(outside){
            double i = info.rayIn.dir.angle(info.normal.mult(-1));
            return Math.sin(i) / index <1;
        }
        // inside
        double i = info.rayIn.dir.angle(info.normal);
        return Math.sin(i)*index<1;
    }

}
