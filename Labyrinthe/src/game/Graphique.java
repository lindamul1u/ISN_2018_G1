package game;
import java.awt.*;  
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;  
public class Graphique extends JPanel  {
	private int posX;
	private int posY ;
	private Color c;
	private int Arret;
	private Plateau p;
	private String[][] M;
	private int x0,y0;
	Graphique(Color c,Plateau p){
		this.c=c;
		Arret=0;
		this.p=p;
		M=p.getPlateau();
		x0=p.x0;
		y0=p.y0;
		this.setPosX(x0);
		this.setPosY(y0);

		X0Y0();

	}
	
public void X0Y0() {


	this.x0=(1890-30*p.n)/2;
	this.y0=(990-30*p.m)/2;
	
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

	public void paintComponent(Graphics g ){
		if(Arret==0) {
			Dessin1(g);
			//Dessin2(g);
			//Dessin3(g);
					}




					else {
						g.drawString("Fin du jeu",1000,10);
					}


				}
			
		
		
	
	public void Dessin3(Graphics g) {int x=0;
	int y=0;
	String[][] mat=p.getPlateau();

	for(int j=0;j<p.m;j++) {
		for(int i = 0; i < p.n; i++){
			if(mat[i][j].equals(p.mur)) {

				x=x0+i*30;
				y=y0+j*30;
				this.setImage("mur.png");
				this.setPosX(x);
				this.setPosY(y);


				g.drawImage(image, posX,posY,null);

			}
			else if(mat[i][j].equals(p.chemin)) {
				x=x0+i*30;
				y=y0+j*30;

				this.setImage("chemin.png");
				this.setPosX(x);
				this.setPosY(y);

				g.drawImage(image, posX,posY,null);


			}
			else if(mat[i][j].equals(p.heros)) {
				x=x0+i*30;
				y=y0+j*30;

				this.setImage("heros.png");
				this.setPosX(x);
				this.setPosY(y);

				g.drawImage(image, posX,posY,null);


			}
			else if(mat[i][j].equals(p.tresor)) {
				x=x0+i*30;
				y=y0+j*30;

				this.setImage("tresor.png");
				this.setPosX(x);
				this.setPosY(y);

				g.drawImage(image, posX,posY,null);


			}
			else if(mat[i][j].equals(p.piege)) {
				x=x0+i*30;
				y=y0+j*30;

				this.setImage("piege.png");
				this.setPosX(x);
				this.setPosY(y);

				g.drawImage(image, posX,posY,null);




			}
			else if(mat[i][j].equals(p.Magie)) {
				x=x0+i*30;
				y=y0+j*30;

				this.setImage("Magique.png");
				this.setPosX(x);
				this.setPosY(y);


				g.drawImage(image, posX,posY,null);
			}
			else if(mat[i][j].equals(p.monstre)) {
				x=x0+i*30;
				y=y0+j*30;
				this.setPosX(x);
				this.setPosY(y);

				this.setImage("monstre3.png");


				g.drawImage(image, posX,posY,null);
			}
		}
	}


	}
	public void Dessin2(Graphics g) {int x=0;
	int y=0;
	String[][] mat=p.getPlateau();

	for(int j=0;j<p.m;j++) {
		for(int i = 0; i < p.n; i++){
			if(mat[i][j].equals(p.mur)) {
				x=x0+i*30;
				y=y0+j*30;
				this.setImage("mur.png");
				this.setPosX(x);
				this.setPosY(y);


				g.drawImage(image, posX,posY,null);

			}
			else if(mat[i][j].equals(p.chemin)) {
				x=x0+i*30;
				y=y0+j*30;

				this.setImage("chemin.png");
				this.setPosX(x);
				this.setPosY(y);

				g.drawImage(image, posX,posY,null);


			}
			else if(mat[i][j].equals(p.heros)) {
				x=x0+i*30;
				y=y0+j*30;

				this.setImage("heros.png");
				this.setPosX(x);
				this.setPosY(y);

				g.drawImage(image, posX,posY,null);


			}
			else if(mat[i][j].equals(p.tresor)) {
				x=x0+i*30;
				y=y0+j*30;

				this.setImage("tresor.png");
				this.setPosX(x);
				this.setPosY(y);

				g.drawImage(image, posX,posY,null);


			}
			else if(mat[i][j].equals(p.piege)) {
				x=x0+i*30;
				y=y0+j*30;

				this.setImage("piege.png");
				this.setPosX(x);
				this.setPosY(y);

				g.drawImage(image, posX,posY,null);




			}
			else if(mat[i][j].equals(p.Magie)) {
				x=x0+i*30;
				y=y0+j*30;

				this.setImage("Magique.png");
				this.setPosX(x);
				this.setPosY(y);


				g.drawImage(image, posX,posY,null);
			}
			else if(mat[i][j].equals(p.monstre)) {
				x=x0+i*30;
				y=y0+j*30;
				this.setPosX(x);
				this.setPosY(y);

				this.setImage("monstre1.png");


				g.drawImage(image, posX,posY,null);
			}
		}
	}


	}
	public void Dessin1(Graphics g) {int x=0;
	int y=0;
	String[][] mat=p.getPlateau();

	for(int j=0;j<p.m;j++) {
		for(int i = 0; i < p.n; i++){
			if(mat[i][j].equals(p.mur)) {
				x=x0+i*30;
				y=y0+j*30;
				this.setImage("mur.png");
				this.setPosX(x);
				this.setPosY(y);


				g.drawImage(image, posX,posY,null);

			}
			else if(mat[i][j].equals(p.chemin)) {
				x=x0+i*30;
				y=y0+j*30;

				this.setImage("chemin.png");
				this.setPosX(x);
				this.setPosY(y);

				g.drawImage(image, posX,posY,null);


			}
			else if(mat[i][j].equals(p.heros)) {
				x=x0+i*30;
				y=y0+j*30;

				this.setImage("heros.png");
				this.setPosX(x);
				this.setPosY(y);

				g.drawImage(image, posX,posY,null);


			}
			else if(mat[i][j].equals(p.tresor)) {
				x=x0+i*30;
				y=y0+j*30;

				this.setImage("tresor.png");
				this.setPosX(x);
				this.setPosY(y);

				g.drawImage(image, posX,posY,null);


			}
			else if(mat[i][j].equals(p.piege)) {
				x=x0+i*30;
				y=y0+j*30;

				this.setImage("piege.png");
				this.setPosX(x);
				this.setPosY(y);

				g.drawImage(image, posX,posY,null);




			}
			else if(mat[i][j].equals(p.Magie)) {
				x=x0+i*30;
				y=y0+j*30;

				this.setImage("Magique.png");
				this.setPosX(x);
				this.setPosY(y);


				g.drawImage(image, posX,posY,null);
			}
			else if(mat[i][j].equals(p.monstre)) {
				x=x0+i*30;
				y=y0+j*30;
				this.setPosX(x);
				this.setPosY(y);

				this.setImage("monstre2.png");


				g.drawImage(image, posX,posY,null);
			}
			else if(mat[i][j].equals(p.Fant)) {
				x=x0+i*30;
				y=y0+j*30;
				this.setPosX(x);
				this.setPosY(y);

				this.setImage("ghost.png");


				g.drawImage(image, posX,posY,null);
			}
		}
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