public abstract class Drawable {
    Material material;
    /**
     * Computes the distance of the closest intersection from the start of the ray.
     * @param ray the ray to check intersection with
     * @param min the minimum distance
     * @param max the maximum distance
     */
    abstract double closestIntersectionPoint(Ray ray, double min, double max);

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
