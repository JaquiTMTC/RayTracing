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
        Description.setBackground(Color.magenta);
        //String ls = System.lineSeparator(); // phrases à recouper.
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
        //metalMat.setSize(185, 130);
        // metalMat.setLocation(10, 10);
        //metalMat.setBackground(Color.green);
        Icon imageMetal = new ImageIcon("./Images/metal.png");
        metalMat.setIcon(new ImageIcon("./Images/metal.png"));
        metalMat.setVisible(true);


        JLabel diffuseMat = new JLabel(" y ");
        //diffuseMat.setSize(185, 130);
        diffuseMat.setLocation(205, 10);
        diffuseMat.setBackground(Color.black);
       // Icon imageDiffuse = new ImageIcon("./Images/diffuse.png");
        //diffuseMat.setIcon(imageDiffuse);


        JLabel color = new JLabel(" Voici les coloris disponibles: ");
        color.setLocation(5, 5);
        color.setSize(30, 10);


        // panels
        // PANEL PRESENTATION MATERIAUX
        JPanel panelMat=  new JPanel();
        panelMat.setLayout(null);
        panelMat.setBounds(330,10, 400, 260);
        panelMat.setBackground(Color.yellow);
        panelMat.add(metalMat);
        panelMat.add(diffuseMat);
        panelMat.setVisible(true);

        // PANEL PRES COULEURS
        JPanel panelCol=  new JPanel();
        //panelCol.setLayout(null);
        panelCol.setBounds(10,280, 720, 70);
        panelCol.setBackground(Color.red);
        //panelCol.add(metalMat);
       // panelCol.add(diffuseMat);
        panelCol.add(color);
        panelCol.setVisible(true);


        // PANEL PRES OBJETS
        JPanel panelGeo=  new JPanel();
        //panelGeo.setLayout(null);
        panelGeo.setBounds(10,370, 720, 300);
        panelGeo.setBackground(Color.white);
        panelGeo.setVisible(true);


        // PANEL GLOBAL
        JPanel panelGlobal = new JPanel();
        panelGlobal.setLayout(null);
        panelGlobal.setBounds(50,0, width, height);
        panelGlobal.setBackground(Color.blue);
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
        FenetreAccueil bienvenue = new FenetreAccueil("Bienvenue!", 800, 800 );

    }

}













