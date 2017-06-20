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

public class RewindButton extends JButton implements MouseListener{

  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//private Image imgRewind;
	private ImageIcon imgRewind;
	private JButton rewLabel;
  private int rewindCpt;
  
  public RewindButton(){

	  ImageIcon imgRewind = InsertImageIcon.InsertImageIcon("rewind");
    rewLabel = new JButton(imgRewind);

    rewLabel.setBackground(Color.white);
    
    rewLabel.addActionListener(new ActionListener() {          
	    @Override
		public void actionPerformed(ActionEvent e) {
	         System.out.println("Rewind");
	         rewindCpt += 1;
	    }
	}); 
    
    rewindCpt = 1;

    
    this.addMouseListener(this);
  }
  
  public JButton getRewLabel(){
	  return rewLabel;
  }
  
  public int getRewindCpt() {
	return rewindCpt;
}

  @Override
public void mouseClicked(MouseEvent event) { 
	  System.out.println("rew");
	  rewindCpt += 1;
	  
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