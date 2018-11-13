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
	public Fenetre(Plateau p){     
	
		this.p=p;
		this.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		//this.setSize(500,500);
		this.setUndecorated(false);
		this.setVisible(true); 
		longueur=this.getHeight();
		largeur=this.getWidth();
		 x0=50;
		 y0=50;
		gr=new Graphique(Color.red);
		gr.setPosX(x0);
		gr.setPosY(y0);
	
   
		this.addKeyListener(this); 

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setContentPane(gr);
	
		
		go();
		
		

	}
	private void go(){
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
					x=x0+i*10;
					y=y0+j*10;
					gr.setCol(Color.red);
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
					x=x0+i*10;
					y=y0+j*10;
					
					gr.setCol(Color.blue);
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
					x=x0+i*10;
					y=y0+j*10;
					
					gr.setCol(Color.yellow);
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
		//System.out.println(p);
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
		depainHeros();
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
	public void painMonstre(Color c) {
		Vector<Monstres>Vmonstre=p.getMonstre();
		for(Monstres x:Vmonstre) {
			
			int xm=x.getX();
			int ym=x.getY();
			xm=xm*10+x0;
			ym=ym*10+y0;
			gr.setCol(c);
			gr.setPosX(xm);
			gr.setPosY(ym);
			gr.repaint();

			try {
				Thread.sleep(100/(p.getMonstre().size())^2);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	
		}
		
	}
	public void depainHeros() {
		
		int xh=p.getHeros().getX();
		int yh=p.getHeros().getY();
	
		xh=xh*10+x0;
		yh=yh*10+y0;
		

		gr.setCol(this.getBackground());
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
		System.out.println(xh+" "+yh);
		xh=xh*10+x0;
		yh=yh*10+y0;
		

		gr.setCol(Color.blue);
		gr.setPosX(xh);
		gr.setPosY(yh);
		gr.repaint();
		
	
		if(p.getArret()==1) {
			gr.setArret(1);
			gr.repaint();
			}
		
		
	}
	
		
	
}
