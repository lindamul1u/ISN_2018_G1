package game;

public class Heros {
	private int x,y;
	private Plateau p;

	public Heros(Plateau p) {
		// TODO Auto-generated constructor stub
		this.p=p;
		PosInitialisation();
	}
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
	public void PosInitialisation() {
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
				if(S==indice) {
					x=i;
					y=j;
					i=n;
					break;
				
				}
				
			}
		}
	}
	public void Deplacement(char c) {
		if(c==8) {
			if(p.getPlateau()[x][y].equals(p.getChemin())) {
				y=y-1;
			}
			
		}
		else if(c==7) {
			if(p.getPlateau()[x][y].equals(p.getChemin())) {
				y=y-1;
				x=x-1;
			}
			
		}
		else if(c==9) {
			if(p.getPlateau()[x][y].equals(p.getChemin())) {
				y=y-1;
				x=x+1;
			}
			
		}
		else if(c==4) {
			if(p.getPlateau()[x][y].equals(p.getChemin())) {
				
				x=x-1;
			}
			
		}
		else if(c==7) {
			if(p.getPlateau()[x][y].equals(p.getChemin())) {
				
				x=x+1;
			}
			
		}
		else if(c==1) {
			if(p.getPlateau()[x][y].equals(p.getChemin())) {
				y=y+1;
				x=x-1;
			}
			
		}
		else if(c==2) {
			if(p.getPlateau()[x][y].equals(p.getChemin())) {
				y=y+1;
				
			}
			
		}
		else if(c==7) {
			if(p.getPlateau()[x][y].equals(p.getChemin())) {
				y=y+1;
				x=x+1;
			}
			
		}
	}
	private int nbAleat(int Min,int Max) {
		return Min + (int)(Math.random() * ((Max - Min) ));
	}



}
