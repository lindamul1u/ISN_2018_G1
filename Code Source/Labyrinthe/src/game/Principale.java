package game;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

import Test.ErreurPlateauException;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import java.util.*;
public class Principale {
	static Plateau p;
	public static void main(String[] args) throws ErreurPlateauException {
		
		Intro();
		
	
	}
	static JFrame frame = new JFrame("Elvis dans le monde des mort");

	public static void Game() throws ErreurPlateauException {
	
		//System.out.println(p);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		//frame.setSize(1000,1000);
		Graphique gr=p.gr;
		frame.add(gr); 
		frame.pack();
		frame.setVisible(true);
		
		try {
			frame.setIconImage(ImageIO.read(new File("H1.png")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Clavier c=new Clavier(p);
		frame.addKeyListener(c); 

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.setContentPane(gr);

		while(p.getArret()==0) {
			//System.out.println(gr);
			p.Dessin();
			
			
		//	System.out.println(p);
			

				int N=gr.GetN();
				while(gr.GetN()!=1) {
				gr.repaint();
				//System.out.println(gr);

				
				}
				N=gr.GetN();

				while(gr.GetN()!=2 && p.getArret()==0) {
				gr.repaint();
				//System.out.println(gr);

				
				}
				N=gr.GetN();

				while(gr.GetN()!=3&& p.getArret()==0) {
				gr.repaint();
				//System.out.println(gr);

				
				}
				N=gr.GetN();

				while(gr.GetN()!=4&& p.getArret()==0) {
				gr.repaint();
				//System.out.println(gr);

				
				}
				N=gr.GetN();

				while(gr.GetN()!=5&& p.getArret()==0) {
				gr.repaint();
				//System.out.println(gr);

				
				}
				N=gr.GetN();

				while(gr.GetN()!=6&& p.getArret()==0) {
				gr.repaint();
				//System.out.println(gr);

				
				}
				N=gr.GetN();

				while(gr.GetN()!=0&& p.getArret()==0) {
				gr.repaint();

				}

		}
		System.out.println("Fin");
		
		
		gr.repaint();
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		Intro();
	

	}
	public static void Intro() throws ErreurPlateauException {
		Fenetre f=new Fenetre();
		Fond fond=new Fond();
		f.getContentPane().add(fond, BorderLayout.CENTER);
		frame.setVisible(false); //you can't see me!
		frame.dispose();
		f.isVisible();
		f.setVisible(true);
		boolean D=f.debut;
		while(!D) {
			while(fond.N!=1) {
				fond.repaint();
			}
			while(fond.N!=0) {
				fond.repaint();
			}
			D=f.getDebut();
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//System.out.println(D);
			
		}
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println(D);
		f.setVisible(false); //you can't see me!
		f.dispose();
		if(f.debut) {
			
			System.out.println(f);
			p=new Plateau(f.NbMonstra_simple_intelalea,f.NbrMagique,f.NbrFantome,f.Nbpiege,f.n,f.m,f.nbmurs,f.life);
			//System.out.println(p);
			Game();

		}
		
	}


}


class Clavier implements KeyListener{
	char Commande;
	Plateau p;
	Clavier(Plateau p){
		this.p=p;

	}
	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub

		Commande=arg0.getKeyChar();
		//System.out.println(p);
		p.setCommande(Commande);
		p.Dessin();
		//System.out.println(p);
		

		Commande='0';

		//	System.out.println(p);

	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		//System.out.println(p);







	}


	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub


	}

}




