import java.awt.*;

public class Metal extends Material{

    public Metal(Color color){
        this.color = color;
    }

    public boolean bounces() {
        return true;
    }

    public Ray bouncedRay(Ray ray, Vector3d normal, Vector3d pos) {
        return ray.bounce(pos, normal);
    }
}
