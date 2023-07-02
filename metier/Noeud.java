package graphe.metier;

import java.util.*;

public class Noeud
{
	private int id;
	private int coordX;
	private int coordY;
	private String couleurR;
	private ArrayList<Arete> possession;
    
	//Constructeur
	public Noeud(int id, int coordX, int coordY)
	{
		this.id         = id;
		this.coordX     = coordX;
		this.coordY     = coordY;
		this.possession = new ArrayList<Arete>();
	}

	//Accesseur
	public int              getId           ()               {return this.id;}
	public int              getCoordX       ()               {return this.coordX;}
	public int              getCoordY       ()               {return this.coordY;}
	public ArrayList<Arete> getPossession   ()               {return this.possession;}
	public boolean          addPossession   (Arete a)        {this.possession.add(a); return true;}

	public void             setCouleurRegion(String couleur) {this.couleurR = couleur;}
	public String           getCouleurRegion()               {return this.couleurR;}

	public String toString()
	{
		return this.id + "\t" + this.coordX + "\t" + this.coordY + "\t" + this.couleurR;
	}
}
