import java.util.LinkedList;
import javax.swing.JFrame;
import javax.swing.*;
import java.awt.Color;
import java.awt.event.*;
import java.awt.*;


public class Fenetre extends JFrame implements ActionListener{ // besoin de boutons pour le menu, le chox de la scène
// taille fenêtre et attributs
    int width;
    int height;

    // constructeur
    public Fenetre(String nom, int w, int h) {
        super(nom);
        this.width= w;
        this.height= h;
        this.setSize(width,height);
        this.setLocation(100, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // panel
        JPanel panelGlobal = new JPanel();
        panelGlobal.setLayout(null);
        panelGlobal.setBounds(0,0, this.width, this.height); // panneau qui englobe tt la fenetre
        panelGlobal.setBackground(Color.pink);
        JPanel panelSelection = new JPanel(); // choix scène
        panelGlobal.setBounds(0,0, this.width, this.height); // panneau qui englobe tt la fenetre
        panelGlobal.setBackground(Color.pink);

        panelGlobal.add(panelSelection);
        add(panelGlobal);
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

    }
    public static void main (String[]args){
        Fenetre f = new Fenetre(" IHM", 1000, 500);
    }

}






// IHM



