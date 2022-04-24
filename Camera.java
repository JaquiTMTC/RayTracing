import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.LinkedList;

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
        //System.out.println(verticalFOV);

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
    private Ray createRay(int x, int y){

        double xMax = Math.tan(horizontalFOV/2);
        double yMax = xMax*height/width;

        double xComp = (double)x/width*(2*xMax)-xMax;
        double yComp = (double)y/height*(2*yMax)-yMax;

        return new Ray(pos, xDir.mult(xComp).add(yDir.mult(yComp)).add(normal));

    }

    /**
     * Calculates the color of a pixel given a scene
     * @param x the x coordinate of the pixel
     * @param y the y coordinate of the pixel
     * @param scene the scene that contains the geometry to render
     * @return the color of the given pixel
     */
    private Color renderPixel(int x, int y, Scene scene, int maxBounces){
//        if(x<=10 && y>=710){
//            return Color.red;
//        }
        Ray ray = createRay(x, y);
        //System.out.println(x+" "+y);
        Color returnColor = renderRay(ray, scene, maxBounces);
        returnColor = ((returnColor==null) ? sky(ray) : returnColor);
        return (returnColor);
    }

    private Color renderRay(Ray ray, Scene scene, int maxBounces){

        HitInfo info= getIntersection(scene, ray);


        if (info==null){
            return null;
        }

        if(info.closestObject.material.bounces()){
            return renderRay(info.closestObject.material.bouncedRay(ray, info.normal, info.position), scene, maxBounces-1);
        } else {
            return info.closestObject.material.getColor(info, scene, this);
        }
    }

    public HitInfo getIntersection(Scene scene, Ray ray){
        double tMin = Double.MAX_VALUE;
        double t;
        Drawable closestObject = null;

        for(Drawable obj: scene.geometry){
            t = obj.closestIntersectionPoint(ray);
            if(t>0.0001 && t<tMin){
                tMin = t;
                closestObject = obj;
            }
        }
        if(closestObject==null){
            return null;
        }

        return new HitInfo(tMin, ray, closestObject);
    }

    public Image renderImage (Scene scene, int maxBounces) {
        BufferedImage imageRendu = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        for(int y=0; y<height; y++){
            for(int x=0; x<width; x++){
                Color color = this.renderPixel(x, y, scene, maxBounces);
                imageRendu.setRGB(x, y, color.getRGB());
            }
        }
        return imageRendu ;
    }

    private Color sky(Ray ray) {
        double blueProportion = 1-(Math.abs(ray.dir.z*0.75));
        //System.out.println(blueProportion);
        return new Color((int)(blueProportion*255), (int)(blueProportion*255), 255);
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
