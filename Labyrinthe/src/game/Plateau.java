package game;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

import javax.swing.JFrame;

import Test.ErreurPlateauException;

public class Plateau     {

	private String[][] plateau;//Matrice contenant l'information du plateau à l'instant n

	private int longueur;
	private int largeur;
	int x0;
	int y0;
	Graphique gr ;

	int ymax=990;
	int xmax=1890;
	//LES ENTIERS
	int n;//Nbr lignes
	int  m;//Nbr colones
	int nbrmurs;//Nbr murs
	int nbrcaselibre;//Nbr de case où le joueur peut se déplacer
	private Fenetre f;
	//Codage des objets dans la matrice
	public final String mur="X";
	public final String chemin="-";
	public final String heros="0";
	public final String tresor="T";
	public final String monstre="M";
	public final String Fant="F";
	public final String piege="P";
	public final String Magie="Ma";
	//Les objets 
	private Tresor t;
	private Heros h;
	private Vector <Monstres> Vmonstre;
	private Vector<Piege> Vp;
	private Vector<CaseMagique> Ma;
	private Vector<Monstres>F;
	private int[][] Voisin;
	//Communication entre le plateau et les objets
	private char Commande;
	private int arret;
	int NbMonstra_simple_intelalea;// 50/50
	int Nbpiege;
	int NbrMagique;
	int NbrFantome;
	private boolean attaquedistance;
	//Constructeur

