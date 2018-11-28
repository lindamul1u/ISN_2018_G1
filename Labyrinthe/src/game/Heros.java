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
		PosInitialisation();// place le h�ros de mani�re al�atoire � l'instant initiale (al�atoire)
		depTest=new int[2];
		v=new Vector();
		
	}
	private void PosInitialisation() {
		String[][] M=p.getPlateau();
		int n=p.getNblignes();
		int m=p.getcolonnes();
		int Nbrcaselibre=p.getNbrchemin();
		int indice=nbAleat(1,Nbrcaselibre);
		int S=0;
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(M[i][j].equals(p.getChemin())) {
					S+=1;
				}
				if(S==indice) {//on place le h�ros � la k�me case libre du plateau 
					x=i;
					y=j;
					i=n;
					break; 
				
				}
				
			}
		}
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

	//Deplacement du h�ros sur le pav� num
	
	public int Deplacement(char c) {// Attention Retournement Graphique
		p.remove(x, y);
		possedeArmure();
		
		if(Point_vie==0) {
			System.out.println(Point_vie);	
			return 1;
		}
		
		
		if(c=='7') {
			if(p.getPlateau()[x-1][y-1].equals(p.chemin)) {
				setPos(x-1,y-1);// Si l'�lement (x-1,y-1) est un chemin on d�place le h�ros 
				
				
			}
			else if(p.getPlateau()[x-1][y-1].equals(p.tresor)) {//Si c'est un tr�sort on retourne 1 (variable arret de plateau)
				setPos(x-1,y-1);
				return 1;
			}
			else if(p.getPlateau()[x-1][y-1].equals(p.piege)) {//Si c'est un tr�sort on retourne 1 (variable arret de plateau)
				Piege P=p.recherchePiege(x-1, y-1);
				p.removePiege(P);
				this.setLife(Point_vie-1);
				setPos(x-1,y-1);

			}	else if(p.getPlateau()[x-1][y-1].equals(p.Magie)) {//Si c'est un tr�sort on retourne 1 (variable arret de plateau)
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
			else if(p.getPlateau()[x][y-1].equals(p.piege)) {//Si c'est un tr�sort on retourne 1 (variable arret de plateau)
				Piege P=p.recherchePiege(x, y-1);
				p.removePiege(P);
				this.setLife(Point_vie-1);
				setPos(x,y-1);

			}
			else if(p.getPlateau()[x][y-1].equals(p.Magie)) {//Si c'est un tr�sort on retourne 1 (variable arret de plateau)
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
			else if(p.getPlateau()[x+1][y-1].equals(p.piege)) {//Si c'est un tr�sort on retourne 1 (variable arret de plateau)
				Piege P=p.recherchePiege(x+1, y-1);
				p.removePiege(P);
				this.setLife(Point_vie-1);
				setPos(x+1,y-1);

			}
			else if(p.getPlateau()[x+1][y-1].equals(p.Magie)) {//Si c'est un tr�sort on retourne 1 (variable arret de plateau)
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
			else if(p.getPlateau()[x-1][y].equals(p.piege)) {//Si c'est un tr�sort on retourne 1 (variable arret de plateau)
				Piege P=p.recherchePiege(x-1, y);
				p.removePiege(P);
				this.setLife(Point_vie-1);
				setPos(x-1,y);

			}
			else if(p.getPlateau()[x-1][y].equals(p.Magie)) {//Si c'est un tr�sort on retourne 1 (variable arret de plateau)
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
			else if(p.getPlateau()[x+1][y].equals(p.piege)) {//Si c'est un tr�sort on retourne 1 (variable arret de plateau)
				Piege P=p.recherchePiege(x+1, y);
				p.removePiege(P);
				this.setLife(Point_vie-1);
				setPos(x+1,y);

			}
			else if(p.getPlateau()[x+1][y].equals(p.Magie)) {//Si c'est un tr�sort on retourne 1 (variable arret de plateau)
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
			else if(p.getPlateau()[x-1][y+1].equals(p.piege)) {//Si c'est un tr�sort on retourne 1 (variable arret de plateau)
				Piege P=p.recherchePiege(x-1, y+1);
				p.removePiege(P);
				this.setLife(Point_vie-1);
				setPos(x-1,y+1);

			}
			else if(p.getPlateau()[x-1][y+1].equals(p.Magie)) {//Si c'est un tr�sort on retourne 1 (variable arret de plateau)
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
			else if(p.getPlateau()[x][y+1].equals(p.piege)) {//Si c'est un tr�sort on retourne 1 (variable arret de plateau)
			
				Piege P=p.recherchePiege(x, y+1);
				p.removePiege(P);
				this.setLife(Point_vie-1);
				setPos(x,y+1);
			}
			else if(p.getPlateau()[x][y+1].equals(p.Magie)) {//Si c'est un tr�sort on retourne 1 (variable arret de plateau)
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
			else if(p.getPlateau()[x+1][y+1].equals(p.piege)) {//Si c'est un tr�sort on retourne 1 (variable arret de plateau)
				Piege P=p.recherchePiege(x+1, y+1);
				p.removePiege(P);
				this.setLife(Point_vie-1);
				setPos(x+1,y+1);
			}
			else if(p.getPlateau()[x+1][y+1].equals(p.Magie)) {//Si c'est un tr�sort on retourne 1 (variable arret de plateau)
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
	
		
	private int[] minVector(Vector<int[]>v) {
		double min=(v.get(0)[0]-this.x)^2+(v.get(0)[1]-this.y)^2;
		int[] Cor=new int[2];
		for(int[] c:v) {
			if(Math.pow(c[0]-this.x,2)+Math.pow(c[1]-this.y,2)<=min) {
				min=Math.pow(c[0]-this.x,2)+Math.pow(c[1]-this.y,2);
				Cor[0]=c[0];
				Cor[1]=c[1];
				
			}
		}
		return Cor;
		
		
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
 	
 	
	public int getLife() {
		return Point_vie;
	}
	public void setLife(int p) {
		Point_vie=p;
	}
}
