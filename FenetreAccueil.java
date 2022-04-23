
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
        Description.setBounds(10, 10, 350, 260);
        Color lightBlue = new Color(204, 209, 255);
        Description.setBackground(lightBlue);
        Description.setText("  Bienvenue ! " + "Voici les fonctionnalités de notre" + "\n" +
                "  programme qui repose sur la technique du raytracing, utilisée" + "\n" +
                "  dans le cinéma. " + "Elle permet de visualiser des objets " + "\n" +
                "  en 3D. " + "Pour cela, une caméra  est positionnée  dans " + "\n" +
                "  l'espace. " + "On définit ensuite une scène, qui contient" + "\n" +
                "  les objets à afficher: " + "Des sphères par exemple." + "\n" +
                "  Enfin, des rayons sont envoyés de la camera vers la scène. " + "\n" +
                "  On calcule l'intersection entre les rayons et l'objet." + "\n" +
                "  Les réflexions sont prises en compte, et dépendent du " + "\n" +
                "  matériau de l'objet. Tu peux modifier les paramètres suivants: " + "\n" +
                "  la position, la taille, le nombre, le matériau, la couleur, " + "\n" +
                "  la texture ainsi que le type des objets dans la scène.  " + " \n" +
                "  Voici  les options disponibles.  ");

        Font police = new Font(" Arial ",Font.PLAIN,12);
        Description.setFont(police);
        Description.setVisible(true);

        JLabel metalMat = new JLabel();
        metalMat.setBounds(100, 10, 185, 130);
        ImageIcon imageMetal = new ImageIcon("metal.png");
        metalMat.setIcon(imageMetal);
        metalMat.setVisible(true);


        JLabel diffuseMat = new JLabel();
        diffuseMat.setBounds(350,10,185,130);
        ImageIcon imageDiffuse = new ImageIcon("bois.png");
        diffuseMat.setIcon(imageDiffuse);
        diffuseMat.setVisible(true);

        JLabel textures = new JLabel( "                     Choix des textures:     MUR DE BRIQUE  ou PLANCHER ");
        textures.setBounds(20, 135, 500, 20);
        textures.setForeground(Color.white);
        Font police2 = new Font(" Arial ",Font.BOLD,14);
        textures.setFont(police2);

        JLabel color = new JLabel( "Coloris disponibles : ");
        color.setLocation(5, 5);
        color.setSize(300, 15);

        JLabel blue = new JLabel();
        ImageIcon palette = new ImageIcon("degrade.png");
        blue.setBounds(20, 20, 600, 60);
        blue.setIcon(palette);
        blue.setVisible(true);

        JLabel mat = new JLabel("                          Choix des matériaux:      METALLIQUE  ou DIFFUSIF ");
        mat.setBounds(5, 10, 700, 20);
        mat.setForeground(Color.white);
        mat.setFont(police2);

        JLabel geo = new JLabel(" Choix des objets a placer");
        geo.setBounds(350, 20, 300, 15);
        geo.setFont(police2);

        JLabel sphere = new JLabel(" Sphere. Choix du centre et du rayon. ");
        sphere.setBounds(15, 60, 280, 20);
        sphere.setForeground(Color.black);

        JLabel sphereIcon = new JLabel();
        sphereIcon.setBounds(0, 90, 350, 250);
        ImageIcon sp = new ImageIcon("sp.gif");
        sphereIcon.setIcon(sp);

        JLabel cube = new JLabel(" Cube. Choix du centre, de l'arête.");
        cube.setBounds(410, 60, 200, 20);
        cube.setForeground(Color.black);

        JLabel cubeIcon = new JLabel();
        cubeIcon.setBounds(390, 90, 200, 250);
        ImageIcon cb = new ImageIcon("square2.jpg");
        cubeIcon.setIcon(cb);

        JLabel planarIcon = new JLabel();
        planarIcon.setBounds(600, 90, 400, 250);
        ImageIcon plan = new ImageIcon("planarSurface.png");
        planarIcon.setIcon(plan);

        JLabel plans = new JLabel(" Plan. Choix d'un point, d'un vecteur normal. ");
        plans.setBounds(630, 60, 250, 20);
        plans.setForeground(Color.black);





        // panels
        // PANEL PRESENTATION MATERIAUX
        JPanel panelMat = new JPanel();
        panelMat.setLayout(null);
        panelMat.setBounds(380,10, 580, 260);
        panelMat.setBackground(Color.black);
        panelMat.add(metalMat);
        panelMat.add(diffuseMat);
        panelMat.add(mat);
        panelMat.add(textures);
        panelMat.setVisible(true);

        // PANEL PRES COULEURS
        JPanel panelCol = new JPanel();
        panelCol.setLayout(null);
        panelCol.setBounds(10,280, 950, 80);
        Color blueSky= new Color(153, 100, 255);
        panelCol.setBackground(blueSky);
        panelCol.setVisible(true);
        panelCol.add(color);
        panelCol.add(blue);


        // PANEL PRES OBJETS
        JPanel panelGeo = new JPanel();
        panelGeo.setLayout(null);
        panelGeo.setBounds(10,375, 950, 330);
        panelGeo.setBackground(Color.white);
        panelGeo.setVisible(true);
        panelGeo.add(sphere);
        panelGeo.add(cube);
        panelGeo.add(geo);
        panelGeo.add(plans);
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
        FenetreAccueil bienvenue = new FenetreAccueil("Accueil", 1000, 770);

    }

}
/// version images qui s'affichent












