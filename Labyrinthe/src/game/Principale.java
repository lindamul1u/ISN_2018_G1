package game;

import java.util.Scanner;
import java.awt.Color;
import java.util.*;
public class Principale {

	public static void main(String[] args) {
		// TODO Auto-generated metho stub
		
		Plateau p=new Plateau(10,10,50);//Création du plateau (nbr ligne,colones,nbr murs obstacle)
		//System.out.println(p);
		System.out.println(p);
		Fenetre f=new Fenetre(p);//Fenetre d'affichage
		char Commande=f.getCommande();
		
	while (true) {
		f.painMonstre(f.getBackground());
		
	
		p.DeplacementMonstre();
		
		f.painMonstre(Color.green);

	}
	
		
		
	}
	}
