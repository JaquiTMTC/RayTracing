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
    // cases à cocher
    JCheckBox valSelec1 = new JCheckBox("Valider la sélection");
    // boutons
    JButton accueil = new JButton("A propos");
    JButton etapeSuiv1 = new JButton("Passer étape suivante");
    JButton effRendu = new JButton("Effacer le rendu");
    JButton sortie = new JButton(" Sortie du programme");
    JButton testAffichage = new JButton("Test");
    JButton Defaut = new JButton(" Afficher le rendu par défaut");
    JLabel lDefaut = new JLabel();
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
        labelMenu.setBounds(20, 10, 50, 20);

        accueil.setBounds(90, 10, 100, 30);
        accueil.setBackground(Color.green);
        accueil.addActionListener(this);


        // composants etape 1

        listeVolume.setBounds(10, 5, 200, 30);
        listeVolume.addItem("--Choix volume--");
        listeVolume.addItem("Sphère");
        listeVolume.addItem("Cube");
        listeVolume.addItem("Plan");
        listeVolume.addActionListener(this);

        listeMatieres.setBounds(10, 40, 200, 30);
        listeMatieres.addItem("--Choix matière--");
        listeMatieres.addItem("Métal");
        listeMatieres.addItem("Matériau diffusif");
        listeMatieres.addActionListener(this);

        valSelec1.setBounds(10,70,200,30);
        valSelec1.addActionListener(this);

        //etapeSuiv1.setBounds(10, 80, 200, 30);
        etapeSuiv1.setBounds(10, 100, 200, 30);
        etapeSuiv1.setBackground(Color.green);
        etapeSuiv1.addActionListener(this);

        Defaut.setBounds(10, 115, 200, 30);
        Defaut.setBackground(Color.pink);
        Defaut.addActionListener(this);

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

        // VERSION BOUTON DEFAUT

        /* on le garde pour l'exemple
        //////////////////////////////////// A SUPPRIMER AVANT RENDU //////////////////////////////////////////////
        Camera laCamera = new Camera(new Vector3d(0, 0, 0), new Vector3d(1, 0, 0), width, height, Math.PI/2);
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

        // Camera par defaut et geometrie par defaut

        Camera camDefaut = new Camera(new Vector3d(-4, -2.5, 0), new Vector3d(1,0 ,0 ), width, height, Math.PI/2);
        // reglages parametres camera :
        // x=1 du vecteur "normal" du constructeur de camera --> cette camera "regarde" dans la direction des x croissants
        // triedre direct tel que z soit toujours vertical ascendant --> donc les y croissants vont vers la gauche
        // jeu sur le positionnement de la camera (premier vecteur du constructeur) pour un beau rendu
        // si on fait varier y : impression de regarder la scene en étant plus à droite (y diminue) ou plus à gauche (y augmente)
        // si on  fait varier x : impression de se rapprocher (x augmente) ou de s'eloigner (x diminue) de la scene
        // si on fait varier z : impression de regarder la scene de plus haut (z augmente) ou de plus bas (z diminue)

        LinkedList<Drawable> listeDefaut= new LinkedList<Drawable>();

        Metal silver = new Metal(Color.black);
        Diffuse white = new Diffuse(Color.white);
        Diffuse red = new Diffuse(Color.red);
        Diffuse blue = new Diffuse(Color.blue);
        Diffuse green = new Diffuse(Color.green);

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

        lDefaut.setLocation(0,0); // label Defaut qui contient l'Icon
        lDefaut.setSize(700,500);
        lDefaut.setIcon(renduParDefaut);
        lDefaut.setVisible(false); // deviendra visible quand l'utilisateur cliquera sur le bouton "afficher la version par defaut"

        drawableUtil=new LinkedList<Drawable>();

        // PANNEAUX

        // Panel menu
        JPanel panelMenu = new JPanel();
        panelMenu.setLayout(null);
        panelMenu.setBounds(0, 0, 300, 50);
        panelMenu.setBackground(new Color(26,188,156));
        panelMenu.add(labelMenu);
        panelMenu.add(accueil);

        // Panel etape 1
        JPanel panelEtape1 = new JPanel();
        panelEtape1.setLayout(null);
        panelEtape1.setBounds(0, 0, 300, 150);
        panelEtape1.setBackground(new Color(232,248,245));
        panelEtape1.setVisible(true);

        panelEtape1.add(listeVolume);
        panelEtape1.add(listeMatieres);
        panelEtape1.add(valSelec1);
        panelEtape1.add(etapeSuiv1);
        panelEtape1.add(Defaut);

        // Panel etape 2
        JPanel panelEtape2 = new JPanel();
        panelEtape2.setVisible(true);
        panelEtape2.setLayout(null);
        panelEtape2.setBounds(0, 150, 300, 150);
        panelEtape2.setBackground(new Color(209,242,235));

        panelEtape2.add(testAffichage) ;

        // Panel etape 3
        JPanel panelEtape3 = new JPanel();
        panelEtape3.setLayout(null);
        panelEtape3.setBounds(0, 300, 300, 150);
        panelEtape3.setBackground(new Color(163,228,215));
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
        panelZoneAffichage.setBackground(new Color(232,248,245)); // même couleur que le pannel Global
        panelZoneAffichage.setVisible(true);

        //panelZoneAffichage.add(labelIm); ///////// POUR L'EXEMPLE --> A SUPPRIMER APRES
        panelZoneAffichage.add(lDefaut);

        // Panel fenetre
        JPanel panelGlobal = new JPanel();
        panelGlobal.setLayout(null);
        panelGlobal.setBounds(0, 0, this.width, this.height);
        panelGlobal.setBackground(new Color(232,248,245)); // même couleur que le pannel Zone Affichage

        panelGlobal.add(panelMenu);
        panelGlobal.add(panelEtapes);
        panelGlobal.add(panelZoneAffichage);

        this.add(panelGlobal);
        this.setVisible(true);
    } // fin du constructeur

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == accueil ){
            FenetreAccueil fa = new FenetreAccueil("Bienvenue", 1000, 1000);
        }
        if (listeVolume.getSelectedItem() == "Sphère" && valSelec1.isSelected()){
            System.out.println("Sphère sélectionnée pour l'étape suivante");
            // parametres sphere par defaut
            Vector3d center_default = new Vector3d(1,0,0); // sans paramètres : au centre
            double radius_default = 0.25;
            Material material_default = new Diffuse(Color.gray);
            Sphere sphere = new Sphere(center_default,radius_default,material_default);
            drawableUtil.add(sphere);
        }
        if (listeVolume.getSelectedItem() == "Cube" && valSelec1.isSelected()){
            System.out.println("Cube sélectionné pour l'étape suivante");
            // parametres cube par defaut
            double largeur_default=0.25;
            double hauteur_default=0.25;
            double profondeur_default=0.25;
            Vector3d center_default=new Vector3d(1,0,0);
            Material material_default=new Diffuse(Color.gray);
            Cube cube = new Cube(largeur_default, hauteur_default, profondeur_default, center_default, material_default);
            drawableUtil.add(cube);
        }
        if (listeVolume.getSelectedItem() == "Plan" && valSelec1.isSelected()){
            System.out.println("Plan sélectionné pour l'étape suivante");
            Vector3d normal_default = new Vector3d(0, 1, 0); // choix de la normale par defaut en selectionnant un des plans rendu
            Vector3d center_default = new Vector3d(0, -3, 0);
            Material material_default = new Diffuse(Color.red);
            Plane plan = new Plane(normal_default, center_default, material_default);
            drawableUtil.add(plan);
        }
        if (listeMatieres.getSelectedItem() == "Métal" && valSelec1.isSelected()){
            System.out.println("Métal sélectionné pour l'étape suivante");
        }
        if (listeMatieres.getSelectedItem() == "Matériau diffusif" && valSelec1.isSelected()){
            System.out.println("Matériau diffusif sélectionné pour l'étape suivante");
        }

        // conditions pour pouvoir passer a l'etape suivante :
        // avoir choisi un volume ET une matiere
        // avoir valide la selection (ajout dans la liste drawableUtil a ce moment la)

        if (e.getSource() == etapeSuiv1 && (listeVolume.getSelectedItem()=="--Choix volume--"||listeMatieres.getSelectedItem()=="--Choix matière--")) {
            System.out.println("Il faut sélectionner un volume et une matière pour pouvoir passer à l'étape suivante");
        }

        if (e.getSource() == testAffichage) {
            System.out.println("Bouton test affichage cliqué");
        }
        if(e.getSource()== Defaut){
            System.out.println(" Version par defaut");
            lDefaut.setVisible(true);

        }

        if (e.getSource() == effRendu) {
            System.out.println(" Effacer");
            panelZoneAffichage.setVisible(false);
        }
        if (e.getSource()== sortie) {
           // exit du programme à faire
        }

        // TESTS SUR LA LISTE
        // POUR l'instant à chaque clic sur n'importe quel bouton le system.out.println s'affiche dans terminal
        // A REMPLACER PAR UN FOR EACH (mais pas la syntaxe sous la main actuellement)
        /*System.out.println("La liste avec les infos entrees par l'utilisateur contient :");
        for (int i=0; i<drawableUtil.size();i++){
            System.out.println(drawableUtil.get(i));
        }

         */

    }
        public static void main (String[]args){
            FenetreCoord f = new FenetreCoord(" IHM", 1000, 555);
        }
}


// TO DO :

//  version par défaut --> voir position optimale camera : A
// créer les listes qui se remplissent avec les demandes de l'utilisateur: A
// volume à rajouter: plan placé par un point et les coordonnées de sa normale : C (item ComboBox: choix plan ) fait
// commentaires : au fur et à mesure
//detail qui fait quoi, CR en expliquant contenu des dossiers en annexe

// nettoyage du code  : pdt vacances
// gestion erreurs utilisateur (si ecrit caractere bizarre) : C
// bouton validation des choix de sphère pour retour en arrière: A

// esthétique : rendre l'interface sympa: pdt vacances
// placement, mise en forme du texte Fenetre Accuei/ Adieu
// couleurs
// Test de modif de police de caractère
// Font police = new Font(" Calibri ", Font.BOLD, 18);
// labelVide.setFont(police);
//labelVide.setText(" RENDU");