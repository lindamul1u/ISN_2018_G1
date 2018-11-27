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

	
		/*
		f.painHeros2("monstre1.png");
		f.depainHeros();
		f.painHeros2("monstre2.png");
*/
		p.DeplacementMonstre();
		p.DeplacementFant();
	}
	}
	}
