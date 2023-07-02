package graphe.metier;

import java.util.ArrayList;

public class Region
{
	private int id;
	private ArrayList<Noeud> tabN;
	private int cptN;
	private String couleur;
	private static String[] couleurR = {"#FFAACC", "#FFBBCC", "#FFCCCC", "#FFDDCC", "#FFEECC", "#FFFFCC", "#FFAADD", "#FFBBDD", "#FFCCDD", "#FFDDDD", "#FFEEDD", "#FFFFDD","#FFAAEE", "#FFBBEE", "#FFCCEE", "#FFDDEE", "#FFEEEE", "#FFFFEE"};

	public Region(int id)
	{
		this.id = id;
		this.tabN = new ArrayList<Noeud>();
		this.cptN = 0;

		this.couleur = couleurR[id];
	}

	public int getId()
	{
		return this.id;
	}

	public ArrayList<Noeud> getTabN()
	{
		return this.tabN;
	}

	public int getCptN()
	{
		return this.cptN;
	}

	public boolean addNoeud(Noeud n)
	{
		this.tabN.add(n);
		this.cptN++;
		return true;
	}

	public void setNoeudCouleur()
	{
		for(Noeud n : this.tabN)
		{
			n.setCouleurRegion(this.couleur);
		}
	}

	public String toString()
	{
		return this.id + " : " + this.cptN + " éléments";
	}
}
