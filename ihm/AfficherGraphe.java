package graphe.ihm;

import graphe.Controleur;

import java.awt.Graphics;
import java.awt.Color;
import java.util.*;

public class AfficherGraphe
{
	private PanelGraphe panel;

	public AfficherGraphe(Controleur ctrl)
	{
		new FrameGraphe(ctrl);       
	}

}
