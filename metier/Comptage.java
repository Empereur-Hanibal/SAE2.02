package graphe.metier;

import graphe.Controleur;

import java.util.ArrayList;

public class Comptage
{
	private int cptNbMax;
	private int cptR;

	private Controleur ctrl;

	private ArrayList<Region> tabReg;
	private ArrayList<Noeud>  tabNoeuds;

	public Comptage(Controleur ctrl)
	{
		this.cptNbMax = 0;
		this.cptR = 0;

		this.ctrl = ctrl;

		this.tabReg    = this.ctrl.getTabRegions();
		this.tabNoeuds = this.ctrl.getTabNoeud();
	}

	public int getCptNbMax()
	{
		return this.cptNbMax;
	}
	
	public int getCptR()
	{
		return this.cptR;
	}

	public ArrayList<Region> getTabReg()
	{
		return this.tabReg;
	}

	public int addPts(String coul) 
	{
		int cptTemp = 0;
		int ptsBonus = 0;
		boolean aCoulDansReg = false;
		
			
		ArrayList<Arete> tabATemp = Arete.getALAretes();
			
		// Parcours les arêtes dans la région
		for (Arete a : tabATemp)
		{
			if (a.getPossessionCoul().equals(coul)) 
			{
				cptTemp++;
				cptTemp = cptTemp * 2;
				if (!aCoulDansReg) 
				{
					this.cptR++;
					aCoulDansReg = true;
				}
				ptsBonus += a.getBonus();
				break;
			}
		}
			
		this.cptNbMax = cptTemp;
		
		return this.cptR * this.cptNbMax + ptsBonus;
	}
	
	public int getTotalPts()
	{
		int totalPts = 0;
	 
		for (String coul : this.ctrl.getTabCouleur())
		{
			totalPts += this.addPts(coul);
		}
		
		return totalPts;
	}
}
