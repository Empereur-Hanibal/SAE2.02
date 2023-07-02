package graphe.test;

import graphe.metier.*;

/** Test de la classe Region */
public class TestArete
{
	public static void main(String[] args)
	{
		Arete a1, a2;
		
		a1 = new Arete(new Noeud(10, 100, 100), new Noeud(20, 200, 200));
		a2 = new Arete(new Noeud(1, 10, 10), new Noeud(2, 20, 20));
		
		System.out.println(a1);
		System.out.println(a2);
		
		System.out.println("sommet dep a : " + a1.getSomDep());
		System.out.println("sommet dep b : " + a2.getSomDep());
		
		System.out.println("sommet arr a : " + a1.getSomArr());
		System.out.println("sommet arr b : " + a2.getSomArr());
		
		System.out.println("a : " + a1.getId());
		System.out.println("b : " + a2.getId());
		
		System.out.println("coul a : " + a1.getPossessionCoul());
		System.out.println("coul b : " + a2.getPossessionCoul());
		
		System.out.println("extr coul a : " + a1.getbExtreNotColor());
		System.out.println("extr coul b : " + a2.getbExtreNotColor());
		
		System.out.println("set sommet dep a : " + a1.setSomDep(new Noeud(3, 30, 30)));
		System.out.println("set sommet arr a : " + a1.setSomArr(new Noeud(4, 40, 40)));
		
		System.out.println("sommet dep a : " + a1.getSomDep());
		System.out.println("sommet arr a : " + a1.getSomArr());
		
		System.out.println("bExtreNotColor a1 : " + a1.bExtreNotColor());
		System.out.println("bExtreNotColor a2 : " + a2.bExtreNotColor());
		
		System.out.println("set coul a : " + a1.setPossessionCoul("Rouge"));
		System.out.println("set coul b : " + a2.setPossessionCoul("Bleu"));
		
		System.out.println("coul a : " + a1.getPossessionCoul());
		System.out.println("coul b : " + a2.getPossessionCoul());
		
		System.out.println("add a : " + a1.addArete(a1));
		//System.out.println(a1);
		
		System.out.println("bExtreNotColor a1 : " + a1.bExtreNotColor());
		System.out.println("bExtreNotColor a2 : " + a2.bExtreNotColor());
	}
}
