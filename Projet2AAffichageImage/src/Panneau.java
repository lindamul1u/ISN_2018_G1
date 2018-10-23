import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

 

public class Panneau extends JPanel { 

  public void paintComponent(Graphics g){

    //Vous verrez cette phrase chaque fois que la méthode sera invoquée

    System.out.println("Je suis exécutée !"); 

    g.fillOval(20, 20, 75, 75);
    String chemin ="C:\\Users\\Amaury\\Documents\\PROJET2A\\ISN_2018_G1\\Labyrinthe\\image\\image.png";
    BufferedImage image = null;
    try {
		image = ImageIO.read(new File(chemin));
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    g.drawImage(image, 0, 0,null);
  }               

}