package game;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

import javax.swing.JFrame;

public class Plateau  extends JFrame implements KeyListener  {

	private String[][] plateau;//Matrice contenant l'information du plateau à l'instant n

	private int longueur;
	private int largeur;
	private int x0;
	private int y0;
	private Graphique gr ;
	
	private int ymax=990;
	private int xmax=1890;
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

	public Plateau(int n,int m,int nbrmurs) {
		this.f=f;

		if(n>2&& m>2&& nbrmurs<=(n-2)*(m-2)) {
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
			ajoutHeros();//place le héros sur le plateau (voir Héros)
			Vmonstre=new Vector <Monstres>();
			F=new Vector <Monstres>();
			Vp=new Vector <Piege>();
			Nbpiege=3;
			NbMonstra_simple_intelalea = 0;
			this.NbrFantome=1;
			this.NbrMagique=10;
			h.setLife(5);
			ajoutPiege();
			ajoutMonstres();
			ajoutFant();
			Ma=new Vector<CaseMagique>();
			ajoutMagie(this.NbrMagique);
			attaquedistance=false;
			

		}
		else {
			System.out.println("Problème de dimenssionement");
		}
		this.setExtendedState(JFrame.MAXIMIZED_BOTH); 

		//this.setSize(1000,1000);
		this.setUndecorated(false);
		this.setVisible(true); 
		longueur=this.getHeight();
		largeur=this.getWidth();
		X0Y0();
		gr=new Graphique(Color.red);
		gr.setPosX(x0);
		gr.setPosY(y0);
	
   
		this.addKeyListener(this); 

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setContentPane(gr);
		
		go();
		
		

	}
	private void go(){
		//fond();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	

		int x=0;
		int y=0;
		String[][] mat=this.plateau;
		
			for(int j=0;j<m;j++) {
				for(int i = 0; i < n; i++){
				if(mat[i][j].equals(this.mur)) {
					x=x0+i*30;
					y=y0+j*30;
					gr.setImage("mur.png");
					gr.setPosX(x);
					gr.setPosY(y);
					gr.repaint();
					try {
						Thread.sleep(4);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

				}
				else if(mat[i][j].equals(this.chemin)) {
					x=x0+i*30;
					y=y0+j*30;
					
					gr.setImage("chemin.png");
					gr.setPosX(x);
					gr.setPosY(y);
					gr.repaint();
					try {
						Thread.sleep(4);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

		
				}
				else if(mat[i][j].equals(this.heros)) {
					x=x0+i*30;
					y=y0+j*30;
					
					gr.setImage("heros.png");
					gr.setPosX(x);
					gr.setPosY(y);
					gr.repaint();
					try {
						Thread.sleep(4);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

			
				}
				else if(mat[i][j].equals(this.tresor)) {
					x=x0+i*30;
					y=y0+j*30;
					
					gr.setImage("tresor.png");
					gr.setPosX(x);
					gr.setPosY(y);
					gr.repaint();
					try {
						Thread.sleep(4);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

				
				}
				else if(mat[i][j].equals(this.piege)) {
					x=x0+i*30;
					y=y0+j*30;
					
					gr.setImage("piege.png");
					gr.setPosX(x);
					gr.setPosY(y);
					gr.repaint();
					try {
						Thread.sleep(4);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

					
		
				
			}
				else if(mat[i][j].equals(this.Magie)) {
					x=x0+i*30;
					y=y0+j*30;
					
					gr.setImage("Magique.png");
					gr.setPosX(x);
					gr.setPosY(y);
					gr.repaint();
					try {
						Thread.sleep(4);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

				}
				}
				}
			

//fond();
		
		//System.out.println(p);
	}
public void X0Y0() {


	this.x0=(1890-30*n)/2;
	this.y0=(990-30*m)/2;
	
}
public void fond() {
	for(int i=0;i<=xmax/30;i++) {
		for(int j=0;j<=ymax/30;j++) {
			
				int x=i*30;
				int y=j*30;
				gr.setImage("fond.png");
				gr.setPosX(x);
				gr.setPosY(y);
				gr.repaint();

				try {
					Thread.sleep(4);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				
			
		}
		
	}
	for(int i=0;i<=4;i++) {
		for(int j=0;j<=ymax/30;j++) {
			
				int x=i*30;
				int y=j*30;
				gr.setImage("fond.png");
				gr.setPosX(x);
				gr.setPosY(y);
				gr.repaint();

				try {
					Thread.sleep(4);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				
			
		}
		
	}
}
public void coeur(String s) {


	for(int i=0;i<=h.getLife();i++) {
		
		int x=x0+(n+i)*30+30;
		int y=y0;
		gr.setImage(s);
		gr.setPosX(x);
		gr.setPosY(y);
		gr.repaint();
		try {
			Thread.sleep(4);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}


	}
	
}
	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub

		Commande=arg0.getKeyChar();
		depainHeros();


	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		//System.out.println(p);

		

	
		setCommande(Commande);
		painHeros();

		}
	

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}
	public char getCommande() {
		return Commande;
	}
	public void painMonstre(String s) {

		for(Monstres x:Vmonstre) {
			
			int xm=x.getX();
			int ym=x.getY();
			xm=xm*30+x0;
			ym=ym*30+y0;
			gr.setImage(s);
			gr.setPosX(xm);
			gr.setPosY(ym);
			gr.repaint();

			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	
		}
		
		
		
		
	}
	public void painFant(Fantome f,String s) {
		

			int xm=f.getX();
			int ym=f.getY();
			xm=xm*30+x0;
			ym=ym*30+y0;
			gr.setImage(s);
			gr.setPosX(xm);
			gr.setPosY(ym);
			gr.repaint();

			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	
		
		
		
		
		
	}
	public void depainHeros() {
		
		int xh=h.getX();
		int yh=h.getY();
	
		xh=xh*30+x0;
		yh=yh*30+y0;
		
		gr.setImage("chemin.png");
		gr.setPosX(xh);
		gr.setPosY(yh);
		gr.repaint();
		
	
		if(getArret()==1) {
			gr.setArret(1);
			gr.repaint();
			}
		
		
	}
	
public void painHeros() {
		
		int xh=h.getX();
		int yh=h.getY();
	
		xh=xh*30+x0;
		yh=yh*30+y0;
		

		gr.setImage("heros.png");
		gr.setPosX(xh);
		gr.setPosY(yh);
		gr.repaint();
		
	
		if(getArret()==1) {
			gr.setArret(1);
			gr.repaint();
			}
		
		
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

			while(plateau[x][y].equals(mur)|| !appartientPlateau(x,y)) {// il faut que le nouveau mur soit sur le plateau et qu'il n'y ai pas de mur dejà avant

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
				while(V1[i][j]<3) {//On considère qu'un plateau est ok si chaque case a au moins 3 voisins de type chemin
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
		// TODO Auto-generated method stub
		for(int i=0;i<(int)this.NbrFantome;i++) {
			F.add(new Fantome(this,i));
			Monstres m= F.get(i);
			plateau[m.getX()][m.getY()]=this.Fant;
			
		}
	}
	private void ajoutMonstres() {
	
		for(int i=0;i<(int)this.NbMonstra_simple_intelalea/2;i++) {
			Vmonstre.add(new Monstreintel_simple(this,i));
			Monstres m2= Vmonstre.get(i);
			plateau[m2.getX()][m2.getY()]=monstre;
			
		}
		for(int i=(int) this.NbMonstra_simple_intelalea/2;i<this.NbMonstra_simple_intelalea;i++) {
			Vmonstre.add(new Monstrealea_simple(this,i));
			Monstres m=(Monstrealea_simple) Vmonstre.get(i);
			plateau[m.getX()][m.getY()]=monstre;
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
			

			painFant(m,"mur.png");
		}
		else {
			plateau[xm][ym]=this.chemin;

			painFant(m,"chemin.png");
		}
		
		
	}
	public void DeplacementMonstre() {
		
		for(int i=0;i<Vmonstre.size();i++) {
			
			Monstres m=(Monstres) Vmonstre.get(i);
			supprMonstre(m);
			boolean a=m.deplacer();
			
			if(a==true) {
				
				this.setFantome(m.id);
			

				System.out.println("Mort "+m+" "+m.id);
				
			}
	
			else {
			//Repositione le monstre de manière aléatoire
			int xm=m.getX();int ym=m.getY();
			plateau[xm][ym]=monstre;}
		}
		
	}
	public void DeplacementFant() {
		
		for(int i=0;i<F.size();i++) {
			
			Fantome m=(Fantome) F.get(i);
			int x=m.getX();
			int y=m.getY();
			this.supprFantome(m);
			
			boolean a=m.deplacer();
			painFant(m,"monstre1.png");
			painFant(m,"monstre2.png");
			painFant(m,"monstre3.png");

			if(a==true) {
				
				this.setFantome(m.id);
				this.supprFantome(m);
			

				System.out.println("Mort "+m+" "+m.id);
				
			}
	
			else {
			//Repositione le monstre de manière aléatoire
			int xm=m.getX();int ym=m.getY();
			plateau[xm][ym]=this.Fant;}
			
			
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
