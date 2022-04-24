import java.awt.*;

public abstract class Material {
    protected Color color;
    public Color getColor(HitInfo info, Scene scene, Camera cam){
        return color;
    }
    abstract boolean bounces();
    abstract Ray[] bouncedRays(HitInfo info);

    abstract double[] getCoeffs(HitInfo info);
}
