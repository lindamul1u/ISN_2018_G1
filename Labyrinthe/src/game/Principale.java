package game;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import javax.swing.JFrame;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.*;
public class Principale {

	public static void main(String[] args) {
		Plateau p=new Plateau(10,10,50);

		 JFrame frame = new JFrame("Un titre");
		    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // comportement modifiable
		    // on place ici la definition de l'arbre de composants

			frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
			//frame.setSize(1000,1000);
			
			Graphique gr=p.gr;
		    frame.add(gr); // un raccourci
		    // frame.getContentPane().add(new MonDessin()); // forme exacte
		    // ...
		    // on termine generalement ainsi
		    frame.pack();
		    frame.setVisible(true);
		    // pour l'exemple
		    System.out.println(Thread.currentThread() + " en fin de MaFenetre()");
		
			
	   Clavier c=new Clavier(p);
			frame.addKeyListener(c); 

			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			frame.setContentPane(gr);
		while(true) {

			p.Dessin();
			//System.out.println(c.Commande);
		
			//System.out.println(p);
			
		
			//System.out.println(p);
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
		p.setCommande(Commande);
		Commande='0';
	
		System.out.println(p);

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
