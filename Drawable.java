import java.awt.Color;

public abstract class Drawable {
    Material material;
    /**
     * Computes the parameter of the closest intersection point given en certain ray, you can access the intersection
     * point by using ray.at on the return value.
     * @param ray the ray to check intersection with
     */
    abstract double closestIntersectionPoint(Ray ray);

    /**
     * Computes the normal vector of the drawable at a given point.
     * The point does not have to belong to the sphere, but if so the result may be wrong or useless
     * @param point the point
     * @return the normal vector
     */
    abstract Vector3d normal(Vector3d point);

    abstract Drawable copy();

    /**
     * Gives the UV coordinates of a given point on the surface of the drawable.
     * The UV coordinates are used to project a texture on the drawable
     * If the point isn't on the surface, the results may be wrong or useless
     * @param point the point
     * @return A vector which contains : x = u, y = v, z is useless
     */
    abstract Vector3d getUVCoordinates(Vector3d point);
}
