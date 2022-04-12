import java.util.LinkedList;
import javax.swing.JFrame;
import javax.swing.*;
import java.awt.Color;
import java.awt.event.*;
import java.awt.*;

public class FenetreAccueil extends JFrame implements ActionListener {
    // Attributs
    int width;
    int height;

    public FenetreAccueil(String nom, int w, int h){
        super(nom);
        this.width = w;
        this.height = h;
        this.setSize(width, height);
        this.setLocation(100, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //creation des composants

        JLabel Description = new JLabel();
        Description.setBounds(10, 10, 300, 300);
        Description.setBackground(Color.magenta);
        //String ls = System.lineSeparator();
        Description.setText(" Bienvenue !" +"\n" + "Voici un aperçu des fonctionnalités de notre programme. "  +"\n"+
                "Il repose sur la technique du raytracing, utilisée dans le cinéma. " +"\n"+
                        "Elle permet de visualiser des objets en 3D. " +"\n"+
                        "Pour cela, une caméra est positionnée dans l'espace. " +"\n"+
                        "On définit ensuite une scène, qui contient les objets à afficher: des sphères, des cubes par exemple. " +"\n"+
                        "Enfin, des rayons sont envoyés depuis vers. " +"\n"+
                        "On calcule ensuite l'intersection entre les rayons et l'objet. "+"\n"+
                "Les phénomènes de réflexion sont pris en compte, et dépendent du matériau de l'objet"+"\n"+
                "Voici les paramètres que tu peux modifier: " +"\n"+
                "- la position, la taille, le nombre et le type des objets " );


        Description.setVisible(true);


        // panels
        JPanel Accueil=  new JPanel();
        Accueil.setLayout(null);
        Accueil.setBounds(0,0, 500, 500);
        Accueil.setBackground(Color.yellow);
        Accueil.setVisible(true);



        JPanel panelGlobal = new JPanel();
        panelGlobal.setLayout(null);
        panelGlobal.setBounds(50,0, width, height);
        panelGlobal.setBackground(Color.blue);
        panelGlobal.setVisible(true);
        Accueil.add(Description);

        this.add(panelGlobal);

        this.setVisible(true);

    }


    public void actionPerformed(ActionEvent e) {
    }
    public static void main(String[]args){
        FenetreAccueil bienvenue = new FenetreAccueil("Bienvenue!", 800, 800 );

    }

}













