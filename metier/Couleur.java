package graphe.metier;

import java.util.ArrayList;

public class Couleur
{
	private String couleur;
	private String tabCouleur[] = {"#0000FF","#FF0000"};

	private int idJoueur;

	private ArrayList<Arete>  lstArete;
	private ArrayList<Region> lstRegion;
	
	private static int cptTours = 1;
	private int indiceCouleur;


	public Couleur(int indiceCouleur)
	{
		this.idJoueur = 0;

		this.indiceCouleur = indiceCouleur;
		this.couleur = this.tabCouleur[this.indiceCouleur-1];

		this.lstArete  = new ArrayList<Arete> ();
		this.lstRegion = new ArrayList<Region>();
	}

	public boolean setJoueur(int idJoueur)
	{
		this.idJoueur = idJoueur;
		return true;
	}
	
	public void reduireNbToursRestants()
	{
		Couleur.cptTours --;
		
		// Si fin nb tours
		if (Couleur.cptTours == 0)
		{
			if (this.indiceCouleur == 0)
			{
				this.indiceCouleur = 1;
			}
			else
			{
				this.indiceCouleur = 0;
			}
			
			// Change couleur
			this.couleur = this.tabCouleur[this.indiceCouleur];
			Couleur.cptTours = 5 + (int) (Math.random() * (11 - 5));
		}
	}

	public int getIdJoueur() {return this.idJoueur;}
	public String getCouleur()
	{
		this.reduireNbToursRestants();
		return this.couleur;
	}
	public ArrayList<Arete> getLstArete() {return this.lstArete;}
	public ArrayList<Region> getLstRegion() { return this.lstRegion;}
	public String[] getTabCouleur() {return this.tabCouleur; }
}
