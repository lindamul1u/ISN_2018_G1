package game;
import java.awt.*;  
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Vector;

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
	private int N;
	boolean finAffiche;
	int ymax=990;
	int xmax=1890;
	Graphique(Color c,Plateau p){
		this.finAffiche=false;
		this.c=c;
		N=0;
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
		this.y0=(990-30*p.m)/2+50;

	}
	public void SetN() {
		N=N+1;
		N=N%7;
	}
	public int GetN() {
		return N; 
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
	public String toString() {
		String S=""+N;
		return S;
	}
	public void paintComponent(Graphics g ){
		Arret=p.getArret();
		this.setImage("fond.png");
		g.drawImage(image, 0,0,null);
		if(Arret==0) {
			this.finAffiche=false;
			Dessin(g);
			this.finAffiche=true;
		}
		else {
			posX=0;
			posY=0;
			this.setImage("go.png");
			g.drawImage(image, posX,posY,null);		}
		
		}


	
	public boolean getBool() {
		return this.finAffiche;
	}
	public void setBool() {
		this.finAffiche=false;
	}




	public void Dessin(Graphics g) {
		//System.out.println(p);

		if(N==0) {
			
			Dessin1(g);
			Dessin_heros1(g);
			this.SetN();
			
		}
		else if (N==1){
			Dessin2(g);
			Dessin_heros2(g);

			this.SetN();
			
			
			
		}
		else if(N==2) {
			Dessin3(g);
			Dessin_heros3(g);

			this.SetN();
		}
		else if(N==3) {
			Dessin3(g);
			Dessin_heros2(g);

			this.SetN();
		}
		
		else if(N==4) {
			Dessin4(g);
			Dessin_heros1(g);

			this.SetN();
		}
		else if(N==5) {
			Dessin5(g);
			Dessin_heros2(g);

			this.SetN();
		}
		else if(N==6) {
			Dessin6(g);
			Dessin_heros3(g);

			this.SetN();
		}
		else if(N==0) {
			Dessin7(g);
			Dessin_heros2(g);

			this.SetN();
		}

	}
	


	public void Dessin1(Graphics g) {

		int x=0;
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
				
				else if(mat[i][j].equals(p.heros)) {
					x=x0+i*30;
					y=y0+j*30;

					this.setImage("H1.png");
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

					this.setImage("M1.png");
					//System.out.println(3);


					g.drawImage(image, posX,posY,null);
				}
				else if(mat[i][j].equals(p.Fant)) {
					x=x0+i*30;
					y=y0+j*30;
					this.setPosX(x);
					this.setPosY(y);

					this.setImage("1.png");
					//System.out.println(3);
				


					g.drawImage(image, posX,posY,null);
				}

			}}}

	public void Dessin2(Graphics g) {

		int x=0;
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
			
				else if(mat[i][j].equals(p.heros)) {
					x=x0+i*30;
					y=y0+j*30;

					this.setImage("H2.png");
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

					this.setImage("M2.png");
					//System.out.println(3);


					g.drawImage(image, posX,posY,null);
				}
				else if(mat[i][j].equals(p.Fant)) {
					x=x0+i*30;
					y=y0+j*30;
					this.setPosX(x);
					this.setPosY(y);

					this.setImage("2.png");
					//System.out.println(3);
				


					g.drawImage(image, posX,posY,null);
				}

			}}}

	public void Dessin3(Graphics g) {

		int x=0;
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
		
				else if(mat[i][j].equals(p.heros)) {
					x=x0+i*30;
					y=y0+j*30;

					this.setImage("H3.png");
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

					this.setImage("M3.png");
					//System.out.println(3);


					g.drawImage(image, posX,posY,null);
				}
				else if(mat[i][j].equals(p.Fant)) {
					x=x0+i*30;
					y=y0+j*30;
					this.setPosX(x);
					this.setPosY(y);

					this.setImage("3.png");
					//System.out.println(3);
				


					g.drawImage(image, posX,posY,null);
				}

			}}}

	public void Dessin4(Graphics g) {

		int x=0;
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
		
				else if(mat[i][j].equals(p.heros)) {
					x=x0+i*30;
					y=y0+j*30;

					this.setImage("H4.png");
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

					this.setImage("M4.png");
					//System.out.println(3);


					g.drawImage(image, posX,posY,null);
				}
				else if(mat[i][j].equals(p.Fant)) {
					x=x0+i*30;
					y=y0+j*30;
					this.setPosX(x);
					this.setPosY(y);

					this.setImage("4.png");
					//System.out.println(3);
				


					g.drawImage(image, posX,posY,null);
				}

			}}}

	public void Dessin5(Graphics g) {

		int x=0;
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
				
				else if(mat[i][j].equals(p.heros)) {
					x=x0+i*30;
					y=y0+j*30;

					this.setImage("H5.png");
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

					this.setImage("M5.png");
					//System.out.println(3);


					g.drawImage(image, posX,posY,null);
				}
				else if(mat[i][j].equals(p.Fant)) {
					x=x0+i*30;
					y=y0+j*30;
					this.setPosX(x);
					this.setPosY(y);

					this.setImage("5.png");
					//System.out.println(3);
				


					g.drawImage(image, posX,posY,null);
				}

			}}}

	public void Dessin6(Graphics g) {

		int x=0;
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
			
				else if(mat[i][j].equals(p.heros)) {
					x=x0+i*30;
					y=y0+j*30;

					this.setImage("H6.png");
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

					this.setImage("M6.png");
					//System.out.println(3);


					g.drawImage(image, posX,posY,null);
				}
				else if(mat[i][j].equals(p.Fant)) {
					x=x0+i*30;
					y=y0+j*30;
					this.setPosX(x);
					this.setPosY(y);

					this.setImage("6.png");
					//System.out.println(3);
				


					g.drawImage(image, posX,posY,null);
				}

			}}}

	public void Dessin7(Graphics g) {

		int x=0;
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
			
				else if(mat[i][j].equals(p.heros)) {
					x=x0+i*30;
					y=y0+j*30;

					this.setImage("H7.png");
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

					this.setImage("M7.png");
					//System.out.println(3);


					g.drawImage(image, posX,posY,null);
				}
				else if(mat[i][j].equals(p.Fant)) {
					x=x0+i*30;
					y=y0+j*30;
					this.setPosX(x);
					this.setPosY(y);

					this.setImage("7.png");
					//System.out.println(3);
				


					g.drawImage(image, posX,posY,null);
				}

			}}}
	
