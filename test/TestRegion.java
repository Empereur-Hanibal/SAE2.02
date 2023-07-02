package graphe.test;

import graphe.metier.*;

/** Test de la classe Region */
public class TestRegion
{
	public static void main(String[] args)
	{
		Region r = new Region(1);

		System.out.println("Id : " + r.getId());
		System.out.println("Ajout de noeud : " + r.addNoeud(new Noeud(1, 10, 10)));
		System.out.println("Liste Noeud : " + r.getTabN());
		System.out.println("CPT : " + r.getCptN());
		System.out.println(r);
	}
}
