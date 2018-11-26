package game;

import java.awt.TextArea;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

import javax.swing.*;

import  java.awt.*;
public class Fenetre extends JFrame implements KeyListener{
	private Graphique gr ;
	
	private Plateau p;
	private char Commande;
	private int longueur;
	private int largeur;
	private int x0;
	private int y0;
	
	private int ymax=990;
	private int xmax=1890;
	//dim =30
	public Fenetre(Plateau p){     
	
		this.p=p;
		this.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		
		//this.setSize(500,500);
		this.setUndecorated(false);
		this.setVisible(true); 
		longueur=this.getHeight();
		largeur=this.getWidth();
		X0Y0();
		gr=new Graphique(Color.red);
		gr.setPosX(x0);
		gr.setPosY(y0);
	
   
		this.addKeyListener(this); 

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setContentPane(gr);
		
		go();
		
		

	}
	private void go(){
		//fond();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		int n=p.getNblignes();
		int m=p.getcolonnes();

		int x=0;
		int y=0;
		String[][] mat=p.getPlateau();
		
			for(int j=0;j<m;j++) {
				for(int i = 0; i < n; i++){
				if(mat[i][j].equals(p.getMurs())) {
					x=x0+i*30;
					y=y0+j*30;
					gr.setImage("mur.png");
					gr.setPosX(x);
					gr.setPosY(y);
					gr.repaint();

					try {
						Thread.sleep(30);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				else if(mat[i][j].equals(p.chemin)) {
					x=x0+i*30;
					y=y0+j*30;
					
					gr.setImage("chemin.png");
					gr.setPosX(x);
					gr.setPosY(y);
					gr.repaint();

					try {
						Thread.sleep(30);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				else if(mat[i][j].equals(p.getHerosS())) {
					x=x0+i*30;
					y=y0+j*30;
					
					gr.setImage("heros.png");
					gr.setPosX(x);
					gr.setPosY(y);
					gr.repaint();

					try {
						Thread.sleep(30);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				else if(mat[i][j].equals(p.getTres())) {
					x=x0+i*30;
					y=y0+j*30;
					
					gr.setImage("tresor.png");
					gr.setPosX(x);
					gr.setPosY(y);
					gr.repaint();

					try {
						Thread.sleep(30);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				else if(mat[i][j].equals(p.piege)) {
					x=x0+i*30;
					y=y0+j*30;
					
					gr.setImage("piege.png");
					gr.setPosX(x);
					gr.setPosY(y);
					gr.repaint();

					try {
						Thread.sleep(30);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
		
				
			}
				else if(mat[i][j].equals(p.Magie)) {
					x=x0+i*30;
					y=y0+j*30;
					
					gr.setImage("Magique.png");
					gr.setPosX(x);
					gr.setPosY(y);
					gr.repaint();

					try {
						Thread.sleep(30);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				}
				}
			

//fond();
		
		//System.out.println(p);
	}
public void X0Y0() {
	int n=p.getNblignes();
	int m=p.getcolonnes();

	this.x0=(1890-30*n)/2;
	this.y0=(990-30*m)/2;
	
}
public void fond() {
	for(int i=0;i<=xmax/30;i++) {
		for(int j=0;j<=ymax/30;j++) {
			
				int x=i*30;
				int y=j*30;
				gr.setImage("fond.png");
				gr.setPosX(x);
				gr.setPosY(y);
				gr.repaint();

				try {
					Thread.sleep(4);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				
			
		}
		
	}
	for(int i=0;i<=4;i++) {
		for(int j=0;j<=ymax/30;j++) {
			
				int x=i*30;
				int y=j*30;
				gr.setImage("fond.png");
				gr.setPosX(x);
				gr.setPosY(y);
				gr.repaint();

				try {
					Thread.sleep(4);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				
			
		}
		
	}
}
public void coeur(String s) {
	Heros h=p.getHeros();
	int n=p.getNblignes();
	int m=p.getcolonnes();

	for(int i=0;i<=h.getLife();i++) {
		
		int x=x0+(n+i)*30+30;
		int y=y0;
		gr.setImage(s);
		gr.setPosX(x);
		gr.setPosY(y);
		gr.repaint();
		try {
			Thread.sleep(4);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}


	}
	
}
	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub

		Commande=arg0.getKeyChar();
		depainHeros();


	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		//System.out.println(p);

		

	
		p.setCommande(Commande);
		painHeros();

		}
	

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}
	public char getCommande() {
		return Commande;
	}
	public void painMonstre(String s) {
		Vector<Monstres>Vmonstre=p.getMonstre();
		for(Monstres x:Vmonstre) {
			
			int xm=x.getX();
			int ym=x.getY();
			xm=xm*30+x0;
			ym=ym*30+y0;
			gr.setImage(s);
			gr.setPosX(xm);
			gr.setPosY(ym);
			gr.repaint();

			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	
		}
		
		
		
		
	}
	public void depainHeros() {
		
		int xh=p.getHeros().getX();
		int yh=p.getHeros().getY();
	
		xh=xh*30+x0;
		yh=yh*30+y0;
		
		gr.setImage("chemin.png");
		gr.setPosX(xh);
		gr.setPosY(yh);
		gr.repaint();
		
	
		if(p.getArret()==1) {
			gr.setArret(1);
			gr.repaint();
			}
		
		
	}
	
public void painHeros() {
		
		int xh=p.getHeros().getX();
		int yh=p.getHeros().getY();
	
		xh=xh*30+x0;
		yh=yh*30+y0;
		

		gr.setImage("heros.png");
		gr.setPosX(xh);
		gr.setPosY(yh);
		gr.repaint();
		
	
		if(p.getArret()==1) {
			gr.setArret(1);
			gr.repaint();
			}
		
		
	}
public void painHeros2(String s) {
	
	int xh=p.getHeros().getX();
	int yh=p.getHeros().getY();

	xh=xh*30+x0;
	yh=yh*30+y0;
	

	gr.setImage(s);
	gr.setPosX(xh);
	gr.setPosY(yh);
	gr.repaint();
	

	if(p.getArret()==1) {
		gr.setArret(1);
		gr.repaint();
		}
	try {
		Thread.sleep(200);
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
	
}
		
	
}
