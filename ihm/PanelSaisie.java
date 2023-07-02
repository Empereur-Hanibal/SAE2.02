package graphe.ihm;

import graphe.Controleur;
import graphe.metier.*;

import java.awt.Color;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

public class PanelSaisie extends JPanel implements ActionListener
{
	/*--------------------
	Attributs
	--------------------*/

	private Controleur ctrl;
	private FrameGraphe ihm;

	private JLabel lblId1, lblId2, lblPts, lblErreur;
	private JTextField txtIdSommet1, txtIdSommet2;
	private JButton btnTracer;

	/*--------------------
	Méthodes
	--------------------*/

	// Constructeur
	public PanelSaisie(Controleur ctrl, FrameGraphe ihm)
	{
		this.ctrl = ctrl;
		this.ihm  = ihm;

		// Création des composants
		this.lblId1 = new JLabel("Identifiant de point 1 :");
		this.txtIdSommet1 = new JTextField(15);
		this.txtIdSommet1.setEditable(true);
		
		this.lblId2 = new JLabel("Identifiant de point 2 :");
		this.txtIdSommet2 = new JTextField(15);
		this.txtIdSommet2.setEditable(true);

		this.btnTracer = new JButton("Tracer");

		this.lblPts    = new JLabel("Nombre de points : 0");
		this.lblErreur = new JLabel("");

		// Positionnement des composants
		this.add(this.lblId1);
		this.add(this.txtIdSommet1);
		
		this.add(this.lblId2);
		this.add(this.txtIdSommet2);

		this.add(this.btnTracer);

		this.add(this.lblPts);
		this.add(this.lblErreur);

		// Activation des composants
		this.btnTracer.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e)
	{
		int nbPts = 0;

		if (e.getSource() == this.btnTracer)
		{
			// Récupération des identifiants de points entrés
			int id1, id2;

			try
			{
				id1 = Integer.parseInt(this.txtIdSommet1.getText());
				id2 = Integer.parseInt(this.txtIdSommet2.getText());
			}
			catch (Exception except)
			{
				this.lblErreur.setText(" -  Nombres invalides");
				id1 = 0;
				id2 = 0;
			}

			this.txtIdSommet1.setText("");
			this.txtIdSommet2.setText("");

			ArrayList<Arete> lstAretes = this.ctrl.getTabAretes();

			// Récupération des arêtes correspondant aux identifiants de noeuds entrés
			for (Arete a : lstAretes)
			{
				int idSomDep = a.getSomDep().getId();
				int idSomArr = a.getSomArr().getId();

				if (id1 != id2 && idSomDep == id1 && idSomArr == id2 || idSomDep == id2 && idSomArr == id1)
				{
					if (a.colorier(this.ctrl.getCoulJoueur()))
					{
						nbPts = this.ctrl.getTotalPts();
					
						this.lblPts.setText("Vous avez " + nbPts + " points");
					}
				}
			}

			this.ihm.majIHM();
            
		}
	}
}
