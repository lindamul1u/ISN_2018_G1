package game;

import java.awt.Color;
import java.util.Vector;

public class Plateau {

	private String[][] plateau;//Matrice contenant l'information du plateau � l'instant n

	//LES ENTIERS
	private int n;//Nbr lignes
	private int  m;//Nbr colones
	private int nbrmurs;//Nbr murs
	private int nbrcaselibre;//Nbr de case o� le joueur peut se d�placer

	//Codage des objets dans la matrice
	private String mur="X";
	private String chemin="-";
	private String heros="0";
	private String tresor="T";
	private String monstre="M";
	//Les objets 
	private Tresor t;
	private Heros h;
	private Vector <Monstres> Vmonstre;
	private int[][] Voisin;
	//Communication entre le plateau et les objets
	private char Commande;
	private int arret;
	private int M=10;

	//Constructeur

	public Plateau(int n,int m,int nbrmurs) {

		if(n>2&& m>2&& nbrmurs<=(n-2)*(m-2)) {//Condition de validit� du plateau
			this.n=n;
			this.m=m;
			this.nbrmurs=nbrmurs;
			plateau=new String[n][m];
			arret=0;
			//Mise en place des murs ext�rieurs
			for(int i=0;i<n;i++) {
				for(int j=0;j<m;j++) {
					if(!appartientPlateau(i,j))// Si mur ext
						plateau[i][j]=mur;// On d�finit "X" comme �tant les murs
					else 
						plateau[i][j]=chemin;// On d�finit " " comme �tant les chemins
				}
			}

			murAleat(nbrmurs);// place nbrmurs de mani�res al�atoire sur le plateau
			ajustement();//ajustement du plateau afin de ne pas avoir de zone inaccessible par le joueur

			t=new Tresor(this);
			plateau[t.getX()][t.getY()]=tresor;//On place le tr�sore � sa place (voir classe Tresor)

			nbrcase();//Calcul le nbr de case de d�placement et les murs

			h=new Heros(this);
			ajoutHeros();//place le h�ros sur le plateau (voir H�ros)
			Vmonstre=new Vector <Monstres>();
			ajoutMonstres(M);
			

		}
		else {
			System.out.println("Probl�me de dimenssionement");
		}
		
	}
	
