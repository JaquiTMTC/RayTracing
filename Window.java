import java.awt.Graphics;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;

import javax.imageio.ImageIO;
import javax.swing.*;

public class Window extends JPanel implements ActionListener {

    double theta;

    static int width = 720;
    static int height = 720;

    public Window(double theta){
        this.theta = theta;
    }



    public void paint(Graphics g) { // plus utile, on se sert que de renderImage qui n'utilise pas paint
        Image img = drawImage();
        g.drawImage(img, 0, 0, this);
    }

    public Image drawImage(){

        // Initializing scene

        //BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);


        Metal silver = new Metal();
        Diffuse white = new Diffuse(Color.white);
        Diffuse red = new Diffuse(Color.red);
        Diffuse blue = new Diffuse(Color.blue);
        Diffuse green = new Diffuse(Color.green);
        Glass glass = new Glass(1.5);

        BufferedImage textureImg = null;
        try {
            textureImg = ImageIO.read(new File("textures/wood.jpg"));
        } catch (IOException e) {
            System.out.println("Error : couldn't import file");
        }
        Texture wood = new Texture(textureImg);

        try {
            textureImg = ImageIO.read(new File("textures/brick.jpg"));
        } catch (IOException e) {
            System.out.println("Error : couldn't import file");
        }
        Texture bricks = new Texture(textureImg);


        Camera camDefaut = new Camera(new Vector3d(0, 0, 0), new Vector3d(1, 0, 0), width, height, Math.PI/2);
        LinkedList<Drawable> listeDefaut= new LinkedList<Drawable>();
        listeDefaut.add(new Sphere(new Vector3d(theta+2, 0, 0), 1, glass));
        //listeDefaut.add(new Sphere(new Vector3d(-0.5, 0.2, 0.2), 0.1, silver));
        listeDefaut.add(new Plane(new Vector3d(0, 1, 0), new Vector3d(0, -3, 0 ), bricks));
        listeDefaut.add(new Plane(new Vector3d(0, -1, 0), new Vector3d(0, 3, 0 ), green));
        listeDefaut.add(new Plane(new Vector3d(-1, 0, 0), new Vector3d(5, 0, 0), bricks));
        listeDefaut.add(new Plane(new Vector3d(0, 0, -1), new Vector3d(0, 0, 3), white));
        listeDefaut.add(new Plane(new Vector3d(0, 0, 1), new Vector3d(0, 0, -3), wood));
        listeDefaut.add(new Plane(new Vector3d(1, 0, 0), new Vector3d(-5, 0, 0), white));
        //listeDefaut.add(new Cube(new Vector3d(2, .7, .7),1, 1, 1, Math.PI/4, bricks));
        // theta=0 dans la version par defaut
        Scene sceneDefaut = new Scene(listeDefaut, new Vector3d(1, 2, 2));

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


        return camDefaut.renderImage(sceneDefaut, 10);
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
        frame.setSize(width, height);
        frame.setVisible(true);

        Timer timer = new Timer(10, window);
        timer.start();

    }
}
