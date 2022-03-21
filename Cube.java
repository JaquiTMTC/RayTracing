import java.awt.Color;
import java.util.LinkedList;
import java.util.Objects;

public class Cube extends Drawable {

    private int largeur; // axe y
    private int hauteur; // axe z
    private int profondeur; // axe x
    private Vector3d center;
    private boolean isReflective;
    private LinkedList <Vector3d> interBons;
    private LinkedList <Plane> listPlans;

    public Cube(int _largeur, int _hauteur, int _profondeur, Vector3d _center, boolean _isReflective, Color _color) {

        largeur = _largeur;
        hauteur = _hauteur;
        profondeur = _profondeur;
        center = _center;
        isReflective = _isReflective;
        color = _color;
    }
    public Cube(LinkedList _interBons, LinkedList _listPlans) {

        _interBons = new LinkedList<Vector3d>();
        _listPlans = new LinkedList<Plane>();
    }
    private void fill () {
        Vector3d centrePlans;

        centrePlans = (center.add( new Vector3d (profondeur/2, 0, 0)));
        listPlans.add(new Plane(new Vector3d(1, 0, 0), centrePlans, color, isReflective ));

        centrePlans = (center.add( new Vector3d (-profondeur/2, 0, 0)));
        listPlans.add(new Plane(new Vector3d(-1, 0, 0), centrePlans, color, isReflective ));

        centrePlans = (center.add( new Vector3d (0, largeur/2, 0)));
        listPlans.add(new Plane (new Vector3d(0, 1, 0), centrePlans, color, isReflective));

        centrePlans = (center.add( new Vector3d (0, -largeur/2, 0)));
        listPlans.add(new Plane (new Vector3d(0, -1, 0), centrePlans, color, isReflective));

        centrePlans = (center.add( new Vector3d (0, 0, hauteur/2)));
         listPlans.add( new Plane(new Vector3d (0, 0, 1), centrePlans, color, isReflective));

        centrePlans = (center.add( new Vector3d (0, 0, -hauteur/2)));
        listPlans.add( new Plane ( new Vector3d(0, 0, -1), centrePlans, color, isReflective));
    }

    double closestIntersectionPoint(Ray ray) {
        for (Plane unPlan : listPlans ) {
            if (ray.getDir().dot(unPlan.normal(new Vector3d(0, 0, 0))) == 0) { // If ray is parallel to plane
                return -1; // We do not consider important the case where the camera is in the plane (where the ray should intersect the plane)
            }

        }
        return 0;

    }

   Vector3d normal(Vector3d point) {
//        for (Vector3d normal : listNormal) {
//            return new Vector3d(normal);
//        }
//        return n;
       return null;
    }

    Drawable copy() {

        return null;
    }

   // public boolean equals(Object o) {
     //   if (this == o) return true;
     //   if (o == null || getClass() != o.getClass()) return false;
        //Cube cube = (cube) o;

      //  return Objects.equals(n, cube.n) && Objects.equals(center, cube.center);
    //}

}
