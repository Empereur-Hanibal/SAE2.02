package graphe.metier;

import java.util.*;

public class Joueur 
{
	private Couleur couleur;

	private ArrayList<Couleur> tabCouleur = new ArrayList<Couleur>();
	
	public Joueur()
	{
		this.couleur = new Couleur(1);

		this.tabCouleur.add(this.couleur);
	}

	public boolean echangerCouleur()
	{
		if (this.couleur != null)
		{
			this.couleur = new Couleur(2);
			this.tabCouleur.add(this.couleur);
			return true;
		}
		return false;
	}

	public Couleur getCouleur()
	{
		return this.couleur;
	}
	
	public String getCouleurString()
	{
		return this.couleur.getCouleur();
	}
	
	public ArrayList<Couleur> getTabcouleur()
	{
		return this.tabCouleur;
	}
}
