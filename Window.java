import java.awt.Graphics;
import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Window  extends  JPanel{

    public void paint(Graphics g) {
        Image img = drawImage();
        g.drawImage(img, 0, 0, this);
    }

    public Image drawImage(){

        // Initializing scene

        int width = 1280;
        int height = 720;

        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        Camera camera = new Camera(new Vector3d(0, 0, 0), new Vector3d(1, 0, 0), width, height, Math.PI/2);

        Drawable[] geometry = {new Sphere(new Vector3d(3, 0, 0), 1, Color.BLUE, true), new Sphere(new Vector3d(-2, 0, 0), 1, Color.YELLOW, false)};

        Scene scene = new Scene(geometry, new Vector3d(1, 0, 2));

        // Precompute values
//        for(Drawable obj:geometry){
//            obj.precomputeCamera(camera.getPos());
//        }


        // For each pixel, calculate its color and insert it in the image
        for(int y=0; y<height; y++){
            for(int x=0; x<width; x++){
                Color color = camera.renderPixel(x, y, scene);
                bufferedImage.setRGB(x, y, color.getRGB());
            }
        }

        return bufferedImage;
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.getContentPane().add(new Window());

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1280, 720);
        frame.setVisible(true);
    }
}
