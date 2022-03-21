import java.util.LinkedList;
import javax.swing.JFrame;
import javax.swing.*;
import java.awt.Color;
import java.awt.event.*;
import java.awt.*;
import java.awt.FlowLayout;


public class Fenetre extends JFrame implements ActionListener{ // besoin de boutons pour le menu, le choix de la scène
// taille fenêtre et attributs
    int width;
    int height;
    // declaration des boutons en attribut qui seront utilises dans le ActionPerformed
    JButton etapeSuiv = new JButton(" Passer étape suivante");

    JButton effRendu = new JButton ("Effacer le rendu");
    JComboBox listeVolume=new JComboBox();
    JComboBox listeMatieres=new JComboBox();

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

        JPanel panelMenu = new JPanel(new BorderLayout());
        panelMenu.setLayout(new GridBagLayout());
        panelMenu.setBackground(Color.orange);

        JLabel labelMenu = new JLabel ("menu");
        GridBagConstraints co = new GridBagConstraints();
        co.fill = GridBagConstraints.CENTER;
        co.ipady = 20;
        panelMenu.add(labelMenu, co);

        JPanel panelBoutons = new JPanel();
        panelBoutons.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        panelBoutons.setBackground(Color.yellow);


        listeVolume.addItem("--choix volume--");
        listeVolume.addItem("Sphère");
        listeVolume.addItem("Cube");
        listeVolume.addItem("Cylindre");
        listeVolume.addActionListener(this);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx= 1; // place la case contenant listeVolume en x=1 (x=0, y=0: coin à gauche de l'objet)
        c.gridy= 1;
        c.gridwidth = 2;
        c.ipady=30;
        c.insets=new Insets(10,10,10,10);
        panelBoutons.add(listeVolume, c);

        // par défaut: Constraints en CENTER

        listeMatieres.addItem("--choix matieres--");
        listeMatieres.addItem("Bois");
        c.anchor= GridBagConstraints.FIRST_LINE_START; // position a interieur de la case de la liste deroulante
        c.fill = GridBagConstraints.HORIZONTAL; // important de mettre ces lignes après creation ComboBox en question
        c.gridx= 1;
        c.gridy= 2;
        c.weighty= 1.0; // gere espace entre les menus deroulants
        c.gridwidth = 2; // nb de colonnes que prend le composant de long (long= selon x)
        c.ipady = 30; // augmente largeur de la liste déroulante (largeur= selon y)
        c.insets=new Insets(10,10,10,10);
        panelBoutons.add(listeMatieres, c);


        etapeSuiv.setBackground(Color.green);
        etapeSuiv.addActionListener(this);
        c.fill=GridBagConstraints.HORIZONTAL;
        c.gridx= 1;
        c.gridy= 3;
        c.insets=new Insets(10,10,10,10);
        panelBoutons.add(etapeSuiv, c);


        effRendu.setBackground(Color.red);
        effRendu.addActionListener(this);
        c.fill=GridBagConstraints.HORIZONTAL;
        c.gridx= 1;
        c.gridy= 4;
        c.insets=new Insets(10,10,10,10);
        panelBoutons.add(effRendu, c);


        panelGlobal.add(panelMenu, BorderLayout.NORTH);
        panelGlobal.add(panelBoutons, BorderLayout.WEST);



        add(panelGlobal);
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        System.out.println("Clic");
        if(e.getSource()==etapeSuiv){
            System.out.println("Etape suivante");
        }
        if(e.getSource()== effRendu){
            System.out.println(" Effacer");
        }
        if(listeVolume.getSelectedItem()== "Sphère" ){
            System.out.println(" Sphere selectionnée");
        }

    }
    public static void main (String[]args){
        Fenetre f = new Fenetre(" IHM", 1000, 500);
    }
}
// A faire: reduire espace entre les listes deroulantes