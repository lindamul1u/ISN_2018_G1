package game;

import java.util.Vector;

public class Heros {
	private int x,y;
	private Plateau p;
	private int Point_vie;
	private int[] depTest;
	private Vector<CaseMagique> v;
	private boolean distanceAtt;
	
	public Heros(Plateau p) {
		// TODO Auto-generated constructor stub
		this.p=p;
		PosInitialisation();// place le héros de manière aléatoire à l'instant initiale (aléatoire)
		depTest=new int[2];
		v=new Vector();
		
	}
	private void PosInitialisation() {
		int n=p.getNblignes();
		int m=p.getcolonnes();
		x=0;
		y=0;
		while(!accessible(x,y)) {
			x=nbAleat(1,n-1);
			y=nbAleat(1,m-1);

		}
	}
	private boolean accessible(int x, int y) {
		if(p.getPlateau()[x][y].equals(p.getChemin())) {
			return true;

		}
		return false;

	}
	public Vector<CaseMagique>getMagie(){
		return v;
	}

	private int nbAleat(int Min,int Max) {
		return Min + (int)(Math.random() * ((Max - Min) ));
	}


	//GET ET SET
	public void setPos(int x,int y) {
		this.x=x;
		this.y=y;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public void setX(int x) {
		this.x=x;
	}
	public void setY(int y) {
		this.y=y;
	}
	public String toString() {
		String S="";

		S+=" life_score :" +this.Point_vie;
		return S;
	}

	//Deplacement du héros sur le pavé num
	
	public int Deplacement(char c) {// Attention Retournement Graphique
		p.remove(x, y);
		possedeArmure();
		teleportation();
		
		if(Point_vie==0) {
			System.out.println(Point_vie);	
			return 1;
		}
		
		
		if(c=='7') {
			if(p.getPlateau()[x-1][y-1].equals(p.chemin)) {
				setPos(x-1,y-1);// Si l'élement (x-1,y-1) est un chemin on déplace le héros 
				
				
			}
			else if(p.getPlateau()[x-1][y-1].equals(p.tresor)) {//Si c'est un trésort on retourne 1 (variable arret de plateau)
				setPos(x-1,y-1);
				return 1;
			}
			else if(p.getPlateau()[x-1][y-1].equals(p.piege)) {//Si c'est un trésort on retourne 1 (variable arret de plateau)
				Piege P=p.recherchePiege(x-1, y-1);
				p.removePiege(P);
				this.setLife(Point_vie-1);
				setPos(x-1,y-1);

			}	else if(p.getPlateau()[x-1][y-1].equals(p.Magie)) {//Si c'est un trésort on retourne 1 (variable arret de plateau)
				CaseMagique m=p.rechercheMagie(x-1, y-1);
				m.setAcqui();
				v.add(m);
				p.removeMagie(m);
				setPos(x-1,y-1);

			}
			
		}
		else if(c=='8') {
			

			if(p.getPlateau()[x][y-1].equals(p.chemin)) {
				setPos(x,y-1);

				
 
			}
			else if(p.getPlateau()[x][y-1].equals(p.tresor)) {
				setPos(x,y-1);
				
				return 1;
			}
			else if(p.getPlateau()[x][y-1].equals(p.piege)) {//Si c'est un trésort on retourne 1 (variable arret de plateau)
				Piege P=p.recherchePiege(x, y-1);
				p.removePiege(P);
				this.setLife(Point_vie-1);
				setPos(x,y-1);

			}
			else if(p.getPlateau()[x][y-1].equals(p.Magie)) {//Si c'est un trésort on retourne 1 (variable arret de plateau)
				CaseMagique m=p.rechercheMagie(x, y-1);
				m.setAcqui();
				v.add(m);
				p.removeMagie(m);
				setPos(x,y-1);

			}
			
			
		}
		else if(c=='9') {
			if(p.getPlateau()[x+1][y-1].equals(p.chemin)) {
				

				setPos(x+1,y-1);
				
			}
			else if(p.getPlateau()[x+1][y-1].equals(p.tresor)) {
				
				setPos(x+1,y-1);
				return 1;
			}
			else if(p.getPlateau()[x+1][y-1].equals(p.piege)) {//Si c'est un trésort on retourne 1 (variable arret de plateau)
				Piege P=p.recherchePiege(x+1, y-1);
				p.removePiege(P);
				this.setLife(Point_vie-1);
				setPos(x+1,y-1);

			}
			else if(p.getPlateau()[x+1][y-1].equals(p.Magie)) {//Si c'est un trésort on retourne 1 (variable arret de plateau)
				CaseMagique m=p.rechercheMagie(x+1, y-1);
				m.setAcqui();
				v.add(m);
				p.removeMagie(m);
				setPos(x+1,y-1);

			}
			
			
		}
		else if(c=='4') {
			if(p.getPlateau()[x-1][y].equals(p.chemin)) {
				setPos(x-1,y);
			}
			else if(p.getPlateau()[x-1][y].equals(p.tresor)) {
				setPos(x-1,y);
				return 1;
			}
			else if(p.getPlateau()[x-1][y].equals(p.piege)) {//Si c'est un trésort on retourne 1 (variable arret de plateau)
				Piege P=p.recherchePiege(x-1, y);
				p.removePiege(P);
				this.setLife(Point_vie-1);
				setPos(x-1,y);

			}
			else if(p.getPlateau()[x-1][y].equals(p.Magie)) {//Si c'est un trésort on retourne 1 (variable arret de plateau)
				CaseMagique m=p.rechercheMagie(x-1, y);
				m.setAcqui();
				v.add(m);
				p.removeMagie(m);
				setPos(x-1,y);

			}
			
			
		}
		else if(c=='6') {
			if(p.getPlateau()[x+1][y].equals(p.chemin)) {
				
				setPos(x+1,y);
				
			}
			else if(p.getPlateau()[x+1][y].equals(p.tresor)) {
				setPos(x+1,y);
				return 1;
			}
			else if(p.getPlateau()[x+1][y].equals(p.piege)) {//Si c'est un trésort on retourne 1 (variable arret de plateau)
				Piege P=p.recherchePiege(x+1, y);
				p.removePiege(P);
				this.setLife(Point_vie-1);
				setPos(x+1,y);

			}
			else if(p.getPlateau()[x+1][y].equals(p.Magie)) {//Si c'est un trésort on retourne 1 (variable arret de plateau)
				CaseMagique m=p.rechercheMagie(x+1, y);
				m.setAcqui();
				v.add(m);
				p.removeMagie(m);
				setPos(x+1,y);

			}
			
			
		}
		else if(c=='1') {
			if(p.getPlateau()[x-1][y+1].equals(p.chemin)) {
				setPos(x-1,y+1);
				
			}
			else if(p.getPlateau()[x-1][y+1].equals(p.tresor)) {
				setPos(x-1,y+1);
				return 1;
			}
			else if(p.getPlateau()[x-1][y+1].equals(p.piege)) {//Si c'est un trésort on retourne 1 (variable arret de plateau)
				Piege P=p.recherchePiege(x-1, y+1);
				p.removePiege(P);
				this.setLife(Point_vie-1);
				setPos(x-1,y+1);

			}
			else if(p.getPlateau()[x-1][y+1].equals(p.Magie)) {//Si c'est un trésort on retourne 1 (variable arret de plateau)
				CaseMagique m=p.rechercheMagie(x-1, y+1);
				m.setAcqui();
				v.add(m);
				p.removeMagie(m);
				setPos(x-1,y+1);

			}
			
			
		}
		else if(c=='2') {
			if(p.getPlateau()[x][y+1].equals(p.chemin)) {
				setPos(x,y+1);
				
			}
			else if(p.getPlateau()[x][y+1].equals(p.tresor)) {
				setPos(x,y+1);
				return 1;
			}
			else if(p.getPlateau()[x][y+1].equals(p.piege)) {//Si c'est un trésort on retourne 1 (variable arret de plateau)
			
				Piege P=p.recherchePiege(x, y+1);
				p.removePiege(P);
				this.setLife(Point_vie-1);
				setPos(x,y+1);
			}
			else if(p.getPlateau()[x][y+1].equals(p.Magie)) {//Si c'est un trésort on retourne 1 (variable arret de plateau)
				CaseMagique m=p.rechercheMagie(x, y+1);
				m.setAcqui();
				v.add(m);
				p.removeMagie(m);
				setPos(x,y+1);

			}
			
			
		}
		else if(c=='3') {
			if(p.getPlateau()[x+1][y+1].equals(p.chemin)) {
				setPos(x+1,y+1);
			}
			else if(p.getPlateau()[x+1][y+1].equals(p.piege)) {
				setPos(x+1,y+1);
				return 1;
			}
			else if(p.getPlateau()[x+1][y+1].equals(p.piege)) {//Si c'est un trésort on retourne 1 (variable arret de plateau)
				Piege P=p.recherchePiege(x+1, y+1);
				p.removePiege(P);
				this.setLife(Point_vie-1);
				setPos(x+1,y+1);
			}
			else if(p.getPlateau()[x+1][y+1].equals(p.Magie)) {//Si c'est un trésort on retourne 1 (variable arret de plateau)
				CaseMagique m=p.rechercheMagie(x+1, y+1);
				m.setAcqui();
				v.add(m);
				p.removeMagie(m);
				setPos(x+1,y+1);

			}
			
			
		}
		else {
		System.out.println("Mur !");
		}
		
		
	
		return 0;
	
	}

	public boolean attaqueDistPoss() {
		String[][] plat=p.getPlateau();
	
		for(int i=x;i<plat.length;i++) {
			if(plat[i][this.y].equals(p.mur)) {
			break;
			}
			else if(plat[i][this.y].equals(p.monstre)) {
				System.out.println("attaque");

				return true;
			}
				}
		for(int i=x;i>=0;i--) {
			if(plat[i][this.y].equals(p.mur)) {
			break;
			}
			else if(plat[i][this.y].equals(p.monstre)) {
				System.out.println("attaque");

				return true;
			}
				
			}
		for(int j=y;j<plat[0].length;j++) {
			if(plat[this.x][j].equals(p.mur)) {
			break;
			}
			else if(plat[this.x][j].equals(p.monstre)) {
				

				return true;
			}
				}
		for(int j=this.y;j>=0;j--) {
			if(plat[this.x][j].equals(p.mur)) {
				break;
				}
				else if(plat[this.x][j].equals(p.monstre)) {
			

					System.out.println("attaque");
					return true;
				}
				
			}
		return false;
		
	}
	
		
	
	public boolean possedeAttaqueDist() {
		for(CaseMagique m:v) {
			if(m.getTypeMage()==2) {
			
				return true;
			}
		}
		
		return false;
	
	}
	public void removeAttdist() {
		CaseMagique M=null;
		for(CaseMagique m:v) {
			if(m.getTypeMage()==2) {
			System.out.println("remove");
			M=m;
			}
		}
		v.remove(M);

		}
		
	

	public void possedeArmure() {
		CaseMagique M=null;
		for(CaseMagique m:v) {
			if(m.getTypeMage()==1) {
				this.Point_vie+=1;
				M=m;
			}
		}

		v.remove(M);
		
	}
	public void teleportation() {
		CaseMagique M=null;
		for(CaseMagique m:v) {
			if(m.getTypeMage()==3) {
				PosInitialisation();
				M=m;
			}
		}

		v.remove(M);
		
	}
 	
 	
	public int getLife() {
		return Point_vie;
	}
	public void setLife(int p) {
		Point_vie=p;
	}
}
