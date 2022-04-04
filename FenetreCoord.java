import java.util.LinkedList;
import javax.swing.JFrame;
import javax.swing.*;
import java.awt.Color;
import java.awt.event.*;
import java.awt.*;
import java.awt.Font;


//public class FenetreCoord extends JFrame implements ActionListener{ // besoin de boutons pour le menu, le choix de la scène
public class FenetreCoord extends JFrame{
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
    public FenetreCoord(String nom, int w, int h) {
        super(nom);
        this.width= w;
        this.height= h;
        this.setSize(width,height);
        this.setLocation(100, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // panel
        JPanel panelGlobal = new JPanel();
        panelGlobal.setBounds(0,0, this.width, this.height); // panneau qui englobe tt la fenetre
        panelGlobal.setBackground(Color.blue);

        JPanel panelMenu = new JPanel();

        panelMenu.setBackground(Color.orange);
        panelMenu.setLayout(null);
        panelMenu.setBounds(0, 0, 300, 50);
        panelGlobal.add(panelMenu);

        JLabel labelMenu = new JLabel ("-------------Menu---------------");
        labelMenu.setBounds(125, 25, 20, 20 );
        panelMenu.add(labelMenu);
/*
        JPanel panelBoutons = new JPanel();
        panelBoutons.setVisible(true);
        panelBoutons.setBackground(Color.yellow);
        panelGlobal.add(panelBoutons);

        listeVolume.addItem("--Choix volume--");
        listeVolume.addItem("Sphère");
        listeVolume.addItem("Cube");
        listeVolume.addItem("Cylindre");
        listeVolume.addActionListener(this);
        panelBoutons.add(listeVolume);



        listeMatieres.addItem("--Choix matière--");
        listeMatieres.addItem("Bois");
        panelBoutons.add(listeMatieres);

        etapeSuiv.setBackground(Color.green);
        etapeSuiv.addActionListener(this);
        panelBoutons.add(etapeSuiv);

        effRendu.setBackground(Color.red);
        effRendu.addActionListener(this);
        panelBoutons.add(effRendu);

        panelEtape2.setVisible(true);
        panelEtape2.setBackground(Color.red);
        panelEtape2.add(new JLabel("Coucou, c'est étape 2"));
        testAffichage.addActionListener(this);
        panelEtape2.add(testAffichage);
        panelGlobal.add(panelEtape2);

        JPanel panelZoneAffichage=new JPanel();
        panelZoneAffichage.setBounds(200, 0, 300, 300);
        //cons.fill=;
        panelZoneAffichage.setVisible(true);

        JLabel labelVide = new JLabel ("Future zone de rendu                                        ////");
        // Test de modif de police de caractère
        Font police = new Font(" Times New Roman ",Font.BOLD,18);
        labelVide.setFont(police);
        //labelVide.setText(" RENDU");
        panelZoneAffichage.add(labelVide);

        panelZoneAffichage.add(testRendu);

        panelZoneAffichage.setBackground(Color.gray);
        panelGlobal.add(panelZoneAffichage);
        //window = new Window(0);: test pour lier IHM/Rendu en mettant window en para
*/

        add(panelGlobal);
        this.setVisible(true);
    }

   /* public void actionPerformed(ActionEvent e) {
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


            JLabel testRendu= new JLabel(new ImageIcon("./Crepe2.png"));
            //panelZoneAffichage.add(testRendu);
            testRendu.setVisible(true);
        }
        */


    //}
    public static void main (String[]args){ Fenetre f = new Fenetre(" IHM", 1000, 500);

    }
}



