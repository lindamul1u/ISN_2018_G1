package game;

public class Heros {
	private int x,y;
	private Plateau p;

	public Heros(Plateau p) {
		// TODO Auto-generated constructor stub
		this.p=p;
		PosInitialisation();// place le h�ros de mani�re al�atoire � l'instant initiale (al�atoire)
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
		return x+" "+y;
	}

	//Deplacement du h�ros sur le pav� num
	
	public int Deplacement(char c) {// Attention Retournement Graphique
		p.remove(x, y);
		if(c=='7') {
			if(p.getPlateau()[x-1][y-1].equals(p.getChemin())) {
				setPos(x-1,y-1);// Si l'�lement (x-1,y-1) est un chemin on d�place le h�ros 
			}
			else if(p.getPlateau()[x-1][y-1].equals(p.getTres())) {//Si c'est un tr�sort on retourne 1 (variable arret de plateau)
				setPos(x-1,y-1);
				return 1;
			}
			
		}
		else if(c=='8') {
			if(p.getPlateau()[x][y-1].equals(p.getChemin())) {
				setPos(x,y-1);
			}
			else if(p.getPlateau()[x][y-1].equals(p.getTres())) {
				setPos(x,y-1);
				return 1;
			}
			
		}
		else if(c=='9') {
			if(p.getPlateau()[x+1][y-1].equals(p.getChemin())) {
				setPos(x+1,y-1);
			}
			else if(p.getPlateau()[x+1][y-1].equals(p.getTres())) {
				setPos(x+1,y-1);
				return 1;
			}
			
		}
		else if(c=='4') {
			if(p.getPlateau()[x-1][y].equals(p.getChemin())) {
				setPos(x-1,y);
			}
			else if(p.getPlateau()[x-1][y].equals(p.getTres())) {
				setPos(x-1,y);
				return 1;
			}
			
		}
		else if(c=='6') {
			if(p.getPlateau()[x+1][y].equals(p.getChemin())) {
				
				setPos(x+1,y);
			}
			else if(p.getPlateau()[x+1][y].equals(p.getTres())) {
				setPos(x+1,y);
				return 1;
			}
			
		}
		else if(c=='1') {
			if(p.getPlateau()[x-1][y+1].equals(p.getChemin())) {
				setPos(x-1,y+1);
			}
			else if(p.getPlateau()[x-1][y+1].equals(p.getTres())) {
				setPos(x-1,y+1);
				return 1;
			}
			
		}
		else if(c=='2') {
			if(p.getPlateau()[x][y+1].equals(p.getChemin())) {
				setPos(x,y+1);
				
			}
			else if(p.getPlateau()[x][y+1].equals(p.getTres())) {
				setPos(x,y+1);
				return 1;
			}
			
		}
		else if(c=='3') {
			if(!p.getPlateau()[x+1][y+1].equals(p.getMurs())) {
				setPos(x+1,y+1);
				
			}
			else if(p.getPlateau()[x+1][y+1].equals(p.getTres())) {
				setPos(x+1,y+1);
				return 1;
			}
			
		}
		else {
		System.out.println("Mur !");
		}
		p.setPlateau(x, y, p.getHerosS());
		return 0;
	
	}

}
