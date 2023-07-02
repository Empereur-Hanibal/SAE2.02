package graphe.ihm;

import graphe.Controleur;
import graphe.metier.*;

import javax.swing.*;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;


public class PanelGraphe extends JPanel
{
	private Controleur ctrl;
	private PanelGraphe panel;
	private FrameGraphe frame;

    

	public PanelGraphe(Controleur ctrl, FrameGraphe frame)
	{
		this.ctrl  = ctrl;
		this.frame = frame;
		this.panel = this;
		this.repaint();
	}

	public void drawPoint(Graphics g, int x, int y)
	{
		g.setColor(Color.WHITE);
		g.fillOval(x, y, 3, 3);

		g.setColor(Color.BLACK);
		g.drawOval(x, y, 3, 3);
	}

	public void majIHM()
	{
		frame.majIHM();
	}

	public void paintComponent(Graphics g)
	{
		ArrayList<Noeud> tabNoeuds   = this.ctrl.getTabNoeud  ();
		ArrayList<Arete> tabAretes   = this.ctrl.getTabAretes ();
		ArrayList<Region> tabRegions = this.ctrl.getTabRegions();

		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		
		// Dessiner l'ensemble des figures
		
		for (Arete a : tabAretes)
		{
			Noeud dep = a.getSomDep();
			Noeud arr = a.getSomArr();

			g.setColor(Color.decode( a.getPossessionCoul() ) );
			g.drawLine((dep.getCoordX()*panel.getWidth())/110, (dep.getCoordY() * panel.getHeight())/110, (arr.getCoordX() * panel.getWidth())/110, (arr.getCoordY() * panel.getHeight())/110);
		}

		for (Noeud n : tabNoeuds)
		{
			String id = ""+n.getId();



			g2.setColor(Color.decode(n.getCouleurRegion()));
			g2.fillOval( ( (n.getCoordX()*panel.getWidth() )) /110 - 15 , ( ( n.getCoordY()*panel.getHeight() ) )/110  - 15 , 30, 30 );
			g2.setColor(Color.BLACK);
			g2.setStroke(new BasicStroke(4.0f));
			g2.drawOval( ( (n.getCoordX()*panel.getWidth() )) /110 - 15 , ( ( n.getCoordY()*panel.getHeight() ) )/110  - 15, 30, 30 );
            
			Font font = new Font("Arial", Font.BOLD, 12);
			g2.setFont(font);
			g2.setColor(Color.BLACK);

			g2.setStroke(new BasicStroke(3.0f));
			g2.drawString(id, (n.getCoordX()*panel.getWidth() ) /110-5, (n.getCoordY()*panel.getHeight()) /110+5);
			
        }
    }
}
