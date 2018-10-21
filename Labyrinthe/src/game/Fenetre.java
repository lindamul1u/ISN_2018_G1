package game;

import java.awt.TextArea;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


import javax.swing.*;

import  java.awt.*;
public class Fenetre extends JFrame implements KeyListener{
	private Graphique gr ;
	private JPanel pan;
	private TextArea area;
	private Plateau p;
	private char Commande;

	int x0=50;
	int y0=50;
	public Fenetre(Plateau p){     
		pan=new JPanel();
		this.p=p;
		gr=new Graphique(Color.red);
	
        area=new TextArea();  
		area.addKeyListener(this); 
	area.setBounds(100,100,10,10);
		gr.add(area);
		this.setSize(300, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setContentPane(gr);
		this.setVisible(true);
		this.setSize(1080, 720);
		setVisible(true);  
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
			}


		}
		//System.out.println(p);
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub

		Commande=arg0.getKeyChar();
		int xh=p.getHeros().getX();
		int yh=p.getHeros().getY();
		xh=xh*10+x0;
		yh=yh*10+y0;
		gr.setCol(this.getBackground());
		gr.setPosX(xh);
		gr.setPosY(yh);
		gr.repaint();
		try {
			Thread.sleep(20);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		


	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		//System.out.println(p);
		Commande=arg0.getKeyChar();
		p.setCommande(Commande);
		int xh=p.getHeros().getX();
		int yh=p.getHeros().getY();
		System.out.println(xh+" "+yh);
		xh=xh*10+x0;
		yh=yh*10+y0;
		String[][] mat=p.getPlateau();

		gr.setCol(Color.blue);
		gr.setPosX(xh);
		gr.setPosY(yh);
		gr.repaint();}
	

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}
	public char getCommande() {
		return Commande;
	}
}
