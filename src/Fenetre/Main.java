package Fenetre;

import javax.swing.JFrame;

public class Main extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame frame;
	
	public Main() {

		frame = new JFrame("Processus stochastiques appliqués au problème de la file d'attente");
		frame.setSize(1000,600);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);	
	}

}
