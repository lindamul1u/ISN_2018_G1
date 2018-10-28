package game;

import java.util.Scanner; 

import java.util.*;
public class Principale {

	public static void main(String[] args) {
		// TODO Auto-generated metho stub
		
		Plateau p=new Plateau(10,10,16);//Création du plateau (nbr ligne,colones,nbr murs obstacle)
		//System.out.println(p);
		
		new Fenetre(p);//Fenetre d'affichage
		System.out.println(p);
	
	
		
		
	}
	}
