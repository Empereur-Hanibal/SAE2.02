package graphe.metier;

import java.util.Scanner;
import java.io.FileInputStream;
import java.util.ArrayList;
import iut.algo.*;
import java.io.File;
import java.util.List;
import java.io.IOException;


public class Lecteur
{
	/*--------------
	Attributs
	--------------*/

	private Scanner sc;

	private ArrayList<Noeud> lstNoeuds;
	private ArrayList<Arete> lstAretes;
	private ArrayList<Region> lstRegions;

    

	private String           type;

	private Noeud            n;
	private Arete            a;
	private Region           r;
	private int              numR;

	/*-------------------
	Méthodes
	-------------------*/

	// Constructeur
	public Lecteur() throws IOException
	{
		this.lstNoeuds  = new ArrayList<Noeud>();
		this.lstRegions = new ArrayList<Region>();
		this.lstAretes  = new ArrayList<Arete>();

		String ligne;
		int    regionsTmp;

		String tabNoeuds [];
		String tabRegions[];
		String tabArete  [];

		Scanner sc = new Scanner(new File("./plan.txt"));

		while(sc.hasNextLine())
		{
			ligne = sc.nextLine();

			if(ligne.equals("")) ligne = sc.nextLine();

			if(ligne.equals("[NOEUDS]") || ligne.equals("[REGIONS]") || ligne.equals("[ARETES]") || ligne.equals("[BONUS]"))  
			{ 
				this.type = ligne; 
				ligne = sc.nextLine(); 
			}

			switch(this.type)
			{
				//création des noeuds
				case "[NOEUDS]" ->
				{
					tabNoeuds = ligne.split("\t");
					this.lstNoeuds.add(new Noeud(Integer.parseInt(tabNoeuds[0]), Integer.parseInt(tabNoeuds[1]), Integer.parseInt(tabNoeuds[2])));
				}

				//creation des régions
				case "[REGIONS]" ->
				{
					tabRegions = ligne.split     ("\t"); 
					this.lstRegions.add(new Region(Integer.parseInt(tabRegions[0])));

					for(int i = 1; i < tabRegions.length; i++)
					this.lstRegions.get(Integer.parseInt(tabRegions[0])-1).addNoeud(this.lstNoeuds.get(Integer.parseInt(tabRegions[i])-1));

					this.lstRegions.get(Integer.parseInt(tabRegions[0])-1).setNoeudCouleur();						
				}

				//création des arêtes
				case "[ARETES]" ->
				{
					String[] arete    = ligne.split("\t");
					int idNoeudSource = Integer.parseInt(arete[0]);

					for(int i = 1; i < arete.length; i++)
					{
						int idNoeudDestination = Integer.parseInt(arete[i]);

						Noeud noeudDep = null;
						Noeud noeudArr = null;
						
						noeudArr = this.lstNoeuds.get(idNoeudDestination - 1);
						noeudDep = this.lstNoeuds.get(idNoeudSource      - 1);

						if (noeudDep != null && noeudArr != null)
						{
							Arete newArete = new Arete(noeudDep, noeudArr);
							this.lstAretes.add(newArete);
							Arete.lstArete.add(newArete);
						}

						noeudDep = noeudArr;

						idNoeudSource = Integer.parseInt(arete[i]); 
					}
				}

				//attribution des Bonus ( prenant en compte qu'un ligne s'écrit comme ci-dessous :)
				//idSomDEp  idSomArr    bonus
				case "[BONUS]" ->
				{
					String[] tabBonus = ligne.split("\t");
					int idSomDep   = Integer.parseInt(tabBonus[0]);
					int idSomArr   = Integer.parseInt(tabBonus[1]);
					int bonus      = Integer.parseInt(tabBonus[2]);

					for(Arete a : lstAretes)
					{
						if(a.getSomDep().getId() == idSomDep && a.getSomArr().getId() == idSomArr)
						{
							a.setBonus(bonus);
						}
					}
				}
			}
		}
	}
    
	// Accesseurs

	public ArrayList<Noeud> getLstNoeuds()
	{
		return this.lstNoeuds;
	}

	public ArrayList<Arete> getLstAretes()
	{
		return this.lstAretes;
	}

	public ArrayList<Region> getLstRegions()
	{
		return this.lstRegions;
	}

	public Noeud getNoeud(int id)
	{
		return this.lstNoeuds.get(id - 1);
	}
}
