package Fenetre;

import java.awt.Button;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

public class Fenetre extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame frame;
	private JSplitPane simulateur, fenetre;
	private JPanel caisses, files, commentaires;
	private JLabel titrec, titref, titrecom;
	private Button start, stop;
	
	public Fenetre() {
		frame = new JFrame("Processus stochastiques - File d'attente en magasin");
		frame.setSize(1000,600);
		frame.setLocationRelativeTo(null);
		
		caisses = new JPanel();
		caisses.setBackground(Color.WHITE);
		caisses.setLayout(new GridLayout(0,10));
		titrec = new JLabel("Caisses");
		caisses.add(titrec);
		
		files = new JPanel();
		files.setBackground(Color.WHITE);
		files.setLayout(new GridLayout(0,10));
		titref = new JLabel("Files");
		files.add(titref);
		
		commentaires = new JPanel();
		commentaires.setBackground(Color.GRAY);	
		commentaires.setLayout(new GridLayout(2,1));
		titrecom = new JLabel("Rapports");
		start = new Button("Démarrer");
		start.setSize(50, 50);
		stop = new Button("Arrêter");
		stop.setSize(50, 50);
		commentaires.add(start);	
		commentaires.add(stop);	
		commentaires.add(titrecom);		
		
		simulateur = new JSplitPane(JSplitPane.VERTICAL_SPLIT, caisses, files);
		
		fenetre = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, simulateur, commentaires);
		fenetre.setResizeWeight(1);
		
		frame.add(fenetre);		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);	
	}
}
