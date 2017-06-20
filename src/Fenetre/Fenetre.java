package Fenetre;


import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.*;

import ButtonsActions.InfoBouton;
import ButtonsActions.ForwardButton;
import ButtonsActions.PauseButton;
import ButtonsActions.RewindButton;
import Caisses.Caisse;
import Caisses.CaisseButton;
import Clients.ClientButton;

public class Fenetre extends JFrame implements Observer {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ArrayList<ArrayList<Caisse>> data_AL;
	
	private PauseButton pauseButton;
	private ForwardButton forwardButton;
	private RewindButton rewindButton;
	
	private JPanel simuPanel, statsPanel, pausePanel;
	
	private JPanel statsCaissePanel = new JPanel();
	private JPanel statsClientPanel = new JPanel();
	
	private JFrame frame;
	
	private InfoBouton infoBouton;
	
	private int tempsEnCours, rewindCpt;
	
	public Fenetre(ArrayList<ArrayList<Caisse>> data_AL, InfoBouton infoBouton){
		this.data_AL = data_AL;
		this.infoBouton = infoBouton;
		
		this.tempsEnCours = 0;
		this.rewindCpt = 1;
		
		this.pauseButton = new PauseButton(this.infoBouton);
		this.forwardButton = new ForwardButton();
		this.rewindButton = new RewindButton();
		
		pausePanel = new JPanel();
		pausePanel.setLayout(new GridLayout(1,3));
		pausePanel.add(pauseButton.getPauseLabel());
		pausePanel.add(rewindButton.getRewLabel());
		pausePanel.add(forwardButton.getForLabel());
		
		frame = new JFrame("File d'attente en supermarché");
	}

	public void setTempsEnCours(int tempsEnCours) {
		this.tempsEnCours = tempsEnCours;
	}

	public PauseButton getPauseButton() {
		return pauseButton;
	}

	public ForwardButton getForwardButton() {
		return forwardButton;
	}

	public RewindButton getRewindButton() {
		return rewindButton;
	}

	public void paint(){
		frame.getContentPane().removeAll();
		simuPanel = new JPanel();
		statsPanel = new JPanel();
		
		statsCaissePanel = new JPanel();
		statsClientPanel = new JPanel();
		
		pausePanel.setBackground(Color.white);
		simuPanel.setBackground(Color.white);
		
		int nbCaisses = data_AL.get(0).size();		
		int nbClientsMax = data_AL.get(tempsEnCours).get(0).getTotalClients();
		
		if(nbCaisses > 1){
			for (int i = 1; i<nbCaisses; i++){
				if (nbClientsMax < data_AL.get(tempsEnCours).get(i).getTotalClients())
					nbClientsMax = data_AL.get(tempsEnCours).get(i).getTotalClients();
			}
		}
		
		ArrayList<Object> clientFake = new ArrayList<Object>();
		clientFake.add("fake");
		clientFake.add(0.0);
		
		for(int i = 0 ; i < nbCaisses; i++){
			if(data_AL.get(tempsEnCours).get(i).getTotalClients() < nbClientsMax){
				while (data_AL.get(tempsEnCours).get(i).getClients().size() < nbClientsMax){
					data_AL.get(tempsEnCours).get(i).getClients().add(clientFake);
				}
			}
		}
		
		simuPanel.setLayout(new GridLayout(0,nbCaisses));
		statsPanel.setLayout(new GridLayout(0,1));
		statsCaissePanel.setLayout(new GridLayout(0,1));
		statsClientPanel.setLayout(new GridLayout(0,1));
		
		if(infoBouton.getIDCaisse() == -1 )
			statsCaissePanel.add(new JLabel("Cliquez sur une caisse pour voir ses statistiques"));
		else{
			statsCaissePanel.add(new JLabel("Nom de la caisse : " + data_AL.get(tempsEnCours).get(infoBouton.getIDCaisse()).getName()));
			statsCaissePanel.add(new JLabel("Statut de la caisse : " + data_AL.get(tempsEnCours).get(infoBouton.getIDCaisse()).getStatus()));
			statsCaissePanel.add(new JLabel("Vitesse moyenne : " + String.valueOf(data_AL.get(tempsEnCours).get(infoBouton.getIDCaisse()).getAvgSpeed()) + " clients/minute"));
			statsCaissePanel.add(new JLabel("Vitesse maximale : " + String.valueOf(data_AL.get(tempsEnCours).get(infoBouton.getIDCaisse()).getMaxSpeed()) + " clients/minute"));
			statsCaissePanel.add(new JLabel("Nombre de clients total : " + String.valueOf(data_AL.get(tempsEnCours).get(infoBouton.getIDCaisse()).getTotalClients())));
			statsCaissePanel.add(new JLabel("Nombre de clients contents : " + String.valueOf(data_AL.get(tempsEnCours).get(infoBouton.getIDCaisse()).getHappyClient())));
			statsCaissePanel.add(new JLabel("Nombre de clients mécontents : " + String.valueOf(data_AL.get(tempsEnCours).get(infoBouton.getIDCaisse()).getUnhappyClient())));
			statsCaissePanel.add(new JLabel("Nombre de clients neutres : " + String.valueOf(data_AL.get(tempsEnCours).get(infoBouton.getIDCaisse()).getNeutralClient())));
		}
		
		if (infoBouton.getIDClient() == -1 )
			statsClientPanel.add(new JLabel("Cliquez sur un client pour voir ses statistiques"));
		else{
			int placement = infoBouton.getIDClient()+1;
			statsClientPanel.add(new JLabel("Placement du client dans la file : " + placement));
			statsClientPanel.add(new JLabel("Statut du client : " + data_AL.get(tempsEnCours).get(infoBouton.getIDCaisse()).getClients().get(infoBouton.getIDClient()).get(0)));
			statsClientPanel.add(new JLabel("Theta S du client : " + data_AL.get(tempsEnCours).get(infoBouton.getIDCaisse()).getClients().get(infoBouton.getIDClient()).get(1)));
		}

		for(int i = 0; i < nbCaisses; i++){
			CaisseButton caissTmp = new CaisseButton(i, data_AL.get(tempsEnCours).get(i).getStatus(), (700/nbCaisses)-(700/(2*nbCaisses)), 0, infoBouton);
			simuPanel.add(caissTmp.getCaisseLabel());
		}
		
		for(int j = 0; j < nbClientsMax; j++){
			for(int i = 0; i < nbCaisses; i++){
				ClientButton clientTmp = new ClientButton(j, i, data_AL.get(tempsEnCours).get(i).getClients().get(j).get(0), data_AL.get(tempsEnCours).get(i).getClients().get(j).get(1), (700/nbCaisses)-(700/(2*nbCaisses)), 0, infoBouton);
				simuPanel.add(clientTmp.getClientLabel());
			}
		}
		
		statsPanel.add(statsCaissePanel);
		statsPanel.add(statsClientPanel);
	    
	    JSplitPane simuAndButtonPanel = new JSplitPane(JSplitPane.VERTICAL_SPLIT, pausePanel, simuPanel);
	    simuAndButtonPanel.setResizeWeight(0.08);
	    
	    JSplitPane fullPanel = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, simuAndButtonPanel, statsPanel);
	    fullPanel.setResizeWeight(0.95);
	    
		frame.add(fullPanel);
	    
		frame.setSize(1000,600);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
	}

	@Override
	public void update(Observable o, Object arg) {
		paint();
	}
}
