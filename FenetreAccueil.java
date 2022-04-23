
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
                "  scène, qui contient les objets à afficher: " + "Des sphères" + "\n" +
                "  par exemple. " + "Enfin, des rayons sont envoyés " + "\n" +
                "  de la camera vers la scène. " + "On calcule l'intersection" + "\n" +
                "  entre les rayons et l'objet. " + "Les réflexions sont " + "\n" +
                "  prises en compte, et dépendent du matériau de l'objet." + "\n" +
                "  Voici les paramètres que tu peux modifier: la position, " + "\n" +
                "  la taille, le nombre, le matériau, la couleur et  " + " \n" +
                "  le type des objets. Voici ci-après les options disponibles.  ");

        Font police = new Font(" Arial ",Font.PLAIN,12);
        Description.setFont(police);
        Description.setVisible(true);

        JLabel metalMat = new JLabel();
        metalMat.setBounds(10, 10, 185, 130);
        ImageIcon imageMetal = new ImageIcon("metal.png");
        metalMat.setIcon(imageMetal);
        metalMat.setVisible(true);


        JLabel diffuseMat = new JLabel();
        diffuseMat.setBounds(205,10,185,130);
        ImageIcon imageDiffuse = new ImageIcon("bois.png");
        diffuseMat.setIcon(imageDiffuse);
        diffuseMat.setVisible(true);

        JLabel color = new JLabel("Voici les coloris disponibles : ");
        color.setLocation(5, 5);
        color.setSize(300, 10);

        JLabel blue = new JLabel();
        ImageIcon palette = new ImageIcon("palette.png");
        blue.setBounds(20, 20, 600, 50);
        blue.setIcon(palette);
        blue.setVisible(true);

        JLabel mat = new JLabel("                            Choix des matériaux: METALLIQUE  ou DIFFUSIF ");
        mat.setBounds(5, 5, 700, 20);
        mat.setForeground(Color.white);

        JLabel geo = new JLabel(" Choix des objets a placer");
        geo.setBounds(20, 20, 300, 15);

        JLabel sphere = new JLabel(" Sphere");
        sphere.setBounds(20, 40, 50, 20);
        sphere.setForeground(Color.orange);

        JLabel sphereIcon = new JLabel();
        sphereIcon.setBounds(0, 60, 350, 250);
        ImageIcon sp = new ImageIcon("sp.gif");
        sphereIcon.setIcon(sp);

        JLabel cubeIcon = new JLabel();
        cubeIcon.setBounds(390, 60, 200, 250);
        ImageIcon cb = new ImageIcon("square2.jpg");
        cubeIcon.setIcon(cb);

        JLabel planarIcon = new JLabel();
        planarIcon.setBounds(600, 60, 400, 250);
        ImageIcon plan = new ImageIcon("plan.png");
        planarIcon.setIcon(plan);





        // panels
        // PANEL PRESENTATION MATERIAUX
        JPanel panelMat = new JPanel();
        panelMat.setLayout(null);
        panelMat.setBounds(330,10, 630, 260);
        panelMat.setBackground(Color.black);
        panelMat.add(metalMat);
        panelMat.add(diffuseMat);
        panelMat.add(mat);
        panelMat.setVisible(true);

        // PANEL PRES COULEURS
        JPanel panelCol = new JPanel();
        panelCol.setLayout(null);
        panelCol.setBounds(10,280, 950, 90);
        Color blueSky= new Color(153, 100, 255);
        panelCol.setBackground(blueSky);
        panelCol.setVisible(true);
        panelCol.add(color);
        panelCol.add(blue);


        // PANEL PRES OBJETS
        JPanel panelGeo = new JPanel();
        panelGeo.setLayout(null);
        panelGeo.setBounds(10,375, 950, 300);
        panelGeo.setBackground(Color.white);
        panelGeo.setVisible(true);
        panelGeo.add(sphere);
        panelGeo.add(geo);
        panelGeo.add(sphereIcon);
        panelGeo.add(cubeIcon);
        panelGeo.add(planarIcon);

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
        FenetreAccueil bienvenue = new FenetreAccueil("Accueil", 1000, 750);

    }

}
/// version images qui s'affichent












