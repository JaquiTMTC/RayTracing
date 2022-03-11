//import java.awt.*;
//
//public class Testing {
//    public static void main(String[] args) {
//        Vector3d center = new Vector3d(1, 1, 1);
//        Vector3d yoo = new Vector3d(0, 3, 2);
//
//
//        // Testing vecteurs
//
//        Vector3d pos = new Vector3d();
//        Vector3d temp1 = pos.add(center);
//        Vector3d temp2 = center.add(pos);
//        Vector3d temp3 = pos.sub(center);
//        Vector3d temp4 = center.sub(pos);
//        Vector3d temp5 = pos.mult(5);
//        Vector3d temp6 = center.mult(2);
//        Vector3d temp7 = center.mult(4).sub(center);
//        double temp8 = center.dot(yoo);
//        double temp9 = center.norm();
//        Vector3d temp10 = center.normalize();
//        double temp11 = center.normSq();
//
//        Vector3d vec1 = new Vector3d(1, 2, 3);
//        Vector3d vec2 = new Vector3d(4, 5, 6);
//        Vector3d temp30 = vec1.cross(vec2);
//
//        // Testing Ray
//
//        Vector3d dir = new Vector3d(1, 1, 0.5);
//        Ray ray = new Ray(pos, dir);
//        Vector3d temp12 = ray.at(2.5);
//        Vector3d temp13 = ray.getPos();
//        Vector3d temp14 = ray.getDir();
//
//        // Testing Sphere
//
//        Sphere sphere = new Sphere(center, 1, Color.BLACK, false);
//        sphere.precomputeCamera(new Vector3d(0, 0, 0));
//        double t = sphere.closestIntersectionPoint(ray);
//        Vector3d intersection = ray.at(t);
//        System.out.println("");
//        Vector3d normal = sphere.normal(new Vector3d());
//
//        // Testing bounce
//
//        Vector3d myNormal = new Vector3d(1, 1, 5).normalize();
//        Vector3d myDir = new Vector3d(-2, -3, -1);
//        Ray myRay = new Ray(new Vector3d(), myDir);
//        Ray myBounce = myRay.bounce(myRay.pos, myNormal);
//        System.out.println(myBounce.dir);
//
//    }
//}
