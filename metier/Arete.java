package graphe.metier;

import java.util.ArrayList;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.Color;

public class Arete
{

	private static int              idAuto   = 0;
	public  static ArrayList<Arete> lstArete = new ArrayList<Arete>();
	private        int              id;
	private        int              bonus;
	private        Noeud            somDep;
	private        Noeud            somArr;
	private        String           possessionCoul;
	private        boolean          bExtreNotColor;
	private static boolean          premierTrace;

	public Arete(Noeud somDep, Noeud somArr)
	{
		this.id = Arete.idAuto;
		Arete.idAuto++;

		this.bonus = 0;

		this.somDep         = somDep;
		this.somArr         = somArr;

		this.possessionCoul = "#000000";
		this.bExtreNotColor  = false;
		this.premierTrace   = true;
	}

	public Noeud getSomDep()
	{
		return this.somDep;
	}

	public Noeud getSomArr()
	{
		return this.somArr;
	}

	public int getId()
	{
		return this.id;
	}

	public String getPossessionCoul()
	{
		return this.possessionCoul;
	}

	public boolean getbExtreNotColor()
	{
		return this.bExtreNotColor;
	}

	public boolean setSomDep(Noeud somDep)
	{
		this.somDep = somDep;
		return true;
	}

	public boolean setSomArr(Noeud somArr)
	{
		this.somArr = somArr;
		return true;
	}

	public boolean setPossessionCoul(String coul)
	{
		this.possessionCoul = coul;
		return true;
	}

	public boolean setBonus(int bonus)
	{
		this.bonus = bonus;
		return true;
	}
	
	public int     getBonus()
	{
		return this.bonus;
	}

	public static ArrayList<Arete> getALAretes()
	{
		return Arete.lstArete;
	}
	
	public static boolean addArete(Arete a)
	{
		return Arete.lstArete.add(a);
	}

	public boolean colorier(String couleur)
	{
		boolean bReturn = false;
		if(Arete.premierTrace || ( this.bIntersectNull() && !this.bExtreNotColor() && this.bAreteLibre() && !this.bCycle(couleur)))
		{
			
			this.possessionCoul = couleur;
			bReturn = (this.somDep.addPossession(this) && this.somArr.addPossession(this));
			Arete.premierTrace = false;
		}
		


		return bReturn;
	}

	private boolean bIntersectNull()
	{
		boolean bReturn = false;
		boolean bSortir = false;
		Point2D intersection = null;
		Line2D line1 = (new Line2D.Double(this.getSomDep().getCoordX(), this.getSomDep().getCoordY(), this.getSomArr().getCoordX(), this.getSomArr().getCoordY()));
		Line2D line2 = null;
		
		
		for(int i=0; i<Arete.lstArete.size() && bSortir == false; i++)
		{
			if(!(Arete.lstArete.get(i).getId() == this.id)) //verifie si intersection il y a
			{
				line2 = (new Line2D.Double(Arete.lstArete.get(i).getSomDep().getCoordX(), Arete.lstArete.get(i).getSomDep().getCoordY(), Arete.lstArete.get(i).getSomArr().getCoordX(), Arete.lstArete.get(i).getSomArr().getCoordY()));
				if(line1.intersectsLine(line2))
				{
					
					
					
					
					intersection = coordIntersection(line1, line2);
					if(((intersection.getX() == line1.getX1() && intersection.getY() == line1.getY1()) ||
						(intersection.getX() == line1.getX2() && intersection.getY() == line1.getY2()) ||
						(intersection.getX() == line2.getX1() && intersection.getY() == line2.getY1()) ||
						(intersection.getX() == line2.getX2() && intersection.getY() == line2.getY2()))||
						Arete.lstArete.get(i).bAreteLibre()                                              )
					{
						
						bReturn = true;
					}
					else
					{
						bReturn = false;
						bSortir = true  ;
					}					
				}
				else
				{
					bReturn = true; //si intersection il n'y a pas
				}
			}
		}			
 		return bReturn;
	}


	
	private static Point2D coordIntersection(Line2D line1, Line2D line2)
	{
		double x1 = line1.getX1();
		double y1 = line1.getY1();
		double x2 = line1.getX2();
		double y2 = line1.getY2();

		double x3 = line2.getX1();
		double y3 = line2.getY1();
		double x4 = line2.getX2();
		double y4 = line2.getY2();

		double denominator = (x1 - x2) * (y3 - y4) - (y1 - y2) * (x3 - x4);

		double intersectionX = ((x1 * y2 - y1 * x2) * (x3 - x4) - (x1 - x2) * (x3 * y4 - y3 * x4)) / denominator;
		double intersectionY = ((x1 * y2 - y1 * x2) * (y3 - y4) - (y1 - y2) * (x3 * y4 - y3 * x4)) / denominator;

		return new Point2D.Double(intersectionX, intersectionY);
    }

	public boolean bExtreNotColor()
	{	
		return !(this.somDep.getPossession().isEmpty() || this.somArr.getPossession().isEmpty());
		
	}

	public boolean bAreteLibre()
	{
		
		if (this.possessionCoul.equals("#000000") )return true;
		return false;
	}

	public boolean bCycle(String coul)
	{
		ArrayList<Arete> lstTemp = this.somDep.getPossession();
		boolean b1 = false;
		boolean b2 = false;

		for (Arete a : lstTemp)
		{
			if( !lstTemp.isEmpty() && a.getPossessionCoul() == coul) b1 = true;
		}

		lstTemp = this.somArr.getPossession();
		for (Arete a : lstTemp)
		{
			if( !lstTemp.isEmpty() && a.getPossessionCoul() == coul) b2 = true;
		}
		
		return (b1 && b2);
	}

	public String toString()
	{
		return this.id + "/" + Arete.idAuto + " : " + "\n" + this.somDep + " - " + this.somArr + "\n" + this.possessionCoul;
	}
}