	public Plateau(int NbMo,int NbMa,int NbF,int NbP,int n,int m,int nbrmurs,int life) throws ErreurPlateauException {
		this.f=f;

		//Condition de validité du plateau
		this.n=n;
		this.m=m;
		this.nbrmurs=nbrmurs;
		plateau=new String[n][m];
		arret=0;
		//Mise en place des murs extérieurs
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(!appartientPlateau(i,j))// Si mur ext
					plateau[i][j]=mur;// On définit "X" comme étant les murs
				else 
					plateau[i][j]=chemin;// On définit " " comme étant les chemins
			}
		}

		murAleat(nbrmurs);// place nbrmurs de manières aléatoire sur le plateau
		ajustement();//ajustement du plateau afin de ne pas avoir de zone inaccessible par le joueur

		t=new Tresor(this);
		plateau[t.getX()][t.getY()]=tresor;//On place le trésore à sa place (voir classe Tresor)

		nbrcase();//Calcul le nbr de case de déplacement et les murs

		h=new Heros(this);

		Vmonstre=new Vector <Monstres>();
		F=new Vector <Monstres>();
		Vp=new Vector <Piege>();
		
		this.NbMonstra_simple_intelalea=NbMo;
		this.Nbpiege=NbP;
		this.NbrFantome=NbF;
		this.NbrMagique=NbMa;

		h.setLife(life);
		ajoutHeros();//place le héros sur le plateau (voir Héros)
		ajoutPiege();
		ajoutMonstres();
		ajoutFant();
		Ma=new Vector<CaseMagique>();
		ajoutMagie(this.NbrMagique);
		attaquedistance=false;


		gr=new Graphique(Color.red,this);


	}

	//fond();

	//System.out.println(p);
	public void setArret() {
		this.arret=0;
	}

	public String[][] copie(){
		String[][] Pl=new String[n][m];
		for(int i=0;i<plateau.length;i++) {
			for(int j=0;j<plateau.length;j++) {
				Pl[i][j]=plateau[i][j];
			}
		}
		return Pl;
	}

	public boolean Dessin() {

		this.DeplacementFant();
		this.DeplacementMonstre();



		return true;

	}
	public Graphique getGraph() {
		return gr;
	}


	/* Méthodes PRIVATE*/
	//----------------------------
	//Vérifie que le couple (x,y) n'est pas mur extérieur
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

	//génere les N murs sur le plateau de façon aléat
	private void murAleat(int nbrmurs) {
		int x=0;
		int y=0;
		int S=0;
		for(int i=0;i<nbrmurs;i++) {

			x=nbAleat(1,n);
			y=nbAleat(1,m);

			while(!appartientPlateau(x,y) || plateau[x][y].equals(mur)) {// il faut que le nouveau mur soit sur le plateau et qu'il n'y ai pas de mur dejà avant

				x=nbAleat(1,n);
				y=nbAleat(1,m);

			}


			plateau[x][y]=mur;
		}
	}
	// modifie le plateau de manière à le rendre exploitable
	private void ajustement() {
		int[][] V1=voisin();//Matrice où V1[i][j]= le nombre de case de déplacement dispo au voisinage de plateau[i][j]
		for(int i=1;i<n-1;i++) {
			for(int j=1;j<m-1;j++) {
				while(V1[i][j]<=3) {//On considère qu'un plateau est ok si chaque case a au moins 3 voisins de type chemin
					supprMur(i,j);// sinon on supprime un mur de manière aléatoire au voisinage de la case [i][j]
					V1=voisin();//On recalcule V1
				}
			}
		}
		afficheVoisin(V1);
	}
	public boolean nombreVoisinCorrect(int[][] v,int i,int j) {

		if(v[i][j]<=2) {//On considère qu'un plateau est ok si chaque case a au moins 3 voisins de type chemin


			return false;


		}
		return true;

	}
	//Génère la matrice adjacent où une case compte pour voisin si celui-ci est "-"
	public int[][] voisin() {
		int[][] adj=new int[n][m];
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				int S=0;
				for(int l=-1;l<=1;l++) {
					for(int m=-1;m<=1;m++) {
						if( appartientPlateau(i+l,j+m) && plateau[i+l][j+m].equals(chemin)) {// Regarde dans les 8 directions
							S+=1;// On vérifie que l'élement adjacent à la case (i,j) n'est pas un mur extérieur (out of range) et que celui-ci est un chemin
						}
					}
				}
				if( plateau[i][j].equals(chemin)) {//Si l'élement (i,j) est déjà un chemin alors S a compté (i,j) comme étant voisin de lui même
					adj[i][j]=S;

				}
				else {
					adj[i][j]=S;
				}
			}
		}
		this.Voisin=adj;
		return adj;}
	// Supprime un mur sur une case adjacent de (i,j) de manière aléatoire
	private void supprMur(int i,int j) {

		int xD=nbAleat(-1,2);
		int yD=nbAleat(-1,2);// entier aléatoire entre [-1;1]
		if(appartientPlateau(i+xD,j+yD))
			plateau[i+xD][j+yD]=chemin;// L'élement adjacent de (i,j) n'est pas un mur extérieur on le supprime
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
	//Permet d'insérer un objt dans la matrice à partir de son code
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
	// Gestion de déplacement du héros
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
	public void setFantome(int id) {
		Vector<Monstres> New=new Vector<Monstres>();
		for(int i=0;i<F.size();i++) {
			if(F.get(i).id!=id) {
				New.add(F.get(i));
			}
		}
		F=New;

	}

	private void ajoutFant() {

		if(this.NbrFantome>1) {
		// TODO Auto-generated method stub
		for(int i=0;i<(int)this.NbrFantome/2;i++) {
			

		}

		for(int i=(int)this.NbrFantome/2; i<this.NbrFantome;i++) {
			F.add(new Fantome_aleat(this,i));
			Monstres m= F.get(i);
			plateau[m.getX()][m.getY()]=this.Fant;

		}
		}
		else if(this.NbrFantome==1) {
			F.add(new Fantome_intel(this,0));
			Monstres m= F.get(0);
			plateau[m.getX()][m.getY()]=this.Fant;
		}
	}
	private void ajoutMonstres() {
		if(this.NbMonstra_simple_intelalea>1) {
		for(int i=0;i<(int)this.NbMonstra_simple_intelalea/2;i++) {
			Vmonstre.add(new Monstreintel_simple(this,i));
			Monstres m2= Vmonstre.get(i);
			plateau[m2.getX()][m2.getY()]=monstre;

		}
		
		for(int i=(int) this.NbMonstra_simple_intelalea/2;i<this.NbMonstra_simple_intelalea;i++) {
			Vmonstre.add(new Monstrealea_simple(this,i));
			Monstres m=(Monstrealea_simple) Vmonstre.get(i);
			plateau[m.getX()][m.getY()]=monstre;
			//System.out.println(m);
		}
		
		}
		else if(this.NbMonstra_simple_intelalea==1) {
			Vmonstre.add(new Monstreintel_simple(this,0));
			Monstres m2= Vmonstre.get(0);
			plateau[m2.getX()][m2.getY()]=monstre;
		}
	}
	public void supprMonstre(Monstres m) {
		int xm=m.getX();int ym=m.getY();
		plateau[xm][ym]=chemin;

	}
	public Monstres getMonstre_xy(int x,int y) {
		for(Monstres v:Vmonstre) {
			if(v.getX()==x&& v.getY()==y) {
				return v;
			}
		}
		return null;

	}
	public void supprFantome(Fantome m) {
		int xm=m.getX();int ym=m.getY();
		if(m.getBoolMur()==true) {
			plateau[xm][ym]=this.mur;


		}
		else {
			plateau[xm][ym]=this.chemin;

		}


	}
	public void DeplacementMonstre() {


		for(int i=0;i<Vmonstre.size();i++) {

			Monstres m=(Monstres) Vmonstre.get(i);
			supprMonstre(m);
			boolean a=m.deplacer();

			if(a==true) {

				this.setMonstres(m.id);



			}

			else {
				//Repositione le monstre de manière aléatoire
				int xm=m.getX();int ym=m.getY();
				plateau[xm][ym]=monstre;}
			//System.out.println(" M "+m);

		}

	}
	public void DeplacementFant() {

		for(int i=0;i<F.size();i++) {

			Fantome m=(Fantome) F.get(i);
			int x=m.getX();
			int y=m.getY();
			this.supprFantome(m);

			boolean a=m.deplacer();

			if(a==true) {
				System.out.println("F mort!!!");

				this.setFantome(m.id);
				this.supprFantome(m);



			}

			else {
				//Repositione le monstre de manière aléatoire
				int xm=m.getX();int ym=m.getY();
				plateau[xm][ym]=this.Fant;}
			System.out.println(m);
			//System.out.println(this);
			//System.out.println(" F "+m);






		}


	}
	//Permet de remplacer un élement par un chemin(déplacement ...)
	public void remove(int i,int j) {
		if(!plateau[i][j].equals(mur)) {
			plateau[i][j]=chemin;
		}

	}
	public Vector<Monstres> getFantome(){
		return this.F;
	}

	public String getTres() {
		return tresor;
	}
	public int getArret() {
		return arret;
	}

	public void STOP() {
		//System.out.println(this);
		System.out.println(arret);
		arret=1;
	}
	public Tresor getTresor() {
		return this.t;
	}


	// Piège

	private void ajoutPiege() {
		for(int i=0;i<Nbpiege;i++) {
			Piege pi=new Piege(this,i);
			Vp.add(pi);
			this.setPlateau(pi.getX(), pi.getY(), piege);
		}

	}
	public void removePiege(Piege P) {
		this.setPlateau(P.getX(), P.getY(), this.chemin);
		for(int i=0;i<Vp.size();i++) {
			Piege pi=Vp.get(i);
			if(pi.getX()==P.getX() && pi.getY()==P.getY()) {
				Vp.remove(i);

				this.setPlateau(pi.getX(), pi.getY(), this.chemin);

			}}

	}
	public Piege recherchePiege(int x,int y) {
		for(int i=0;i<Vp.size();i++) {
			Piege pi=Vp.get(i);
			if(pi.getX()==x && pi.getY()==y) {
				return pi;

			}
		}
		return null;

	}
	public Vector<Piege> getPiege() {
		return Vp;
	}
	private void ajoutMagie(int N) {
		// TODO Auto-generated method stub
		for(int i=0;i<N;i++) {
			CaseMagique m=new CaseMagique(this,i);
			Ma.add(m);
			this.setPlateau(m.GetX(), m.GetY(),this.Magie );
		}

	}
	public Vector<CaseMagique>getMagie(){
		return Ma;
	}
	public void removeMagie(CaseMagique m) {
		this.setPlateau(m.GetX(), m.GetY(), this.chemin);
		for(int i=0;i<Ma.size();i++) {
			CaseMagique M=Ma.get(i);
			if(M.GetX()==m.GetX() && M.GetY()==m.GetY()) {
				Ma.remove(i);

				this.setPlateau(m.GetX(), m.GetY(), this.chemin);

			}
		}
	}
	public CaseMagique rechercheMagie(int x,int y) {
		for(int i=0;i<Ma.size();i++) {
			CaseMagique m=Ma.get(i);
			if(m.GetX()==x && m.GetY()==y) {
				return m;

			}
		}
		return null;

	}

}
