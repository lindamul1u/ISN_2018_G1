package game;
/*
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.sun.xml.internal.ws.api.Component;


public class Fenetre extends JFrame

	JFrame frame = new JFrame("Exemple");

	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	button3.setVisible(true);
	button2.setVisible(true);
	button1.setVisible(true);
    Box b1 = Box.createHorizontalBox();
    b1.add(button3);
    //Idem
    Box b2 = Box.createHorizontalBox();
    b2.add(button2);
    b2.add(button1);


    //On crée un conteneur avec gestion verticale
    Box b3 = Box.createVerticalBox();
    b3.add(b1);
    b3.add(b2);

    this.getContentPane().add(b3);



	frame.setSize(300, 1000);
	frame.setLocationRelativeTo(null);
	frame.setVisible(true);



}


}*/
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Test.ErreurPlateauException;

public class Fenetre extends JFrame{

	JPanel content = new JPanel();
	//Liste des noms de nos conteneurs pour la pile de cartes
	JButton button1;
	JButton button2;
	JButton button3;

	boolean debut;
	int NbMonstra_simple_intelalea;// 50/50
	int Nbpiege;
	int NbrMagique;
	int NbrFantome;
	int n,m,nbmurs;
	int life;


	public Fenetre() throws ErreurPlateauException {
		debut=false;
		Plateau p=new Plateau(0,0,0,0,40,10,0,0);
		Graphique gr=p.gr;
		this.setTitle("Elvis dans le monde des mortt");
		this.setExtendedState(JFrame.MAXIMIZED_BOTH); 	
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		try {
			this.setIconImage( ImageIO.read(new File("H1.png")));
		} catch (IOException e)  {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//On crée trois conteneurs de couleur différente


		JPanel boutonPane = new JPanel();
		life=0;


		button1 = new JButton("Niveau 1");
		button2=new JButton("Niveau 2");
		button3=new JButton("Niveau 3");
		this.debut=false;
		button1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent event) {
				System.out.println(1);
				Nbpiege=3;
				NbMonstra_simple_intelalea =1;
				NbrFantome=0;
				NbrMagique=2;
				n=10;
				m=10;
				nbmurs=50;
				life=2;
				debut=true;

			}
		});
		button2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent event) {
				System.out.println(2);

				Nbpiege=3;
				NbMonstra_simple_intelalea =2;
				NbrFantome=0;
				NbrMagique=2;
				n=10;
				m=12;
				nbmurs=30;
				life=3;
				debut=true;


			}
		});
		button3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent event) {
				System.out.println(3);

				Nbpiege=3;
				NbMonstra_simple_intelalea =2;
				NbrFantome=1;
				NbrMagique=2;
				n=12;
				m=12;
				nbmurs=10;
				life=3;
				debut=true;


			}
		});
		boutonPane.add(button1);
		boutonPane.add(button2);
		boutonPane.add(button3);
		p.setArret();
		gr.repaint();

		this.getContentPane().add(boutonPane, BorderLayout.NORTH);
		
		this.setVisible(true);
	}
	public boolean getDebut() {
		return this.debut;
	}
	public String toString() {
	
		String S="Piege "+this.Nbpiege+" NbMonstre "+this.NbMonstra_simple_intelalea+" NbFantome"+this.NbrFantome+" NbMagique "+this.NbrMagique;
		return S;
		
	}


	//On définit le layout






}
