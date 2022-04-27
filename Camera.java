import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;

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
     * @param pos the position of the camera
     * @param normal the normal vector of the camera
     * @param width the width in pixel
     * @param height the height in pixel
     * @param horizontalFOV the field of view in radians of the camera
     */
    public Camera(Vector3d pos, Vector3d normal, int width, int height, double horizontalFOV){
        this.pos = new Vector3d(pos);
        this.normal = new Vector3d(normal).normalize();
        this.width = width;
        this.height = height;
        xDir = normal.cross(new Vector3d(0, 0, 1)).normalize();
        yDir = normal.cross(xDir).normalize();

        this.horizontalFOV = horizontalFOV;
        verticalFOV = horizontalFOV*height/width;

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

        Ray ray = createRay(x, y);
        Color returnColor = renderRay(ray, scene, maxBounces);
        returnColor = ((returnColor==null) ? sky(ray) : returnColor);
        return (returnColor);
    }

    private Color renderRay(Ray ray, Scene scene, int maxBounces){

        HitInfo info = scene.getIntersection(ray);

        if (info==null){
            return null;
        }

        if(info.closestObject.material.bounces(info) && maxBounces != 0){
            Ray[] bouncedRays = info.closestObject.material.bouncedRays(info);
            double[] coeffs = info.closestObject.material.getCoeffs(info);
            double coeffTotal = coeffs[0];
            Color avgColor = renderRay(bouncedRays[0], scene, maxBounces-1);
            avgColor = avgColor==null ? sky(ray) : avgColor;
            for(int i=1; i<bouncedRays.length; i++){
                Color newColor = renderRay(bouncedRays[i], scene, maxBounces-1);
                newColor = newColor==null ? sky(ray) : newColor;
                int red = (int)((coeffTotal*avgColor.getRed()+coeffs[i]*newColor.getRed())/(coeffTotal+coeffs[i]));
                int green = (int)((coeffTotal*avgColor.getGreen()+coeffs[i]*newColor.getGreen())/(coeffTotal+coeffs[i]));
                int blue = (int)((coeffTotal*avgColor.getBlue()+coeffs[i]*newColor.getBlue())/(coeffTotal+coeffs[i]));
                coeffTotal += coeffs[i];
                avgColor = new Color(red, green, blue);
            }
            return avgColor;
        } else {
            return info.closestObject.material.getColor(info, scene);
        }
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

    private static Color sky(Ray ray) {
        double blueProportion = 1-(Math.abs(ray.dir.z*0.75));
        return new Color((int)(blueProportion*255), (int)(blueProportion*255), 255);
    }

    // Getters and Setters

    public Vector3d getNormal() {
        return new Vector3d(normal);
    }
}
