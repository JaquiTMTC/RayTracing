import java.awt.*;

public abstract class Material {
    Color color;

    /**
     * Gives the color of the object at position contained in info
     * @param info  HitInfo object of the intersection
     * @param scene The scene to determine if the object is in shadow
     * @return the color
     */
    public Color getColor(HitInfo info, Scene scene){
        return color;
    }

    /** Determines if the material produces bounced rays
     */
    abstract boolean bounces(HitInfo info);

    /** Reflects the ray incoming on the material.
     * When multiple rays are returned, the color must be the weighted average of each ray.
     * The coefficients are given in getCoeffs()
     * @param info the HitInfo object for given hit
     * @return the array of Rays
     */
    abstract Ray[] bouncedRays(HitInfo info);

    /** Returns the coefficients associated with each bounced ray, the sum of all coefficients add up to one.
     * @param info the HitInfo object for given hit
     * @return The array of coefficients
     */
    abstract double[] getCoeffs(HitInfo info);
}
