import java.awt.Graphics;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Window extends JPanel implements ActionListener {

    double theta;

    public Window(double theta){
        this.theta = theta;
    }

    public void paint(Graphics g) {
        Image img = drawImage();
        g.drawImage(img, 0, 0, this);
    }

    public Image drawImage(){

        // Initializing scene

        int width = 720;
        int height = 720;

        //BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        Camera camera = new Camera(new Vector3d(0, 0, 0), new Vector3d(1, 0, 0), width, height, Math.PI/2);

        // Materials
        Metal silver = new Metal(Color.black);
        Diffuse white = new Diffuse(Color.white);
        Diffuse red = new Diffuse(Color.red);
        Diffuse blue = new Diffuse(Color.blue);
        Diffuse green = new Diffuse(Color.green);

        Drawable[] geometry = {

                new Sphere(new Vector3d(4, 0, 0), 1.5, blue),
                new Sphere(new Vector3d(-0.5, 0.2, 0.2), 0.1, silver),
                new Sphere(new Vector3d(0.5, -0.2, 0.2), 0.1, silver),

                new Plane(new Vector3d(0, 1, 0), new Vector3d(0, -3, 0 ), red),
                new Plane(new Vector3d(0, -1, 0), new Vector3d(0, 3, 0 ), green),
                new Plane(new Vector3d(-1, 0, 0), new Vector3d(5, 0, 0), white),
                new Plane(new Vector3d(0, 0, -1), new Vector3d(0, 0, 3), white),
                new Plane(new Vector3d(0, 0, 1), new Vector3d(0, 0, -3), white),
                new Plane(new Vector3d(1, 0, 0), new Vector3d(-5, 0, 0), white),

                new Cube(1,1, 1, new Vector3d(2, .7, .7), false, green),

        };

        Scene scene = new Scene(geometry, new Vector3d(1, 2*Math.cos(2*theta), 2));

        // Precompute values
//        for(Drawable obj:geometry){
//            obj.precomputeCamera(camera.getPos());
//        }


        // For each pixel, calculate its color and insert it in the image
        /*for(int y=0; y<height; y++){
            for(int x=0; x<width; x++){
                Color color = camera.renderPixel(x, y, scene);
                bufferedImage.setRGB(x, y, color.getRGB());
            }
        }
        */


        return camera.renderImage(scene, 10);
    }

    public void actionPerformed(ActionEvent e) {
        theta += 0.1;
        repaint();
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        Window window = new Window(0);
        frame.getContentPane().add(window);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(720, 720);
        frame.setVisible(true);

        Timer timer = new Timer(10, window);
        //timer.start();

    }
}
