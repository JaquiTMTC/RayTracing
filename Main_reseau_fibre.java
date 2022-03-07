
/* Version de l'algorithme de Prim-Jarnik utilisant
une ArrayList pour les aretes et aussi pour les sommets rejoints

Graphe: aretes spécifiees par matrice de distances
*/

import java.util.*;

public class Main_reseau_fibre {    
    public static void main(String[] args){
        
        int nbSommets = 7; //(de 0 à 6)
        
        // matrice des distances entre sommets
        int [][] matDist = {
            { 0, 30, 40, 50, 20, 50, 20},
            {30,  0, 30,  0, 50,  0,  0},
            {40, 30,  0, 20, 50,  0,  0},
            {50,  0, 20,  0, 40,  0,  0},
            {20, 50, 50, 40,  0, 40, 30},
            {50,  0,  0,  0, 40,  0,  0},
            {20,  0,  0,  0, 30,  0,  0}};
        
        
        // representation de l'ensemble S de l'algorithme
        // par la liste suivante:
        ArrayList<Arete> lesAretes = new ArrayList<Arete>();
        
        // construction de l'ensemble des aretes a partir de
        // la matrice de distances
        for(int i=0;i<nbSommets-1;i++){
            for(int j=i+1;j<nbSommets;j++){
                if (matDist[i][j] != 0){
                    Arete uneArete = new Arete(i,j,matDist[i][j]);
                    lesAretes.add(uneArete);
                    
                    System.out.println(uneArete); // Pour voir les aretes dans la console
                    
                }
            }
        }

        // representation de l'ensemble R de l'algorithme
        // par la liste suivante:
        ArrayList<Integer> lesSommetsRejoints = new ArrayList<Integer>();
        // ATTENTION c'est bien Integer et non int
        
        // initialisation
        lesSommetsRejoints.add(0);
        
        //pour test :
        //lesSommetsRejoints.add(4);
        
        // COMPLETER LE CODE ICI
        
      /*  Soit R l’ensemble des sommets déjà rejoints.
		Cet ensemble R est initialisé avec un seul élément: le lotissement déjà "fibré".
		Soit S l’ensemble des arêtes.
		* 
		Tant que R ne contient pas tous les sommets faire:*/
		
		while(lesSommetsRejoints.size()!=nbSommets){
			//on cherche dans S (=toutes les arêtes) l'arête de poids minimal
			
			
			//pour chaque arete du graphe
			//est-ce que cette arete sort de R : un sommet dans R, un sommet pas dans R
			//si oui : cherche le min
			
			//pour l'arete min : ajouter le sommet à R
			
			//Arete AretePoidsMin=lesAretes.get(0);//etre sûr que cette arete est dans le groupe d'arete à comparer
			int min = 10000; //l'initialiser  TRES GRAND
			Arete AretePoidsMin=null;//l'initialiser à null pour éviter les pbms de compilation
			
			for(int i=0; i<lesAretes.size(); i++){
				if((lesSommetsRejoints.contains(lesAretes.get(i).sommetA))==true && (lesSommetsRejoints.contains(lesAretes.get(i).sommetB)==false)||
				((lesSommetsRejoints.contains((lesAretes.get(i).sommetB))==true && lesSommetsRejoints.contains(lesAretes.get(i).sommetA)==false))){
					if(lesAretes.get(i).poids<min){
						AretePoidsMin=lesAretes.get(i);
					}
				}
				
			}
			if(lesSommetsRejoints.contains(AretePoidsMin.sommetA)){
				lesSommetsRejoints.add(AretePoidsMin.sommetB);
			} else {
				lesSommetsRejoints.add(AretePoidsMin.sommetA);
			}
			
			//test
			System.out.println("********************");	
			for(int i=0; i<lesSommetsRejoints.size(); i++){
				System.out.println(lesSommetsRejoints.get(i));
			}
			
	
		}	
			/*1) Choisir dans S une arête de poids minimal parmi les arêtes
			dont une extrémité est dans R et l’autre pas.
			(Intuition : c’est une arête permettant de sortir de l’ensemble R courant
			pour un coût minimal.)
			2) L’arête retenue relie un sommet X dans R et un sommet Y
			qui n’est pas dans R. Ajouter Y à R.
			(Intuition : on enregistre le fait que Y a été rejoint.)
			3) Afficher l’arête choisie (étape optionnelle).
		Fin du tant que
*/
        
    }
}
