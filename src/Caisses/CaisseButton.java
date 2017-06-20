package Caisses;

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

//public class CaisseButton extends JButton implements MouseListener{
public class CaisseButton extends JComponent implements MouseListener{

  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Image imgDisp;
	private int caisseID;
	private String status;
	private int dx;
	private int dy;
  
  private JButton caisseLabel;
  
  private InfoBouton infoBouton;
  
  public CaisseButton(int caisseID, String status, int dx, int dy, InfoBouton infoBouton){
   
	  this.caisseID = caisseID;
	  this.status = status;
	  this.dx = dx;
	  this.dy = dy;
	  this.infoBouton = infoBouton;
    this.addMouseListener(this);
   
	ImageIcon imgCaisse = InsertImageIcon.InsertImageIcon(status);
	caisseLabel = new JButton(imgCaisse);
  
	caisseLabel.setBackground(Color.white);
	
	caisseLabel.addActionListener(new ActionListener() {          
	    @Override
		public void actionPerformed(ActionEvent e) {
	    	infoBouton.setIDCaisse(caisseID, "Caisse");
	    }
	}); 
  
  }
  
  public JButton getCaisseLabel(){
	  return caisseLabel;
  }
  
  @Override
public void mouseClicked(MouseEvent event) { 
	  
	  infoBouton.setIDCaisse(caisseID, "Caisse");
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