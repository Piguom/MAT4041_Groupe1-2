package Clients;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;

import ButtonsActions.InfoBouton;
import ButtonsActions.InsertImageIcon;

public class ClientButton extends JComponent implements MouseListener{

  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

private Image imgDisp;
  
  private int clientID;
  private int caisseID;
  private int dx;
  private int dy;
  private String status;
  private double theta_s;
  
  private InfoBouton infoBouton;
  
  private JButton clientLabel;
  
  public ClientButton(int clientID, int caisseID, Object status, Object theta_s, int dx, int dy, InfoBouton infoBouton){
   
	  this.clientID = clientID;
	  this.caisseID = caisseID;
	  this.status = status.toString();
	  this.theta_s = (double) theta_s;
	  this.dx = dx;
	  this.dy = dy;
	  
	  this.infoBouton = infoBouton;
    
	  clientLabel = new JButton();
	  
	  
	  if (status != "fake")
	  {
		  
		ImageIcon imgClient = InsertImageIcon.InsertImageIcon(this.status);
		clientLabel .setIcon(imgClient);
	  
		clientLabel.setBackground(Color.white);
		
		clientLabel.addActionListener(new ActionListener() {          
		    @Override
			public void actionPerformed(ActionEvent e) {
		    	infoBouton.setIDCaisse(caisseID, "Client");
		    	infoBouton.setIDClient(clientID);
		    }
		}); 
		
	  }
    this.addMouseListener(this);
  }


  public JButton getClientLabel(){
	  return clientLabel;
  }
  
  @Override
public void mouseClicked(MouseEvent event) { 
	  infoBouton.setIDCaisse(caisseID, "Client");
	  infoBouton.setIDClient(clientID);
	  
  }

  //M�thode appel�e lors du survol de la souris
  @Override
public void mouseEntered(MouseEvent event) { }

  //M�thode appel�e lorsque la souris sort de la zone du bouton
  @Override
public void mouseExited(MouseEvent event) { }

  //M�thode appel�e lorsque l'on presse le bouton gauche de la souris
  @Override
public void mousePressed(MouseEvent event) { }

  //M�thode appel�e lorsque l'on rel�che le clic de souris
  @Override
public void mouseReleased(MouseEvent event) { }       
  
  
  
}