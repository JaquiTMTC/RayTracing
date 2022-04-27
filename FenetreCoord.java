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
    JButton accueil = new JButton("A propos");
    JButton AffDefaut = new JButton("Afficher le rendu par défaut");
    JButton effRendu = new JButton("Effacer le rendu");
    JButton valModeCoul = new JButton("✓");
    JButton etapeSuiv1 = new JButton("Passer étape suivante 0 action");
    JButton etapeSuiv2 = new JButton("Valider les coordonées 0 action");
    JButton ajout = new JButton("Ajouter le volume à la liste");
    JButton affUtil = new JButton("Afficher mon rendu");
    // radioBoutons
    JRadioButton rBtnCoulBasique = new JRadioButton("Basiques");
    JRadioButton rBtnCoulRGB = new JRadioButton("RGB");
    JRadioButton rBtnNoir = new JRadioButton("Noir");
    JRadioButton rBtnBleu = new JRadioButton("Bleu");
    JRadioButton rBtnVert = new JRadioButton("Vert");
    JRadioButton rBtnJaune = new JRadioButton("Jaune");
    JRadioButton rBtnOrange = new JRadioButton("Orange");
    JRadioButton rBtnRouge = new JRadioButton("Rouge");

    // labels
    JLabel lDefaut = new JLabel();
    JLabel lUtil = new JLabel();
    JLabel labelTestRenduUtil = new JLabel();
    // textFields
    JTextField rayonSphere = new JTextField();
    JTextField xCentreSphere = new JTextField();
    JTextField yCentreSphere = new JTextField();
    JTextField zCentreSphere = new JTextField();

    JTextField areteCube = new JTextField();
    JTextField xCentreCube = new JTextField();
    JTextField yCentreCube = new JTextField();
    JTextField zCentreCube = new JTextField();

    JTextField xVecteurNormalPlan = new JTextField();
    JTextField yVecteurNormalPlan = new JTextField();
    JTextField zVecteurNormalPlan = new JTextField();
    JTextField xCentrePlan = new JTextField();
    JTextField yCentrePlan = new JTextField();
    JTextField zCentrePlan = new JTextField();

    // panels
    JPanel panelCouleur = new JPanel();
    JPanel panelCouleur1 = new JPanel();
    JPanel panelEtape2 = new JPanel();
    JPanel panelEtape2Sphere = new JPanel();
    JPanel panelEtape2SphereParam = new JPanel();
    JPanel panelEtape2Cube = new JPanel();
    JPanel panelEtape2CubeParam= new JPanel();
    JPanel panelEtape2Plan = new JPanel();
    JPanel panelEtape2PlanParam = new JPanel();
    JPanel panelZoneAffichage = new JPanel();
    // listes
    LinkedList<Drawable> listeDefaut;
    LinkedList<Drawable>drawableUtil;
    // cameras
    Camera camDefaut;
    // scenes
    Scene sceneDefaut;
    // vecteurs
    Vector3d centerUtil;
    // spheres
    Sphere spUtil;
    // matieres
    Material materialUtil;
    // couleurs
    Color colorUtil;
    double rUtil;
    double xUtil;
    double yUtil;
    double zUtil;

    // Constructeur
    public FenetreCoord(String nom, int w, int h) {
        super(nom);
        this.width = w;
        this.height = h;
        this.setSize(width, height);
        this.setLocation(100, 5);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // composants menu
        JLabel labelMenu = new JLabel("Menu");
        labelMenu.setBounds(5, 10, 50, 30);

        accueil.setBounds(60, 10, 90, 30);
        accueil.setBackground(Color.green);
        accueil.addActionListener(this);

        AffDefaut.setBounds(200, 5, 200, 20);
        AffDefaut.setBackground(Color.pink);
        AffDefaut.addActionListener(this);

        effRendu.setBounds(200, 27, 200, 20);
        effRendu.setBackground(Color.red);
        effRendu.addActionListener(this);

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
        listeMatieres.addItem("Texture - uniquement pour un plan");
        listeMatieres.addActionListener(this);

        etapeSuiv1.setBounds(10, 100, 200, 30);
        etapeSuiv1.setBackground(Color.green);
        etapeSuiv1.addActionListener(this);

        // composants panelCouleur
        // panelCouleur1
        JLabel lSeleCoul = new JLabel("--Choix couleur--");
        lSeleCoul.setBounds(5,5,175,20);
        rBtnCoulBasique.setBounds(5, 5,80,20);
        rBtnCoulRGB.setBounds(90,5,80,20);
        ButtonGroup bg = new ButtonGroup();
        bg.add(rBtnCoulBasique);
        bg.add(rBtnCoulRGB);
        valModeCoul.setBounds(5,30,45,20);
        valModeCoul.addActionListener(this);


        // composants etape 2
            // composants etape2Sphere
                // composants etape2SphereParam
                JLabel lRayon = new JLabel("Rayon");
                JLabel lCoord = new JLabel("Coordonnées du centre de la sphère");
                JLabel lx = new JLabel("x");
                JLabel ly = new JLabel("y");
                JLabel lz = new JLabel("z");

                lRayon.setBounds(20,10,100, 20);
                rayonSphere.setBounds(20,30,50,20);
                lx.setBounds(150,10,100,20);
                xCentreSphere.setBounds(150,30,50,20);
                ly.setBounds(250,10,100,20);
                yCentreSphere.setBounds(250, 30,50,20);
                lz.setBounds(350,10,100,20);
                zCentreSphere.setBounds(350,30,50,20 );
                lCoord.setBounds(150,60,300,20);

                etapeSuiv2.setBounds(20,70,200,20);
                etapeSuiv2.setBackground(Color.green);
                etapeSuiv2.addActionListener(this);

                // composants etape2CubeParam

                JLabel lArete = new JLabel("Longueur Arete");
                JLabel lCentre = new JLabel("Coordonnées du centre du cube");
                JLabel lx1 = new JLabel("x");
                JLabel ly1 = new JLabel("y");
                JLabel lz1 = new JLabel("z");

                lArete.setBounds(20,10,100, 20);
                areteCube.setBounds(20,30,50,20);
                lx1.setBounds(150,10,100,20);
                xCentreCube.setBounds(150,30,50,20);
                ly1.setBounds(250,10,100,20);
                yCentreCube.setBounds(250, 30,50,20);
                lz1.setBounds(350,10,100,20);
                zCentreCube.setBounds(350,30,50,20 );
                lCentre.setBounds(150,60,300,20);

                // composants etape2PlanParam

                JLabel lVecteurNormal = new JLabel("Coord vecteur normal");
                JLabel lPoint = new JLabel("Coordonnées d'un point du plan");
                JLabel lx2 = new JLabel("x");
                JLabel ly2 = new JLabel("y");
                JLabel lz2 = new JLabel("z");

                lVecteurNormal.setBounds(10,2,200, 15);// a modif
                xVecteurNormalPlan.setBounds(10,20,50,20);
                yVecteurNormalPlan.setBounds(70,20,50,20);
                zVecteurNormalPlan.setBounds(130,20,50,20);
                lx2.setBounds(30,50,30,20);
                ly2.setBounds(90,50,30,20);
                lz2.setBounds(150,50,30,20);
                xCentrePlan.setBounds(10,90,50,20);
                yCentrePlan.setBounds(70, 90,50,20);
                zCentrePlan.setBounds(130,90,50,20 );
                lPoint.setBounds(10,70,300,15);


        // composants etape 3
        ajout.setBounds(10,10,200,30);
        ajout.setBackground(Color.magenta);
        ajout.addActionListener(this);

        affUtil.setBounds(10,50,200,30);
        affUtil.setBackground(Color.green);
        affUtil.addActionListener(this);

        // composants zone affichage
        labelTestRenduUtil.setVisible(false);
        lUtil.setVisible(false);

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

        camDefaut = new Camera(new Vector3d(-4, -2.5, 0), new Vector3d(1,0 ,0 ), width, height, Math.PI/2);

        // reglages parametres camera :
        /*// x=1 du vecteur "normal" du constructeur de camera --> cette camera "regarde" dans la direction des x croissants
        // triedre direct tel que z soit toujours vertical ascendant --> donc les y croissants vont vers la gauche
        // jeu sur le positionnement de la camera (premier vecteur du constructeur) pour un beau rendu
        // si on fait varier y : impression de regarder la scene en étant plus à droite (y diminue) ou plus à gauche (y augmente)
        // si on  fait varier x : impression de se rapprocher (x augmente) ou de s'eloigner (x diminue) de la scene
        // si on fait varier z : impression de regarder la scene de plus haut (z augmente) ou de plus bas (z diminue)
*/
        listeDefaut= new LinkedList<Drawable>();

        // remplissage de la listeDefaut
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

        sceneDefaut = new Scene(listeDefaut, new Vector3d(1, 2*Math.cos(0), 2));
        lDefaut = genereLabel(camDefaut, listeDefaut,sceneDefaut);
        lDefaut.setBounds(0,0,1275,1000);
        lDefaut.setVisible(false); // deviendra visible quand l'utilisateur cliquera sur le bouton "afficher la version par defaut"


        drawableUtil = new LinkedList<Drawable>(); // instanciation

        // PANNEAUX

        // Panel menu
        JPanel panelMenu = new JPanel();
        panelMenu.setLayout(null);
        panelMenu.setBounds(0, 0, 425, 50);
        panelMenu.setBackground(new Color(26,188,156));
        panelMenu.add(labelMenu);
        panelMenu.add(accueil);
        panelMenu.add(AffDefaut);
        panelMenu.add(effRendu);

        // Panel etape 1
        panelCouleur.setVisible(true);
        panelCouleur.setLayout(null);
        panelCouleur.setBounds(230,10,175,375);
        panelCouleur.setBackground(Color.green);

        panelCouleur1.setVisible(true);
        panelCouleur1.setLayout(null);
        panelCouleur1.setBounds(0,25,175,80);
        panelCouleur1.setBackground(Color.cyan);

        panelCouleur1.add(rBtnCoulBasique);
        panelCouleur1.add(rBtnCoulRGB);
        panelCouleur1.add(valModeCoul);

        panelCouleur.add(lSeleCoul);
        panelCouleur.add(panelCouleur1);
        panelCouleur.add(rBtnNoir);
        panelCouleur.add(rBtnBleu);
        panelCouleur.add(rBtnVert);
        panelCouleur.add(rBtnJaune);
        panelCouleur.add(rBtnOrange);
        panelCouleur.add(rBtnRouge);



        JPanel panelEtape1 = new JPanel();
        panelEtape1.setLayout(null);
        panelEtape1.setBounds(0, 0, 425, 150);
        panelEtape1.setBackground(new Color(232,248,245));
        panelEtape1.setVisible(true);

        panelEtape1.add(listeVolume);
        panelEtape1.add(listeMatieres);
        panelEtape1.add(etapeSuiv1);
        panelEtape1.add(panelCouleur);

        // Panels etape 2

        panelEtape2SphereParam.setVisible(true);
        panelEtape2SphereParam.setLayout(null);
        panelEtape2SphereParam.setBounds(0, 0, 425, 100);
        panelEtape2SphereParam.setBackground(Color.cyan);

        panelEtape2SphereParam.add(lRayon);
        panelEtape2SphereParam.add(rayonSphere);
        panelEtape2SphereParam.add(xCentreSphere);
        panelEtape2SphereParam.add(lx);
        panelEtape2SphereParam.add(yCentreSphere);
        panelEtape2SphereParam.add(ly);
        panelEtape2SphereParam.add(zCentreSphere);
        panelEtape2SphereParam.add(lz);
        panelEtape2SphereParam.add(lCoord);
        panelEtape2SphereParam.add(etapeSuiv2);

        panelEtape2Sphere.setVisible(false);
        panelEtape2Sphere.setLayout(null);
        panelEtape2Sphere.setBounds(0, 150, 425, 150);
        panelEtape2Sphere.setBackground(Color.blue);

        panelEtape2Sphere.add(panelEtape2SphereParam);

        // PANEL CUBE

        panelEtape2CubeParam. setLayout(null);
        panelEtape2CubeParam.setBounds(0, 0, 425, 100);
        panelEtape2CubeParam.setBackground(Color.red);

        panelEtape2CubeParam.add(lArete);
        panelEtape2CubeParam.add(areteCube);
        panelEtape2CubeParam.add(xCentreCube);
        panelEtape2CubeParam.add(lx1);
        panelEtape2CubeParam.add(yCentreCube);
        panelEtape2CubeParam.add(ly1);
        panelEtape2CubeParam.add(zCentreCube);
        panelEtape2CubeParam.add(lz1);
        panelEtape2CubeParam.add(lCentre);

        panelEtape2Cube.setVisible(false);
        panelEtape2Cube.setLayout(null);
        panelEtape2Cube.setBounds(0, 150, 425, 150);
        panelEtape2Cube.setBackground(Color.green);

        panelEtape2Cube.add(panelEtape2CubeParam);

        // PANEL PLAN

        panelEtape2PlanParam. setLayout(null);
        panelEtape2PlanParam.setBounds(0, 0, 425, 140);
        panelEtape2PlanParam.setBackground(Color.red);

        panelEtape2PlanParam.add(lVecteurNormal);
        panelEtape2PlanParam.add(xVecteurNormalPlan);
        panelEtape2PlanParam.add(xCentrePlan);
        panelEtape2PlanParam.add(lx2);
        panelEtape2PlanParam.add(yVecteurNormalPlan);
        panelEtape2PlanParam.add(yCentrePlan);
        panelEtape2PlanParam.add(ly2);
        panelEtape2PlanParam.add(zVecteurNormalPlan);
        panelEtape2PlanParam.add(zCentrePlan);
        panelEtape2PlanParam.add(lz2);
        panelEtape2PlanParam.add(lPoint);

        panelEtape2Plan.setVisible(false);
        panelEtape2Plan.setLayout(null);
        panelEtape2Plan.setBounds(0, 150, 425, 150);
        panelEtape2Plan.setBackground(Color.green);

        panelEtape2Plan.add(panelEtape2PlanParam);

        // Panel etape 2 global

        panelEtape2.setVisible(true);
        panelEtape2.setLayout(null);
        panelEtape2.setBounds(0, 150, 425, 150);
        panelEtape2.setBackground(new Color(209,242,235));

        // Panel etape 3
        JPanel panelEtape3 = new JPanel();
        panelEtape3.setVisible(true);
        panelEtape3.setLayout(null);
        panelEtape3.setBounds(0, 300, 425, 150);
        panelEtape3.setBackground(new Color(163,228,215));

        panelEtape3.add(ajout);
        panelEtape3.add(affUtil);

        //Panel de toutes les etapes
        JPanel panelEtapes = new JPanel();
        panelEtapes.setLayout(null);
        panelEtapes.setBounds(0, 50, 425, 450);
        panelEtapes.setBackground(Color.yellow);
        panelEtapes.setVisible(true);

        panelEtapes.add(panelEtape1);
        panelEtapes.add(panelEtape2);
        panelEtapes.add(panelEtape2Sphere);
        panelEtapes.add(panelEtape2Cube);
        panelEtapes.add(panelEtape2Plan);
        panelEtapes.add(panelEtape3);

        // Panel zone affichage du rendu 3D
        panelZoneAffichage.setLayout(null);
        panelZoneAffichage.setBounds(425, 0, 1275, 1000);
        panelZoneAffichage.setBackground(new Color(232,248,245)); // même couleur que le pannel Global
        panelZoneAffichage.setVisible(true);

        //panelZoneAffichage.add(labelIm); ///////// POUR L'EXEMPLE --> A SUPPRIMER APRES
        panelZoneAffichage.add(lDefaut);
        panelZoneAffichage.add(lUtil);
        panelZoneAffichage.add(labelTestRenduUtil);

        // Panel global fenetre
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

    public JLabel genereLabel(Camera cam, LinkedList<Drawable> listeGeom, Scene scene){
        JLabel labelRendu = new JLabel();
        ImageIcon im = new ImageIcon(cam.renderImage(scene,10));
        labelRendu.setIcon(im);
        return labelRendu;
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == accueil ){
            FenetreAccueil fa = new FenetreAccueil("Bienvenue", 1000, 1000);
        }
        if(e.getSource()== AffDefaut){
            System.out.println("Version par defaut");
            panelZoneAffichage.setVisible(true); // sert dans le cas ou on veut afficher le rendu par defaut apres avoir
            // clique sur le bouton effacer le rendu (qui setVisible ce pannel a false)
            lDefaut.setVisible(true);
        }
        if (e.getSource() == effRendu) {
            System.out.println("Effacer");
            panelZoneAffichage.setVisible(false);
            lDefaut.setVisible(false);
            //labelTestRenduUtil.setVisible(false);
            lUtil.setVisible(false);
        }

        if (listeVolume.getSelectedItem() == "--Choix volume--"){
            panelEtape2.setVisible(true);
        }
        if (listeVolume.getSelectedItem() == "Sphère"){
            System.out.println("Sphère sélectionnée");
            panelEtape2.setVisible(false); // on "allume" le panel qu'on veut par rapport au menu deroulant
            panelEtape2Sphere.setVisible(true);
            panelEtape2Cube.setVisible(false);
            panelEtape2Plan.setVisible(false);
            // on va dire qu'ici pour les tests quand on clique sur valider les coordonnées ça a le même effet
            // que si on cliquait sur ajouter le volume à la scene et aussi afficher la scene
        }
        if (e.getSource()==etapeSuiv2) {
/*
                lUtil.setLocation(0,0); // label qui contient l'Icon
                lUtil.setSize(1275,1000);
                lUtil.setIcon(renduUtil);
                lUtil.setVisible(true);

 */
        }
        if (listeVolume.getSelectedItem() == "Cube"){
            System.out.println("Cube sélectionné");
            panelEtape2.setVisible(false);
            panelEtape2Sphere.setVisible(false);
            panelEtape2Plan.setVisible(false);
            panelEtape2Cube.setVisible(true);
        }
        if (listeVolume.getSelectedItem() == "Plan"){
            System.out.println("Plan sélectionné");
            panelEtape2.setVisible(false);
            panelEtape2Sphere.setVisible(false);
            panelEtape2Cube.setVisible(false);
            panelEtape2Plan.setVisible(true);


        }
        //if (listeMatieres.getSelectedItem() == "Métal"){
            //System.out.println("Métal sélectionné");
        //}
        if (listeMatieres.getSelectedItem() == "Matériau diffusif"){
            System.out.println("Matériau diffusif sélectionné");
        }

        if (e.getSource()==ajout){
            System.out.println("Avant la récupération des champs, la liste drawableUtil a une size de :"+drawableUtil.size());
            // recuperation des champs non vides
            if (!(rayonSphere.getText()).isEmpty()&&!(xCentreSphere.getText()).isEmpty()&&
                    !(yCentreSphere.getText()).isEmpty()&&!(zCentreSphere.getText()).isEmpty()){
                System.out.println("Tous les champs de la sphère sont non-vides");
                rUtil = Float.parseFloat(rayonSphere.getText());
                xUtil = Float.parseFloat(xCentreSphere.getText());
                yUtil = Float.parseFloat(yCentreSphere.getText());
                zUtil = Float.parseFloat(zCentreSphere.getText());
                if (listeMatieres.getSelectedItem() == "Métal") {
                    //colorUtil = new Color();
                   // materialUtil = new Metal(colorUtil);
                } else if(listeMatieres.getSelectedItem() == "Matériau diffusif"){
                    //colorUtil = new Color();
                    //materialUtil = new Diffuse(colorUtil);
                }
            // else if (tous les param de cube sont non-vides) {
                // recuperation des param de cube
                // }
            // else if (tous les param de plan sont non-vides {
                // recuperation des param de plan
                // }
            } else {
                javax.swing.JOptionPane.showMessageDialog(null,
                        "Veuillez compléter les champs manquants");
            }
            centerUtil = new Vector3d(xUtil,yUtil,zUtil);
            spUtil = new Sphere(centerUtil,rUtil,materialUtil);
            // AJOUT
            drawableUtil.add(spUtil);
            System.out.println("Après la récupération des champs, la liste drawableUtil a une size de :"+drawableUtil.size());
            // JUSTE POUR DES TESTS, MAIS UN FOR EACH C'EST MIEUX POUR UNE LINKEDLIST ///
            for (int i = 0; i<drawableUtil.size(); i++){
                System.out.println(drawableUtil.get(i).material);
            }
        }
        if (e.getSource()==affUtil&&drawableUtil.size()!=0){
            // pour pouvoir afficher son rendu l'utilisateur doit cliquer sur le bouton "Afficher mon rendu" après avoir
            // ajouté au moins un volume à sa liste
            System.out.println("L'utilisateur souhaite afficher son rendu");
            System.out.println("La liste drawableUtil contient actuellement "+drawableUtil.size()+" élément(s)" );
            /*
            labelTestRenduUtil.setBounds(10,10,300,300);
            labelTestRenduUtil.setForeground(Color.blue);
            labelTestRenduUtil.setText("Coucou");
            ImageIcon im_test = new ImageIcon("bois.png");
            labelTestRenduUtil.setIcon(im_test);
            labelTestRenduUtil.setVisible(true);
             */
            lDefaut.setVisible(false);
            lUtil.setVisible(false);
            Scene sceneUtil = new Scene(drawableUtil,new Vector3d (1, 2*Math.cos(0), 2));
            lUtil = genereLabel(camDefaut,drawableUtil,sceneUtil);
            lUtil.setBounds(0,0,1275,1000);
            panelZoneAffichage.add(lUtil);
            lUtil.setVisible(true);
            //panelZoneAffichage.setVisible(true);
            lUtil.repaint();
        }

        // TESTS SUR LA LISTE
        /*
        // POUR l'instant à chaque clic sur n'importe quel bouton le system.out.println s'affiche dans terminal
        // A REMPLACER PAR UN FOR EACH (mais pas la syntaxe sous la main actuellement)
        System.out.println("La liste avec les infos entrees par l'utilisateur contient :");
        for (int i=0; i<drawableUtil.size();i++){
            System.out.println(drawableUtil.get(i));
        }*/


    }// fin du actionPerformed

        public static void main (String[]args){
            FenetreCoord f = new FenetreCoord(" IHM", 1700, 1000);
        }
}
/*
// TO DO :

//  version par défaut --> voir position optimale camera : A, fait
// créer les listes qui se remplissent avec les demandes de l'utilisateur: A
// Lors de la selection des param de la sphere : ajouter des boutons "réinitialiser les coordonnées", "réinitialiser le rayon" : A
// separer les contenus multimedia du code --> et donc mdifier les chemins d'acces aux images : A
// textures dans les plans (nos images)
// volume à rajouter: plan placé par un point et les coordonnées de sa normale : C (item ComboBox: choix plan ) fait
// commentaires : au fur et à mesure
//detail qui fait quoi, CR en expliquant contenu des dossiers en annexe

// nettoyage du code  : pdt vacances
// gestion erreurs utilisateur (si ecrit caractere bizarre) : C
// bouton validation des choix de sphère pour retour en arrière: A

// esthétique : rendre l'interface sympa: pdt vacances
// placement, mise en forme du texte Fenetre Accuei/ Adieu
// couleurs


/*
    // parametres sphere par defaut
    Vector3d center_default = new Vector3d(1,0,0); // sans paramètres : au centre
    double radius_default = 0.25;
    Material material_default = new Diffuse(Color.gray);
    Sphere sphere = new Sphere(center_default,radius_default,material_default);
    drawableUtil.add(sphere);

    // parametres cube par defaut
    double largeur_default=0.25;
    double hauteur_default=0.25;
    double profondeur_default=0.25;
    Vector3d center_default=new Vector3d(1,0,0);
    Material material_default=new Diffuse(Color.gray);
    Cube cube = new Cube(largeur_default, hauteur_default, profondeur_default, center_default, material_default);
    drawableUtil.add(cube);

    //parametres plan par defaut
    Vector3d normal_default = new Vector3d(0, 1, 0); // choix de la normale par defaut en selectionnant un des plans rendu
    Vector3d center_default = new Vector3d(0, -3, 0);
    Material material_default = new Diffuse(Color.red);
    Plane plan = new Plane(normal_default, center_default, material_default);
    drawableUtil.add(plan);

    if (e.getSource() == etapeSuiv1 && (listeVolume.getSelectedItem()=="--Choix volume--"||listeMatieres.getSelectedItem()=="--Choix matière--")) {
        System.out.println("Il faut sélectionner un volume et une matière pour pouvoir passer à l'étape suivante");
    }
 */