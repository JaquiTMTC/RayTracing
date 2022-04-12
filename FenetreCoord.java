import java.util.LinkedList;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FenetreCoord extends JFrame implements ActionListener{
    // Attributs
    int width;
    int height;
    // Declaration composants utilises dans le ActionPerformed
    // menus deroulants
    JComboBox listeVolume = new JComboBox();
    JComboBox listeMatieres = new JComboBox();
    // boutons
    JButton etapeSuiv1 = new JButton("Passer étape suivante");
    JButton effRendu = new JButton("Effacer le rendu");
    JButton sortie = new JButton(" Sortie du programme");
    JButton testAffichage = new JButton("Test");
    JButton Defaut = new JButton();
    // panels
    JPanel panelEtape2 = new JPanel();
    JPanel panelZoneAffichage = new JPanel();
    // listes (avec parametres rentres par l'utilisateur)
    LinkedList<Drawable>drawableUtil;

    // Constructeur
    public FenetreCoord(String nom, int w, int h) {
        super(nom);
        this.width = w;
        this.height = h;
        this.setSize(width, height);
        this.setLocation(100, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // composants menu
        JLabel labelMenu = new JLabel("Menu");
        labelMenu.setBounds(125, 10, 50, 20);

        // composants etape 1

        listeVolume.setBounds(10, 10, 200, 30);
        listeVolume.addItem("--Choix volume--");
        listeVolume.addItem("Sphère");
        listeVolume.addItem("Cube");
        //listeVolume.addItem("Cylindre");
        listeVolume.addActionListener(this);

        listeMatieres.setBounds(10, 45, 200, 30);
        listeMatieres.addItem("--Choix matière--");
        listeMatieres.addItem("Métal");
        listeMatieres.addItem("Matériau diffusif");
        listeMatieres.addActionListener(this);

        etapeSuiv1.setBounds(10, 90, 200, 30);
        etapeSuiv1.setBackground(Color.green);
        etapeSuiv1.addActionListener(this);

        // composants etape 2
        testAffichage.setBounds(0, 70, 100, 30);
        testAffichage.addActionListener(this);
        //testAffichage.setVisible(true);

        // composants etape 3
        effRendu.setBounds(20, 20, 200, 50);
        effRendu.addActionListener(this);

        sortie.setBounds(20, 80, 200, 50);
        sortie.addActionListener(this);

        // composants zone affichage

        // creation d'une camera (param par defaut) pour pouvoir appeler renderImage (qui renvoie l'image) (récup la ligne dans Windows)
        // creation d'une scene, avec les elements indiques par l'util (en parametre de laCamera.renderImage)
        // laCamera.renderImage --> nous renvoie une image

        /*Camera laCamera = new Camera(new Vector3d(0, 0, 0), new Vector3d(1, 0, 0), width, height, Math.PI/2);
        LinkedList<Drawable> tab = new LinkedList<Drawable>();
        Vector3d center = new Vector3d(1,0,0); // sans paramètres : au centre
        double radius = 0.25;
        Material material = new Diffuse(Color.gray);
        tab.add(new Sphere(center, radius, material));
        Vector3d light_pos = new Vector3d();
        Scene laScene = new Scene(tab, light_pos);

        ImageIcon renduIcon = new ImageIcon(laCamera.renderImage(laScene,10));


        JLabel labelIm = new JLabel(renduIcon);
        //labelIm.setLocation(0,0);
        //labelIm.setSize(700,500);*/


        Metal silver = new Metal(Color.black);
        Diffuse white = new Diffuse(Color.white);
        Diffuse red = new Diffuse(Color.red);
        Diffuse blue = new Diffuse(Color.blue);
        Diffuse green = new Diffuse(Color.green);

        // Camera par defaut et geometrie par defaut : recup de ceux de Window
        Camera camDefaut = new Camera(new Vector3d(0, 0, 0), new Vector3d(1, 0, 0), width, height, Math.PI/2);
        LinkedList<Drawable> listeDefaut= new LinkedList<Drawable>();
        listeDefaut.add(new Sphere(new Vector3d(4, 0, 0), 1.5, blue));
        listeDefaut.add(new Sphere(new Vector3d(-0.5, 0.2, 0.2), 0.1, silver));
        listeDefaut.add(new Plane(new Vector3d(0, 1, 0), new Vector3d(0, -3, 0 ), red));
        listeDefaut.add(new Plane(new Vector3d(0, -1, 0), new Vector3d(0, 3, 0 ), green));
        listeDefaut.add(new Plane(new Vector3d(-1, 0, 0), new Vector3d(5, 0, 0), white));
        listeDefaut.add(new Plane(new Vector3d(0, 0, -1), new Vector3d(0, 0, 3), white));
        listeDefaut.add(new Plane(new Vector3d(0, 0, 1), new Vector3d(0, 0, -3), white));
        listeDefaut.add(new Plane(new Vector3d(1, 0, 0), new Vector3d(-5, 0, 0), white));
        listeDefaut.add(new Cube(1,1, 1, new Vector3d(2, .7, .7), green));
        // theta=0 dans la version par defaut
        Scene sceneDefaut = new Scene(listeDefaut, new Vector3d(1, 2*Math.cos(0), 2));
        ImageIcon renduParDefaut = new ImageIcon(camDefaut.renderImage(sceneDefaut,10));

        JLabel lDefaut = new JLabel(renduParDefaut);
        lDefaut.setLocation(0,0);
        lDefaut.setSize(700,500);

        drawableUtil=new LinkedList<Drawable>();






        // PANNEAUX

        // Panel menu
        JPanel panelMenu = new JPanel();
        panelMenu.setLayout(null);
        panelMenu.setBounds(0, 0, 300, 50);
        panelMenu.setBackground(Color.orange);

        panelMenu.add(labelMenu);

        // Panel etape 1
        JPanel panelEtape1 = new JPanel();
        panelEtape1.setLayout(null);
        panelEtape1.setBounds(0, 0, 300, 150);
        panelEtape1.setBackground(Color.yellow);
        panelEtape1.setVisible(true);

        panelEtape1.add(listeVolume);
        panelEtape1.add(listeMatieres);
        panelEtape1.add(etapeSuiv1);

        // Panel etape 2
        JPanel panelEtape2 = new JPanel();
        panelEtape2.setVisible(true);
        panelEtape2.setLayout(null);
        panelEtape2.setBounds(0, 150, 300, 150);
        panelEtape2.setBackground(Color.cyan);

        panelEtape2.add(testAffichage) ;

        // Panel etape 3
        JPanel panelEtape3 = new JPanel();
        panelEtape3.setLayout(null);
        panelEtape3.setBounds(0, 300, 300, 150);
        panelEtape3.setBackground(Color.magenta);
        panelEtape3.setVisible(true);

        panelEtape3.add(effRendu);
        panelEtape3.add(sortie);

        //Panel de toutes les etapes
        JPanel panelEtapes = new JPanel();
        panelEtapes.setLayout(null);
        panelEtapes.setBounds(0, 50, 300, 450);
        panelEtapes.setBackground(Color.yellow);
        panelEtapes.setVisible(true);

        panelEtapes.add(panelEtape1);
        panelEtapes.add(panelEtape2);
        panelEtapes.add(panelEtape3);

        // Panel zone affichage du rendu 3D

        panelZoneAffichage.setLayout(null);
        panelZoneAffichage.setBounds(300, 0, 700, 500);
        panelZoneAffichage.setBackground(Color.gray);
        panelZoneAffichage.setVisible(true);

        //panelZoneAffichage.add(labelIm);
        panelZoneAffichage.add(lDefaut);

        // Panel fenetre
        JPanel panelGlobal = new JPanel();
        panelGlobal.setLayout(null);
        panelGlobal.setBounds(0, 0, this.width, this.height);
        panelGlobal.setBackground(Color.blue);

        panelGlobal.add(panelMenu);
        panelGlobal.add(panelEtapes);
        panelGlobal.add(panelZoneAffichage);

        this.add(panelGlobal);
        this.setVisible(true);
    } // fin du constructeur

    public void actionPerformed(ActionEvent e) {
        if (listeVolume.getSelectedItem() == "Sphère") {
            System.out.println("Sphère sélectionnée");
            // parametres sphere par defaut
            Vector3d center_default = new Vector3d(1,0,0); // sans paramètres : au centre
            double radius_default = 0.25;
            Material material_default = new Diffuse(Color.gray);
            Sphere sphere = new Sphere(center_default,radius_default,material_default);
            drawableUtil.add(sphere);
        }
        if (listeVolume.getSelectedItem() == "Cube") {
            System.out.println("Cube sélectionné");
            // parametres cube par defaut
            double largeur_default=0.25;
            double hauteur_default=0.25;
            double profondeur_default=0.25;
            Vector3d center_default=new Vector3d(1,0,0);
            Material material_default=new Diffuse(Color.gray);
            Cube cube = new Cube(largeur_default, hauteur_default, profondeur_default, center_default, material_default);
            drawableUtil.add(cube);
        }
        if (listeMatieres.getSelectedItem() == "Métal") {
            System.out.println("Métal sélectionné");
        }
        if (listeMatieres.getSelectedItem() == "Matériau diffusif") {
            System.out.println("Matériau diffusif sélectionné");
        }

        if (e.getSource() == etapeSuiv1) {
            System.out.println("Etape suivante");
        }

        if (e.getSource() == testAffichage) {
            System.out.println("Bouton test affichage cliqué");
        }
        if(e.getSource()== Defaut){
            // afficher rendu par defaut

        }

        if (e.getSource() == effRendu) {
            System.out.println(" Effacer");
            panelZoneAffichage.setVisible(false);
        }
        if (e.getSource()== sortie) {
           // exit du programme à faire
        }

        // TESTS SUR LA LISTE
        // A REMPLACER PAR UN FOR EACH (mais pas la syntaxe sous la main actuellement)
        System.out.println("La liste avec les infos entrees par l'utilisateur contient :");
        for (int i=0; i<drawableUtil.size();i++){
            System.out.println(drawableUtil.get(i));
        }

    }
        public static void main (String[]args){
            FenetreCoord f = new FenetreCoord(" IHM", 1000, 535);
        }
}


// TO DO :

// faire la version par défaut --> 1 cam / défaut + 1 scene par defaut + si clic sur bouton version par defaut recup image: C
// créer les listes qui se remplissent avec les demandes de l'utilisateur: A
// esthétique : rendre l'interface sympa: pdt vacances
//      placement
//      couleurs
// faire la fenêtre de bienvenue / intro / explications : C
// faire la fenêtre d'au revoir : A
// nettoyage du code : pdt vacances
// commentaires : au fur et à mesure


// Test de modif de police de caractère
// Font police = new Font(" Calibri ", Font.BOLD, 18);
// labelVide.setFont(police);
//labelVide.setText(" RENDU");