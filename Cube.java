import java.awt.Color;
import java.util.LinkedList;
import java.util.Objects;

public class Cube extends Drawable {

    private Vector3d normal1;
    private Vector3d normal2;
    private Vector3d normal3;
    private Vector3d normal4;
    private Vector3d normal5;
    private Vector3d normal6;
    LinkedList<Vector3d> listNormal;
    private Vector3d center;
    double c;
    private Vector3d n;

    public Cube(Vector3d _normal1, Vector3d _normal2, Vector3d _normal3, Vector3d _normal4, Vector3d _normal5, Vector3d _normal6, Vector3d _center, Color  _color, boolean _isReflective) {

    normal1 = new Vector3d(_normal1);
    normal2 = new Vector3d(_normal2);
    normal3 = new Vector3d(_normal3);
    normal4 = new Vector3d(_normal4);
    normal5 = new Vector3d(_normal5);
    normal6 = new Vector3d(_normal6);
    center = new Vector3d(_center);
    color = _color;
    isReflective = _isReflective;

    }
    public Cube (LinkedList _listNormal, double _c, Vector3d _n) {

        listNormal = new LinkedList<Vector3d>();
        c = 00;
        n = new Vector3d(_n);
    }

    public void fillList (LinkedList listNormal) {

        listNormal.add(0,normal1);
        listNormal.add(1,normal2);
        listNormal.add(2,normal3);
        listNormal.add(3,normal4);
        listNormal.add(4,normal5);
        listNormal.add(5,normal6);
    }

    double closestIntersectionPoint(Ray ray) {
        for (Vector3d normal : listNormal) {
            if (ray.getDir().dot(normal) == 0) {
                return -1;
            }
            return c = (center.sub(ray.getPos()).dot(normal) / ray.getDir().dot(normal));
        }
        return c;
    }

    Vector3d normal(Vector3d point) {
//        for (Vector3d normal : listNormal) {
//            return new n = (Vector3d(normal));
//        }
//        return n;
        return null;
    }

    Drawable copy() {
        return new Cube (normal1, normal2, normal3, normal4, normal5, normal6, center, color, isReflective);
    }

 /*   public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cube cube = (cube) o;
        return Objects.equals(normal, plane.normal) && Objects.equals(center, plane.center);
    }*/
}
