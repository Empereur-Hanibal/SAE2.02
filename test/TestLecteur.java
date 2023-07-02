package graphe.test;

import graphe.metier.*;

import java.util.ArrayList;
import java.io.IOException;

/** Test de la classe Region */
public class TestLecteur
{
	public static void main(String[] args) throws IOException
	{
		/*--------------------
		Données locales
		--------------------*/

		// Variables
		Lecteur l;

		ArrayList<Noeud> lstNoeuds;
		ArrayList<Region> lstRegions;
		ArrayList<Arete> lstAretes;

		/*--------------------
		Instructions
		--------------------*/

		l = new Lecteur();

		lstNoeuds  = l.getLstNoeuds();
		lstRegions = l.getLstRegions();
		lstAretes  = l.getLstAretes();

		System.out.println("[NOEUDS]");

		for (Noeud n : lstNoeuds)
		{
			System.out.println(n);
		}
		
		System.out.println("[REGIONS]");
		
		for (Region r : lstRegions)
		{
			System.out.println(r);
		}

		System.out.println("[ARETES]");

		for (Arete a : lstAretes)
		{
			System.out.println(a);
		}
	}
}
