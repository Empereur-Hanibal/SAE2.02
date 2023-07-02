package graphe.test;

import graphe.Controleur;
import graphe.metier.*;

/** Test de la classe Region */
public class TestComptage
{
	public static void main(String[] args)
	{
		// Création d'un objet Controleur
		Controleur ctrl = new Controleur();
        
		// Création d'un objet Comptage
		Comptage comptage = new Comptage(ctrl);
		
		// Ajout des régions, des nœuds et des arêtes au contrôleur
		// ...

		// Création de quelques arêtes avec des couleurs
		Noeud noeud1 = new Noeud(1, 10, 10);
		Noeud noeud2 = new Noeud(2, 20, 20);
		Noeud noeud3 = new Noeud(8, 30, 30);

		Arete arete1 = new Arete(noeud1, noeud2);
		arete1.setPossessionCoul("#0000FF");
		noeud1.addPossession(arete1);

		Arete arete2 = new Arete(noeud2, noeud3);
		arete2.setPossessionCoul("#FF0000");

		Arete arete3 = new Arete(noeud3, noeud1);
		arete3.setPossessionCoul("#00FF00");

		// Ajout des arêtes au contrôleur
		ctrl.getTabAretes().add(arete1);
		ctrl.getTabAretes().add(arete2);
		ctrl.getTabAretes().add(arete3);

		// Calcul du nombre de points avec une couleur donnée
		int points = comptage.getTotalPts();
        
		// Affichage du résultat
		System.out.println("Nombre de points : " + points);
	}
}
