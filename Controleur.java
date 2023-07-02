package graphe;

import graphe.ihm.AfficherGraphe;
import graphe.metier.*;

import java.util.ArrayList;

public class Controleur
{
	/*-----------------
	Attributs
	-----------------*/

	private AfficherGraphe ihm;
	private Lecteur        metier;
	private Couleur        couleur1;
	private Joueur         joueur;
	private Comptage       comptagePoints;
	
	public Controleur()
	{
		try
		{
			this.metier    = new Lecteur();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

		this.couleur1 = new Couleur(1);
		this.couleur1.setJoueur(1);

		this.ihm            = new AfficherGraphe(this);
		this.joueur         = new Joueur();
		this.comptagePoints = new Comptage(this);
	}

	public String getCoulJoueur()
	{
		return joueur.getCouleurString();
	}

	public ArrayList<Noeud> getTabNoeud()
	{
		return this.metier.getLstNoeuds();
	}

	public ArrayList<Arete> getTabAretes()
	{
		return this.metier.getLstAretes();
	}

	public ArrayList<Region> getTabRegions()
	{
		return this.metier.getLstRegions();
	}

	public String[] getTabCouleur()
	{
		return couleur1.getTabCouleur();
	}
	
	public int getTotalPts()
	{
		return this.comptagePoints.getTotalPts();
	}
    
	public static void main(String[] args)
	{
		new Controleur();
	}
}
