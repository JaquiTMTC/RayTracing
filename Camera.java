import java.awt.Color;

public class Camera {
    protected Vector3d normal;
    protected Vector3d xDir;
    protected Vector3d yDir;
    protected Vector3d pos;
    protected int width;
    protected int height;
    protected double verticalFOV;
    protected double horizontalFOV;

    /**
     * Initializes a new camera object with the given parameters
     * @param _pos the position of the camera
     * @param _normal the normal vector of the camera
     * @param _width the width in pixel
     * @param _height the height in pixel
     * @param _horizontalFOV the field of view in radians of the camera
     */
    public Camera(Vector3d _pos, Vector3d _normal, int _width, int _height, double _horizontalFOV){
        pos = new Vector3d(_pos);
        normal = new Vector3d(_normal).normalize();
        width = _width;
        height = _height;
        xDir = normal.cross(new Vector3d(0, 0, 1)).normalize();
        yDir = normal.cross(xDir).normalize();

        horizontalFOV = _horizontalFOV;
        verticalFOV = horizontalFOV*height/width;

//        System.out.println(normal);
//        System.out.println(xDir);
//        System.out.println(yDir);

    }

    /**
     * Given a pixel, creates the ray to render this pixel
     * @param x the x coordinate of the pixel
     * @param y the y coordinate of the pixel
     * @return the ray
     */
    public Ray createRay(int x, int y){

        double xMax = Math.tan(horizontalFOV/2);
        double yMax = Math.tan(verticalFOV/2);

        double xComp = (double)x/width*(2*xMax)-xMax;
        double yComp = (double)y/height*(2*yMax)-yMax;

        ////System.out.println(xDir.mult(xComp).add(yDir.mult(yComp)).add(normal));
        ////System.out.println(""+x+" "+y);

        return new Ray(pos, xDir.mult(xComp).add(yDir.mult(yComp)).add(normal));

    }

    /**
     * Calculates the color of a pixel given a scene
     * @param x the x coordinate of the pixel
     * @param y the y coordinate of the pixel
     * @param scene the scene that contains the geometry to render
     * @return the color of the given pixel
     */
    public Color renderPixel(int x, int y, Scene scene){
        Ray ray = createRay(x, y);
        //System.out.println(x+" "+y);
        return renderRay(ray, scene, 1);
    }

    public Color renderRay(Ray ray, Scene scene, int maxBounces){
        double tMin = Double.MAX_VALUE;
        double t;
        Drawable closestObject = null;

        // For each drawable object of the scene, we calculate its intersection with the ray
        for(Drawable obj:scene.geometry){
            t = obj.closestIntersectionPoint(ray);
            //System.out.println(t);
            //System.out.println(obj);
            if(t>0 && t<tMin){ // If we intersect and the intersection is the closest one yet, we save it
                tMin = t;
                closestObject = obj;
            }
        }

        if (closestObject==null){
            return Color.RED;
        }
        Vector3d intersection = ray.at(tMin);
        Vector3d normalGeometry = closestObject.normal(intersection);
        if(closestObject.isReflective && maxBounces!=0){
            return renderRay(ray.bounce(intersection, normalGeometry), scene, maxBounces-1);
        } else {
            Vector3d toLight = scene.light.sub(intersection);
            double angle = normalGeometry.angle(toLight);
            double rColor = Math.max(closestObject.color.getRed() * Math.cos(angle), 0);
            double gColor = Math.max(closestObject.color.getGreen() * Math.cos(angle), 0);
            double bColor = Math.max(closestObject.color.getBlue() * Math.cos(angle), 0);
            return new Color((int) rColor, (int) gColor, (int) bColor);
//            return closestObject.color;
        }


    }

    // Getters and Setters

    public Vector3d getNormal() {
        return new Vector3d(normal);
    }

    public Vector3d getxDir() {
        return new Vector3d(xDir);
    }

    public Vector3d getyDir() {
        return new Vector3d(yDir);
    }

    public Vector3d getPos() {
        return new Vector3d(pos);
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public double getVerticalFOV() {
        return verticalFOV;
    }

    public double getHorizontalFOV() {
        return horizontalFOV;
    }
}
