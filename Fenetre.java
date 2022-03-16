import java.util.LinkedList;
import javax.swing.JFrame;
import javax.swing.*;
import java.awt.Color;
import java.awt.event.*;
import java.awt.*;
import java.awt.FlowLayout;


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
        JPanel panelGlobal = new JPanel(new BorderLayout());
        panelGlobal.setBounds(0,0, this.width, this.height); // panneau qui englobe tt la fenetre
        panelGlobal.setBackground(Color.blue);


        /*JPanel panelSelection = new JPanel(); // choix scène
        panelSelection.setSize(200,400);
        panelSelection.setBackground(Color.green);
         */

        JPanel panelBoutons = new JPanel();
        panelBoutons.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        panelBoutons.setBackground(Color.yellow);

        JComboBox listeVolume=new JComboBox();
        listeVolume.addItem("--choix volume--");
        listeVolume.addItem("Sphère");
        listeVolume.addItem("Cube");
        listeVolume.addItem("Cylindre");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx= 1; // place la case contenant listeVolume en x=1 (x=0, y=0: coin à gauche de l'objet)
        c.gridy= 1;
        c.gridwidth = 2;
        panelBoutons.add(listeVolume, c);

        c.anchor= GridBagConstraints.FIRST_LINE_START; // position a interieur de la case de la liste deroulante
        // par défaut: Constraints en CENTER
        JComboBox listeMatieres=new JComboBox();
        listeMatieres.addItem("--choix matieres--");
        listeMatieres.addItem("Bois");
        c.fill = GridBagConstraints.HORIZONTAL; // important de mettre ces lignes après creation ComboBox en question
        c.gridx= 1;
        c.gridy= 2;
        c.weighty= 1.0; // gere espace entre les menus deroulants
        c.gridwidth = 2; // nb de colonnes que prend le composant de long (long= selon x)
        c.ipady = 30; // augmente largeur de la liste déroulante (largeur= selon y)



        panelBoutons.add(listeMatieres, c);

        //panelSelection.add(panelBoutons);

        //panelGlobal.add(panelSelection, BorderLayout.WEST);

        panelGlobal.add(panelBoutons, BorderLayout.WEST);

        add(panelGlobal);
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

    }
    public static void main (String[]args){
        Fenetre f = new Fenetre(" IHM", 1000, 500);
    }
}
// A faire: reduire espace entre les listes deroulantes