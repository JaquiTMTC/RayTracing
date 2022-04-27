import java.awt.*;

public class Metal extends Material{

    public Metal(Color color){
        this.color = color;
    }

    public boolean bounces(HitInfo info) {
        return true;
    }

    double[] getCoeffs(HitInfo info) {
        return new double[]{1};
    }

    public Ray[] bouncedRays(HitInfo info) {
        return new Ray[]{info.rayIn.bounce(info.position, info.normal)};
    }
}
