package game;
import java.awt.*;  
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;  
public class Graphique extends JPanel {
	  private int posX;
	  private int posY ;
	  private Color c;
	  private int Arret;
	  Graphique(Color c){
		  this.c=c;
		  Arret=0;
	  }

	    private BufferedImage image;

	    public void setImage(String s){
	        try {
				this.image = image = ImageIO.read(new File(s));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			};
	    }
	    public Image getImage(Image image){
	        return image;
	    }
	    
	  public void paintComponent(Graphics g){
		if(Arret==0) {
			
			    g.drawImage(image, posX,posY,null);
			
		}
		else {
			g.drawString("Fin du jeu",1000,10);
		}
	   
	  }
	  public void setArret(int a) {
		  this.Arret=a;
	  }

	  public int getPosX() {
	    return posX;
	  }

	  public void setPosX(int posX) {
	    this.posX = posX;
	  }

	  public int getPosY() {
	    return posY;
	  }

	  public void setPosY(int posY) {
	    this.posY = posY;
	  }   
	  public void setCol(Color c) {
		  this.c=c;
	  }
	  
	  
	}