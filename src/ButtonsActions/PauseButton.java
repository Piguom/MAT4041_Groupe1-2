package ButtonsActions;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import Main.Main;

public class PauseButton extends JButton implements MouseListener{


  private boolean isPaused;
  
  private ImageIcon imgPause;
  private ImageIcon imgPlay;
  
	private JButton pauseLabel;
	
	private URL url;
	private URL url1;
	
	private InfoBouton infoBouton;
	
  public PauseButton(InfoBouton clickID){

	  this.infoBouton = infoBouton;
	
	ImageIcon imgPause = InsertImageIcon.InsertImageIcon("pause");

	ImageIcon imgPlay = InsertImageIcon.InsertImageIcon("play");

	
	pauseLabel = new JButton(imgPause);
   
	pauseLabel.setBackground(Color.white);
	
	pauseLabel.addActionListener(new ActionListener() {          
	    @Override
		public void actionPerformed(ActionEvent e) {
	         System.out.println("pause/play");
	         
	   	  if (isPaused){
			  pauseLabel.setIcon(imgPause);
			  isPaused = false;
			  clickID.setIDPause(1);
		  }
		  else
		  {
			  pauseLabel.setIcon(imgPlay);
			  isPaused = true;
			  clickID.setIDPause(-1);
		  }
	    }
	}); 
	
    isPaused = false;
    
    this.addMouseListener(this);
  }
  
  public JButton getPauseLabel(){
	  return pauseLabel;
  }
  
  public boolean getIsPaused() {
	return isPaused;
}

  @Override
public void mouseClicked(MouseEvent event) { 
	  
  }

  //Méthode appelée lors du survol de la souris
  @Override
public void mouseEntered(MouseEvent event) { }

  //Méthode appelée lorsque la souris sort de la zone du bouton
  @Override
public void mouseExited(MouseEvent event) { }

  //Méthode appelée lorsque l'on presse le bouton gauche de la souris
  @Override
public void mousePressed(MouseEvent event) { }

  //Méthode appelée lorsque l'on relâche le clic de souris
  @Override
public void mouseReleased(MouseEvent event) { }       
  
  
  
}