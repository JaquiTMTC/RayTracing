Projet RayTracing

L'archive le rapport et le code source du projet.

La classe contenant la méthode main est FenetreCoord.
La taille de la fenêtre fait qu'il faut au moins un écran 1080p pour qu'elle s'affiche entièrement.

Le dossier textures contient les images utilisées en texture dans le rendu.
Le dossier images contient les différentes illustrations.

Utilisation du logiciel :

"A propos" présente le fonctionnement global du programme
Une scène 3D par défaut est proposée sur "Afficher le rendu par défaut"

Vous pouvez créer votre propre scène en y ajoutant des éléments, vous avez le choix entre différents volumes et différentes matières.
Une fois un volume choisi, vous pouvez entrer les coordonnées de du volume.
Subtilité : le sens du vecteur normal des plans affecte leur rendu. Le sens du vecteur doit être vers la caméra pour un bon rendu.
Tous les matérieux sont appliquables à tous les types de volumes, mais le verre s'applique surtout aux surfaces fermées (sphère, cube).
Un plan en verre marche et n'invalide pas le rendu : il sépare l'espaces en 2 zones, de l'air du côté de la normale et du verre de l'autre.

La lumière est une lumière ponctuelle qui émet dans toutes les directions, elle est située en (., ., .).