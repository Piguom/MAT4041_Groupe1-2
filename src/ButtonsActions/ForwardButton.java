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

public class ForwardButton extends JButton implements MouseListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ImageIcon imgForward;
	private JButton forLabel;
	
  private int forwardCpt;
  
  public ForwardButton(){
  
  	ImageIcon imgForward = InsertImageIcon.InsertImageIcon("forward");
    forLabel = new JButton(imgForward);
    
    forLabel.setBackground(Color.white);
    
    forLabel.addActionListener(new ActionListener() {          
	    @Override
		public void actionPerformed(ActionEvent e) {
	         System.out.println("forward");
	         forwardCpt += 1;
	    }
	}); 
    
    forwardCpt = 1;

    
    this.addMouseListener(this);
  }
  
  public JButton getForLabel(){
	  return forLabel;
  }
  
  public int getForwardCpt() {
	return forwardCpt;
}


  @Override
public void mouseClicked(MouseEvent event) { 
	  System.out.println("yo");
	  forwardCpt += 1;
	  
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