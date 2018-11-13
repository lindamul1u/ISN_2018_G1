package game;

public class Heros {
	private int x,y;
	private Plateau p;
	private int Point_vie;
	private int[] depTest;
	public Heros(Plateau p) {
		// TODO Auto-generated constructor stub
		this.p=p;
		PosInitialisation();// place le héros de manière aléatoire à l'instant initiale (aléatoire)
		Point_vie=10;
		depTest=new int[2];
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
				if(S==indice) {//on place le héros à la kème case libre du plateau 
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

	//Deplacement du héros sur le pavé num
	
	public int Deplacement(char c) {// Attention Retournement Graphique
		p.remove(x, y);
		if(Point_vie==0) {
			
			return 1;
		}
		if(c=='7') {
			if(p.getPlateau()[x-1][y-1].equals(p.getChemin())) {
				setPos(x-1,y-1);// Si l'élement (x-1,y-1) est un chemin on déplace le héros 
				setDEPTEST(-1,-1);
				
			}
			else if(p.getPlateau()[x-1][y-1].equals(p.getTres())) {//Si c'est un trésort on retourne 1 (variable arret de plateau)
				setPos(x-1,y-1);
				return 1;
			}
			
		}
		else if(c=='8') {
			if(p.getPlateau()[x][y-1].equals(p.getChemin())) {
				setPos(x,y-1);
				setDEPTEST(0,-1);

			}
			else if(p.getPlateau()[x][y-1].equals(p.getTres())) {
				setPos(x,y-1);
				
				return 1;
			}
			
		}
		else if(c=='9') {
			if(p.getPlateau()[x+1][y-1].equals(p.getChemin())) {
				setDEPTEST(1,-1);

				setPos(x+1,y-1);
				setDEPTEST(1,-1);
			}
			else if(p.getPlateau()[x+1][y-1].equals(p.getTres())) {
				
				setPos(x+1,y-1);
				return 1;
			}
			
		}
		else if(c=='4') {
			if(p.getPlateau()[x-1][y].equals(p.getChemin())) {
				setPos(x-1,y);
				setDEPTEST(-1,0);
			}
			else if(p.getPlateau()[x-1][y].equals(p.getTres())) {
				setPos(x-1,y);
				return 1;
			}
			
		}
		else if(c=='6') {
			if(p.getPlateau()[x+1][y].equals(p.getChemin())) {
				
				setPos(x+1,y);
				setDEPTEST(1,0);
			}
			else if(p.getPlateau()[x+1][y].equals(p.getTres())) {
				setPos(x+1,y);
				return 1;
			}
			
		}
		else if(c=='1') {
			if(p.getPlateau()[x-1][y+1].equals(p.getChemin())) {
				setPos(x-1,y+1);
				setDEPTEST(-1,1);
			}
			else if(p.getPlateau()[x-1][y+1].equals(p.getTres())) {
				setPos(x-1,y+1);
				return 1;
			}
			
		}
		else if(c=='2') {
			if(p.getPlateau()[x][y+1].equals(p.getChemin())) {
				setPos(x,y+1);
				setDEPTEST(0,1);
				
			}
			else if(p.getPlateau()[x][y+1].equals(p.getTres())) {
				setPos(x,y+1);
				return 1;
			}
			
		}
		else if(c=='3') {
			if(!p.getPlateau()[x+1][y+1].equals(p.getMurs())) {
				setPos(x+1,y+1);
				setDEPTEST(1,1);
			}
			else if(p.getPlateau()[x+1][y+1].equals(p.getTres())) {
				setPos(x+1,y+1);
				return 1;
			}
			
		}
		else {
		System.out.println("Mur !");
		}
		
		
	
		return 0;
	
	}
	public void setDEPTEST(int i,int j) {
		depTest[0]=i;
		depTest[1]=j;
	}
	public int[] getDeptest(){
		return depTest;
	}
	public int getLife() {
		return Point_vie;
	}
	public void setLife(int p) {
		Point_vie=p;
	}
}
