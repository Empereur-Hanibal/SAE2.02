package graphe.ihm;

import graphe.Controleur;

import javax.swing.*;
import java.awt.event.ComponentEvent;
import java.awt.BorderLayout;

public class FrameGraphe extends JFrame
{
	private PanelGraphe panelGraphe;
	private PanelSaisie panelSaisie;

	public FrameGraphe(Controleur ctrl)
	{
		this.setTitle("Graphe");
		this.setLocation(600, 100);
		this.setSize(1150, 900);

		this.panelGraphe = new PanelGraphe(ctrl, this);
		this.panelSaisie = new PanelSaisie(ctrl, this);

		this.add(this.panelGraphe);
		this.add(this.panelSaisie, BorderLayout.SOUTH);

		this.setVisible(true);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void majIHM()
	{
		this.panelGraphe.repaint();
	}

	public void componentResized(ComponentEvent e)
	{
		int x = this.getWidth();
		int y = this.getHeight();
	}
}
