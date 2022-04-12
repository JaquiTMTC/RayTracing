import java.util.LinkedList;
import javax.swing.JFrame;
import javax.swing.*;
import java.awt.Color;
import java.awt.event.*;
import java.awt.*;
import java.awt.Font;
import java.awt.FlowLayout;

public class Fenetre extends JFrame implements ActionListener{ // besoin de boutons pour le menu, le choix de la scène
// taille fenêtre et attributs
    int width;
    int height;
    // declaration des boutons en attribut qui seront utilises dans le ActionPerformed
    JComboBox listeVolume=new JComboBox();
    JComboBox listeMatieres=new JComboBox();
    JButton etapeSuiv = new JButton("Passer étape suivante");
    JButton effRendu = new JButton ("Effacer le rendu");
    JPanel panelEtape2 = new JPanel();
    JButton testAffichage = new JButton("Test affichage");
    JLabel testRendu = new JLabel(" ");
   // Window window ;

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
        panelGlobal.setLayout(new GridBagLayout());
        GridBagConstraints cons = new GridBagConstraints();
        panelGlobal.setBounds(0,0, this.width, this.height); // panneau qui englobe tt la fenetre
        panelGlobal.setBackground(Color.blue);

        JPanel panelMenu = new JPanel();
        cons.fill=GridBagConstraints.PAGE_START;
        //cons.anchor= GridBagConstraints.PAGE_START;
        cons.gridx=0;
        cons.gridy=0;
        cons.weightx=25;
        panelMenu.setLayout(new GridBagLayout());
        panelMenu.setBackground(Color.orange);
        panelGlobal.add(panelMenu,cons);

        JLabel labelMenu = new JLabel ("-------------Menu---------------");
        GridBagConstraints co = new GridBagConstraints();
        co.fill = GridBagConstraints.CENTER;
        co.ipady = 20;
        panelMenu.add(labelMenu, co);

        JPanel panelBoutons = new JPanel();
        cons.fill=GridBagConstraints.HORIZONTAL;
        cons.gridx=0;
        cons.gridy=1;
        //cons.gridwidth=2;
        cons.weightx=25;
        panelBoutons.setVisible(true);
        panelBoutons.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        panelBoutons.setBackground(Color.yellow);
        panelGlobal.add(panelBoutons,cons);

        listeVolume.addItem("--Choix volume--");
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

        listeMatieres.addItem("--Choix matière--");
        listeMatieres.addItem("Bois");
        c.anchor= GridBagConstraints.FIRST_LINE_START; // position a interieur de la case de la liste deroulante
        c.fill = GridBagConstraints.HORIZONTAL; // important de mettre ces lignes après creation ComboBox en question
        c.gridx= 1;
        c.gridy= 2;
        c.weighty= 1.0; // gere espace entre les menus deroulants
        c.gridwidth = 2; // nb de colonnes que prend le composant de long (long = selon l'horizontale)
        c.ipady = 30; // augmente largeur de la liste déroulante (largeur= selon la verticale)
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

        panelEtape2.setVisible(true);
        cons.fill=GridBagConstraints.SOUTH;
        cons.gridx=0;
        cons.gridy=2;
        cons.weightx=25;
        cons.weighty= 30;
        panelEtape2.setBackground(Color.red);
        panelEtape2.add(new JLabel("Coucou, c'est étape 2"));
        testAffichage.addActionListener(this);
        panelEtape2.add(testAffichage);
        panelGlobal.add(panelEtape2,cons);

        JPanel panelZoneAffichage=new JPanel();
        panelZoneAffichage.setBounds(200, 0, 300, 300);
        //cons.fill=;
        cons.gridx=4;
        cons.gridy=0;
        cons.gridwidth=4; // largeur
        cons.gridheight=4; // hauteur
        cons.weightx=75;
        panelZoneAffichage.setVisible(true);

        JLabel labelVide = new JLabel ("Future zone de rendu                                        ////");
        // Test de modif de police de caractère
        Font police = new Font(" Times New Roman ",Font.BOLD,18);
        labelVide.setFont(police);
        //labelVide.setText(" RENDU");
        panelZoneAffichage.add(labelVide);

        panelZoneAffichage.add(testRendu);

        panelZoneAffichage.setBackground(Color.gray);
        panelGlobal.add(panelZoneAffichage,cons);
        //window = new Window(0);: test pour lier IHM/Rendu en mettant window en para


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
            System.out.println("Sphère sélectionnée");
            //panelEtape2.setVisible(true);
        }
        if(e.getSource()==testAffichage){
            System.out.println("Bouton test affichage cliqué");
            /*JFrame frame = new JFrame();
            Window window = new Window(0);
            frame.getContentPane().add(window);

            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(720, 720);
            frame.setVisible(true);

            Timer timer = new Timer(10, window);
            //timer.start();

             */
            JLabel testRendu= new JLabel(new ImageIcon("./Crepe2.png"));
            //panelZoneAffichage.add(testRendu);
            testRendu.setVisible(true);
        }


    }
    public static void main (String[]args){ Fenetre f = new Fenetre(" IHM", 1000, 500);

    }
}
// A faire: reduire espace entre les listes deroulantes