	/* M�thodes PRIVATE*/
	//----------------------------
	//V�rifie que le couple (x,y) n'est pas mur ext�rieur
	public boolean appartientPlateau(int x,int y) {
		if(x>0 && x<n-1 && y>0 && y<m-1) {
			return true;
		}
		return false;
	}
	//calcul les cases murs et vide
	private void nbrcase() {
		int S1=0;
		int S2=0;
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(plateau[i][j].equals(mur)) {
					S1+=1;}
				else {
					S2+=1;}
			}
		}
		this.nbrcaselibre=S2;
		this.nbrmurs=S1;
	}

	//calcul nb aleat entier entre[Min,Max[ 
	private int nbAleat(int Min,int Max) {
		return Min + (int)(Math.random() * ((Max - Min) ));
	}

	//g�nere les N murs sur le plateau de fa�on al�at
	private void murAleat(int nbrmurs) {
		int x=0;
		int y=0;
		int S=0;
		for(int i=0;i<nbrmurs;i++) {

			x=nbAleat(1,n);
			y=nbAleat(1,m);

			while(plateau[x][y].equals(mur)|| !appartientPlateau(x,y)) {// il faut que le nouveau mur soit sur le plateau et qu'il n'y ai pas de mur dej� avant

				x=nbAleat(1,n);
				y=nbAleat(1,m);

			}


			plateau[x][y]=mur;
		}
	}
	// modifie le plateau de mani�re � le rendre exploitable
	private void ajustement() {
		int[][] V1=voisin();//Matrice o� V1[i][j]= le nombre de case de d�placement dispo au voisinage de plateau[i][j]
		for(int i=1;i<n-1;i++) {
			for(int j=1;j<m-1;j++) {
				while(V1[i][j]<3) {//On consid�re qu'un plateau est ok si chaque case a au moins 3 voisins de type chemin
					supprMur(i,j);// sinon on supprime un mur de mani�re al�atoire au voisinage de la case [i][j]
					V1=voisin();//On recalcule V1
				}
			}
		}
		afficheVoisin(V1);
	}
	public boolean nombreVoisinCorrect(int[][] v,int i,int j) {
		
		if(v[i][j]<=2) {//On consid�re qu'un plateau est ok si chaque case a au moins 3 voisins de type chemin
			System.out.println(i+ " "+j+" "+v[i][j]);

			return false;
		
	
}
return true;

}
	//G�n�re la matrice adjacent o� une case compte pour voisin si celui-ci est "-"
	public int[][] voisin() {
		int[][] adj=new int[n][m];
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				int S=0;
				for(int l=-1;l<=1;l++) {
					for(int m=-1;m<=1;m++) {
						if( appartientPlateau(i+l,j+m) && plateau[i+l][j+m].equals(chemin)) {// Regarde dans les 8 directions
							S+=1;// On v�rifie que l'�lement adjacent � la case (i,j) n'est pas un mur ext�rieur (out of range) et que celui-ci est un chemin
						}
					}
				}
				if( plateau[i][j].equals(chemin)) {//Si l'�lement (i,j) est d�j� un chemin alors S a compt� (i,j) comme �tant voisin de lui m�me
					adj[i][j]=S;
					
				}
				else {
					adj[i][j]=S;
				}
			}
		}
		this.Voisin=adj;
		return adj;}
	// Supprime un mur sur une case adjacent de (i,j) de mani�re al�atoire
	private void supprMur(int i,int j) {

		int xD=nbAleat(-1,2);
		int yD=nbAleat(-1,2);// entier al�atoire entre [-1;1]
		if(appartientPlateau(i+xD,j+yD))
			plateau[i+xD][j+yD]=chemin;// L'�lement adjacent de (i,j) n'est pas un mur ext�rieur on le supprime
	}
	//Affiche la matrice adjacent 
	private void afficheVoisin(int[][] v) {
		for(int i=0;i<v.length;i++) {
			for(int j=0;j<v[0].length;j++) {
				System.out.print(v[i][j]+" ");
			}
			System.out.println("");
		}
	}
	public int[][] getVoisin() {
		return Voisin;
	}
	
	
	
	/*Methode public*/
	//---------------------
	//Methode toString()
	public String toString() {
		String S="";
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {

				S+=plateau[i][j]+" ";
			}
			S+="\n";
		}
		return S;
	}
	//Permet d'ins�rer un objt dans la matrice � partir de son code
	public void setPlateau(int i,int j,String s) {
		plateau[i][j]=s;
	}
	// LES GET
	public String[][] getPlateau(){
		return plateau;
	}
	public int getNbmur() {
		return nbrmurs;
	}
	public int getNbrchemin() {
		return nbrcaselibre;
	}
	public int getNblignes() {
		return n;
	}
	public int getcolonnes() {
		return m;
	}
	public String getMurs() {
		return mur;
	}
	public String getChemin() {
		return chemin;
	}
	public Heros getHeros() {
		return h;
	}
	public void ajoutHeros() {
		int xh=h.getX();
		int yh=h.getY();
		
		plateau[xh][yh]=heros;

	}
	public String getHerosS() {
		return heros;
	}	
	public void supprHeros() {
		plateau[h.getX()][h.getY()]=chemin;

	}	
	// Gestion de d�placement du h�ros
	public void setCommande(char c) {
		Commande=c;
		supprHeros();
		arret=h.Deplacement(Commande);
		ajoutHeros();
	}
	
	public String getMonstreStr() {
		return monstre;
	}
	public Vector<Monstres> getMonstre(){
		return Vmonstre;
	}
	public void setMonstres(int id) {
		Vector<Monstres> New=new Vector<Monstres>();
		for(int i=0;i<Vmonstre.size();i++) {
			if(Vmonstre.get(i).id!=id) {
				New.add(Vmonstre.get(i));
			}
		}
		Vmonstre=New;
		
	}
	
	private void ajoutMonstres(int M) {
	
		for(int i=0;i<(int)M/2;i++) {
			Vmonstre.add(new Monstreintel_simple(this,i));
			Monstres m2= Vmonstre.get(i);
			plateau[m2.getX()][m2.getY()]=monstre;
			
		}
		/*for(int i=(int) M/2;i<M;i++) {
			Vmonstre.add(new Monstrealea_simple(this,i));
			Monstres m=(Monstrealea_simple) Vmonstre.get(i);
			plateau[m.getX()][m.getY()]=monstre;
		}*/
	}
	private void supprMonstre(Monstres m) {
		int xm=m.getX();int ym=m.getY();
		plateau[xm][ym]=chemin;
		
	}
	public void DeplacementMonstre() {
		
		for(int i=0;i<Vmonstre.size();i++) {
			
			Monstres m=(Monstres) Vmonstre.get(i);
			supprMonstre(m);
			boolean a=m.deplacer();
			
			if(a==true) {
				System.out.println(m);
				setMonstres(m.id);
			

				System.out.println("Mort "+m+" "+m.id);
				
			}
			else {
				System.out.println("Vivant "+m);
			//Repositione le monstre de mani�re al�atoire
			int xm=m.getX();int ym=m.getY();
			plateau[xm][ym]=monstre;}
		}
		
	}
	//Permet de remplacer un �lement par un chemin(d�placement ...)
	public void remove(int i,int j) {
		if(!plateau[i][j].equals(mur)) {
			plateau[i][j]=chemin;
		}

	}
	public String getTres() {
		return tresor;
	}
	public int getArret() {
		return arret;
	}

	public void STOP() {
		arret=1;
	}
	public Tresor getTresor() {
		return this.t;
	}
}
