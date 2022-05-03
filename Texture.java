import java.awt.*;
import java.awt.image.BufferedImage;

public class Texture extends Diffuse{

    public BufferedImage texture;

    public Texture(BufferedImage image){
        texture = image;
    }

    protected Color getPrimaryColor(HitInfo info){
        Vector3d UVCoordinates = info.closestObject.getUVCoordinates(info.position);
        int xPixel = (int)((UVCoordinates.x%1+1)/2* (texture.getWidth()-1));
        int yPixel = (int)((UVCoordinates.y%1+1)/2* (texture.getHeight()-1));
        return new Color(texture.getRGB(xPixel, yPixel));
    }

    @Override
    public String toString() {
        return "Texture";
    }
}
