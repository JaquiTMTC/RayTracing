public class Cube extends Drawable{

    protected Vector3d center;
    protected Vector3d[] basis;  // 0 = x, 1 = y, 2 = z
    protected double[] dimensions;

    protected Plane[] planes;


    public Cube(Vector3d center, double width, double height, double depth, double zAngle, Material material){
        basis = new Vector3d[3];
        basis[2] = Vector3d.ZDIR;
        basis[0] = new Vector3d(Math.cos(zAngle), Math.sin(zAngle), 0);
        basis[1] = new Vector3d(-Math.sin(zAngle), Math.cos(zAngle), 0);
        dimensions = new double[]{depth, width, height};
        this.center = center;
        this.material = material;
        fillPlanes();
    }

    private void fillPlanes() {
        planes = new Plane[6];
        for(int i=0;i<3;i++){
            planes[2*i] = new Plane(basis[i], center.add(basis[i].mult(dimensions[i]/2)), material);
            planes[2*i+1] = new Plane(basis[i].mult(-1), center.sub(basis[i].mult(dimensions[i]/2)), material);
        }
    }

    double closestIntersectionPoint(Ray ray, double min, double max) {
        double tMin = Double.MAX_VALUE;
        for(Plane plane:planes){
            double t = plane.closestIntersectionPoint(ray,min, max);
            if (t<tMin && t>min && t<max && pointInBox(ray.at(t))){
                tMin = t;
            }
        }
        return tMin==Double.MAX_VALUE ? -1 : tMin;
    }

    private boolean pointInBox(Vector3d point) {
        Vector3d toPoint = point.sub(center);
        for(int i=0;i<3;i++){
            if(Math.abs(toPoint.dot(basis[i]))>dimensions[i]/2+0.000001){
                return false;
            }
        }
        return true;
    }

    Vector3d normal(Vector3d point) {
        int maxAt = getPlane(point);
        Vector3d toPoint = point.sub(center);
        double[] dim = inLocalCoordinates(point);
        return dim[maxAt]==toPoint.dot(basis[maxAt])/dimensions[maxAt] ? planes[2*maxAt].normal(Vector3d.ZDIR) : planes[2*maxAt+1].normal(Vector3d.ZDIR);
    }

    private int getPlane(Vector3d point) {
        double[] dim = inLocalCoordinates(point);

        int maxAt = 0;
        for (int i = 0; i < 3; i++) {
            maxAt = dim[i] > dim[maxAt] ? i : maxAt;
        }
        return maxAt;
    }

    private double[] inLocalCoordinates(Vector3d point){
        Vector3d toPoint = point.sub(center);
        double[] dim = new double[3];
        for (int i = 0; i < 3; i++) {
            dim[i] = Math.abs(toPoint.dot(basis[i])/dimensions[i]);
        }
        return dim;
    }

    Vector3d getUVCoordinates(Vector3d point) {
        int maxAt = getPlane(point);
        Vector3d planeUV = planes[2*maxAt].getUVCoordinates(point);
        int vector1 = (maxAt+1)%3;
        int vector2 = maxAt == 0 ? 2 : maxAt-1;
        if(vector2 == 0){
            int temp = vector2;
            vector2 = vector1;
            vector1 = temp;
        }
        Vector3d toPoint = point.sub(planes[2*maxAt].getCenter());
        return new Vector3d(toPoint.dot(basis[vector1]), toPoint.dot(basis[vector2]), 0);
    }

    Drawable copy() {
        return null;
    }

    public String toString (){
        return "Cube{" +
                "center=" + center +
                ", cote=" + dimensions[1] +
                ", material=" + material +
                '}';
    }
}
