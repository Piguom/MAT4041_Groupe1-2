package Simulateur;

import ButtonsActions.InfoBouton;
import Fenetre.Fenetre;

public class Simulateur {

	private Fenetre fenetre;
	private int tMax;
	private InfoBouton infoBouton;
	
	public Simulateur (Fenetre fenetre, int tMax, InfoBouton infoBouton) {
		
		this.fenetre = fenetre;
		this.tMax = tMax;
		this.infoBouton = infoBouton;
		
		int tNow = 0;
		
		while (tNow < tMax-1) {
		
			try {
		    	Thread.sleep(fenetre.getRewindButton().getRewindCpt()*5000/fenetre.getForwardButton().getForwardCpt());
		    	if (!fenetre.getPauseButton().getIsPaused())
		    	{
		    	tNow += 1;
		    	fenetre.setTempsEnCours(tNow);
		    	infoBouton.setIDCaisse(-1, "Thread");
		    	infoBouton.setIDClient(-1);
		    	fenetre.paint();
		    	}
		    	
		    }  catch (InterruptedException e) {
		        
		        // gestion de l'erreur
		    }
		}
	}


}
