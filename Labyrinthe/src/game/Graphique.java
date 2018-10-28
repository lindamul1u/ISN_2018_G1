package game;
import java.awt.*;  
import java.awt.event.*;

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

	  public void paintComponent(Graphics g){
		if(Arret==0) {
			 g.setColor(c);
			    g.fillRect(posX, posY, 10,10);
			
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