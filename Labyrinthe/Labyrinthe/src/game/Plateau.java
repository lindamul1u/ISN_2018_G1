package game;

public class Plateau {
	private String[][] plateau;
	private int n;
	private int  m;
	private int nbrmurs;
	private int nbrcaselibre;
	private String mur="X";
	private String chemin="-";
	private String heros="0";
	private String tresor="T";
	private Tresor t;
	private Heros h;
	private char Commande;
	

	public Plateau(int n,int m,int nbrmurs) {
		this.n=n;
		this.m=m;
		
		this.nbrmurs=nbrmurs;
		plateau=new String[n][m];

		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(!appartientPlateau(i,j))// Si mur ext
					plateau[i][j]=mur;// On définit "X" comme étant les murs
				else 
					plateau[i][j]=chemin;// On définit " " comme étant les chemins
			}
		}
		murAleat(nbrmurs);// génere les murs aléat
		System.out.println(toString());
		t=new Tresor(this);
		ajustement();
		nbrcase();
		h=new Heros(this);
		ajoutHeros();
	}
	//Vérifie que le couple (x,y) n'est pas mur ext
	private boolean appartientPlateau(int x,int y) {
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


			plateau[x][y]="X";
		}
	}

	//Génère la matrice adjacent où une case compte pour voisin si celui-ci est "-"
	private int[][] voisin() {
		int[][] adj=new int[n][m];
		//System.out.println(toString());
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				int S=0;
				for(int l=-1;l<=1;l++) {
					for(int m=-1;m<=1;m++) {
						if( appartientPlateau(i+l,j+m) && plateau[i+l][j+m].equals(chemin)) {// Regarde dans les 8 directions
							S+=1;
						}
					}
				}
				if( plateau[i][j].equals(chemin)) {
					adj[i][j]=S-1;
				}
				else {
					adj[i][j]=S;
				}
			}

		}
		return adj;}
	// Supprime un mur sur une case adjacent de (i,j) de manière aléatoire
	private void supprMur(int i,int j) {


		//System.out.println(i+" "+j);

		int xD=nbAleat(-1,2);
		int yD=nbAleat(-1,2);
		if(xD!=0) {
			xD=xD/Math.abs(xD);
		}
		if(yD!=0) {
			yD=yD/Math.abs(yD);
		}

		//System.out.println(xD +" "+yD);
		//System.out.println(toString());
		if(appartientPlateau(i+xD,j+yD))
			plateau[i+xD][j+yD]=chemin;
	}
	// modifie le plateau de manière à le rendre exploitable
	private void ajustement() {

		int[][] V1=voisin();
	

		for(int i=1;i<n-1;i++) {
			for(int j=1;j<m-1;j++) {
				while(V1[i][j]<3) {//On considère qu'un plateau est ok si chaque case a 3 voisins " "
					supprMur(i,j);
					V1=voisin();
				}
			}

		}

	

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
	public void setPlateau(int i,int j,String s) {
		plateau[i][j]=s;
	}
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
		System.out.println(h);
		plateau[xh][yh]=heros;
		
	}
	public String getHerosS() {
		return heros;
	}
	public void supprHeros() {
		plateau[h.getX()][h.getY()]=chemin;
				
	}
	public void setCommande(char c) {
		Commande=c;
		supprHeros();
		h.Deplacement(Commande);
		ajoutHeros();
		
		
	}
	public void remove(int i,int j) {
		if(!plateau[i][j].equals(mur)) {
			plateau[i][j]=chemin;
		}
		
	}
	public String getTres() {
		return tresor;
	}
	
}
