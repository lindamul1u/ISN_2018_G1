package game;
import java.awt.*;  
import java.awt.event.*;

import javax.swing.JPanel;  
public class Graphique extends JPanel {
	  private int posX = 50;
	  private int posY = 50;
	  private Color c;
	  Graphique(Color c){
		  this.c=c;
	  }

	  public void paintComponent(Graphics g){
	    g.setColor(c);
	    g.fillOval(posX, posY, 10,10);
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