public void Dessin_heros1(Graphics g) {
	Heros h=p.getHeros();
	int life=h.getLife();
	Vector<CaseMagique>m=h.getMagie();
	int Xmax=x0+p.n*30;
	int Ymax=y0+p.m*30;

	this.setImage("coeur.png");
	for( int i=0;i<life;i++) {
		posX=Xmax+30+i*30;
		posY=y0;

		g.drawImage(image, posX,posY,null);
		
	}

	this.setImage("arm.png");
	for(CaseMagique x:m) {
		if(x.getTypeMage()==2) {
			posX=Xmax+40+m.indexOf(x)*40;
			posY=y0+40;
			g.drawImage(image, posX,posY,null);
			
			
		}
		
	}
		
	}

public void Dessin_heros2(Graphics g) {
	Heros h=p.getHeros();
	int life=h.getLife();
	Vector<CaseMagique>m=h.getMagie();
	int Xmax=x0+p.n*30;
	int Ymax=y0+p.m*30;

	this.setImage("coeur2.png");
	for( int i=0;i<life;i++) {
		posX=Xmax+30+i*30;
		posY=y0;

		g.drawImage(image, posX,posY,null);
		
	}


	this.setImage("arm.png");
	for(CaseMagique x:m) {
		if(x.getTypeMage()==2) {
			posX=Xmax+40+m.indexOf(x)*40;
			posY=y0+40;
			g.drawImage(image, posX,posY,null);
			
			
		}
		
	}
		
		
	}

public void Dessin_heros3(Graphics g) {
	Heros h=p.getHeros();
	int life=h.getLife();
	Vector<CaseMagique>m=h.getMagie();
	int Xmax=x0+p.n*30;
	int Ymax=y0+p.m*30;

	this.setImage("coeur3.png");
	for( int i=0;i<life;i++) {
		posX=Xmax+30+i*30;
		posY=y0;

		g.drawImage(image, posX,posY,null);
		
	}


	this.setImage("arm.png");
	for(CaseMagique x:m) {
		if(x.getTypeMage()==2) {
			posX=Xmax+40+m.indexOf(x)*40;
			posY=y0+40;
			g.drawImage(image, posX,posY,null);
			
			
		}
		if(x.getTypeMage()==3) {
			this.setImage("teleportation.png");
			posX=Xmax+40+m.indexOf(x)*40;
			posY=y0+40;
			g.drawImage(image, posX,posY,null);
			
			
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