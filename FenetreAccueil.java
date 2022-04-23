import java.util.LinkedList;
import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Font;


public class FenetreAccueil extends JFrame implements ActionListener {
    // Attributs
    int width;
    int height;

    // Constructeur
    public FenetreAccueil(String nom, int w, int h) {
        super(nom);
        this.width = w;
        this.height = h;
        this.setSize(width, height);
        this.setLocation(100, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //creation des composants

        JTextArea Description = new JTextArea();
        Description.setBounds(10, 10, 300, 260);
        Color lightBlue = new Color(204, 209, 255);
        Description.setBackground(lightBlue);
        Description.setText("  Bienvenue ! " + "Voici les fonctionnalités " + "\n" +
                "  de notre programme qui repose sur la technique du " + "\n" +
                "  raytracing, utilisée dans le cinéma. " + "Elle permet de " + "\n" +
                "  visualiser des objets en 3D. " + "Pour cela, une caméra " + "\n" +
                "  est positionnée dans l'espace. " + "On définit ensuite une " + "\n" +
                "  scène, qui contient les objets à afficher: " + "Des sphères," + "\n" +
                "  des cubes par exemple. " + "Enfin, des rayons sont envoyés " + "\n" +
                "  de la camera vers la scène. " + "On calcule l'intersection" + "\n" +
                "  entre les rayons et l'objet. " + "Les réflexions sont " + "\n" +
                "  prises en compte, et dépendent du matériau de l'objet" + "\n" +
                "  Voici les paramètres que tu peux modifier: la position, " + "\n" +
                "  la taille, le nombre, le matériau, la couleur et  " + " \n" +
                "  le type des objets. Voici les types d'objets que  " + "\n" +
                "  tu peux placer: cubes, plans, sphères. Voici  " + "\n" +
                "  ci-dessous un guide d'utilisation.  ");

        Font police = new Font(" Arial ",Font.ROMAN_BASELINE,11);
        Description.setFont(police);
        Description.setVisible(true);

        JLabel metalMat = new JLabel();
        metalMat.setBounds(10, 10, 185, 130);
        ImageIcon imageMetal = new ImageIcon("metal.png");
        metalMat.setIcon(imageMetal);
        metalMat.setVisible(true);


        JLabel diffuseMat = new JLabel();
        diffuseMat.setBounds(205,10,185,130);
        ImageIcon imageDiffuse = new ImageIcon("diffuse.png");
        diffuseMat.setIcon(imageDiffuse);
        diffuseMat.setVisible(true);

        JLabel color = new JLabel("Voici les coloris disponibles : ");
        color.setLocation(5, 5);
        color.setSize(300, 10);

        JLabel blue = new JLabel();
        blue.setBounds(20, 20, 600, 50);
        ImageIcon cubeBleu = new ImageIcon("palette.png");
        blue.setIcon(cubeBleu);
        blue.setVisible(true);

        JLabel sphere = new JLabel(" Sphere");
        sphere.setBounds(20, 20, 50, 50);
        sphere.setForeground(Color.orange);


        // panels
        // PANEL PRESENTATION MATERIAUX
        JPanel panelMat = new JPanel();
        panelMat.setLayout(null);
        panelMat.setBounds(330,10, 400, 260);
        Color kingBlue = new Color(0, 128, 255);
        panelMat.setBackground(kingBlue);
        panelMat.add(metalMat);
        panelMat.add(diffuseMat);
        panelMat.setVisible(true);

        // PANEL PRES COULEURS
        JPanel panelCol = new JPanel();
        panelCol.setLayout(null);
        panelCol.setBounds(10,280, 720, 90);
        Color blueSky= new Color(153, 100, 255);
        panelCol.setBackground(blueSky);
        //panelCol.add(metalMat);
       // panelCol.add(diffuseMat);
        panelCol.add(color);
        panelCol.add(blue);
        panelCol.setVisible(true);


        // PANEL PRES OBJETS
        JPanel panelGeo = new JPanel();
        panelGeo.setLayout(null);
        panelGeo.setBounds(10,370, 720, 300);
        panelGeo.add(sphere);
        panelGeo.setBackground(Color.white);
        panelGeo.setVisible(true);


        // PANEL GLOBAL
        JPanel panelGlobal = new JPanel();
        panelGlobal.setLayout(null);
        panelGlobal.setBounds(50,0, width, height);
        Color lavande = new Color(153, 153, 255);
        panelGlobal.setBackground(lavande);
        panelGlobal.setVisible(true);

        panelGlobal.add(Description);
        panelGlobal.add(panelMat);
        panelGlobal.add(panelCol);
        panelGlobal.add(panelGeo);

        this.add(panelGlobal);

        this.setVisible(true);

    }


    public void actionPerformed(ActionEvent e) {

    }
    public static void main(String[]args){
        FenetreAccueil bienvenue = new FenetreAccueil("Bienvenue !", 800, 800 );

    }

}
/// version images qui s'affichent












