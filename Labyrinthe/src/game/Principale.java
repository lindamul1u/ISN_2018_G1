package game;

import java.util.Scanner;
import java.awt.Color;
import java.util.*;
public class Principale {

	public static void main(String[] args) {
		// TODO Auto-generated metho stub
		
		Plateau p=new Plateau(10,10,50);//Création du plateau (nbr ligne,colones,nbr murs obstacle)n
		//System.out.println(p);
		System.out.println(p);
		Fenetre f=new Fenetre(p);//Fenetre d'affichage
		char Commande=f.getCommande();
		
	while (true) {
		Heros h=p.getHeros();
		/*Vector<CaseMagique>vm=p.getMagie();
		Vector<Piege>vp=p.getPiege();
		System.out.print("Magique :");
		for(CaseMagique x:vm) {
			System.out.print (x+ " ");
		}
	System.out.println("");
	System.out.print("Piege :");
	for(Piege x:vp) {
		System.out.print (x+ " ");
	}
	System.out.println("");*/
		System.out.println(h);

		f.coeur("coeur.png");
		f.painMonstre("monstre.png");
		

		f.coeur("fond.png");


		f.painMonstre("chemin.png");
		p.DeplacementMonstre();
	}
	
		
		
	}
	}
