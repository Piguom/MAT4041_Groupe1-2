package ButtonsActions;

import java.net.URL;

import javax.swing.ImageIcon;

import Main.Main;

public class InsertImageIcon {
	
	public static ImageIcon InsertImageIcon(String name){
		
		URL url = Main.class.getResource("/res/" + name + ".png");
		ImageIcon image = new ImageIcon(url);
		return image;
	}
}
