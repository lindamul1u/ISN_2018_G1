package game;

public abstract class Monstres {
	int id;
	public int x;
	public int y;
	private int point_de_vie;
	protected Plateau p;

	public Monstres(Plateau p,int id) {
		// TODO Auto-generated constructor stub
		this.p=p;
		point_de_vie=1;
		this.id=id;
		PosInitialisation();
		
	}
	protected int nbAleat(int Min,int Max) {
		return Min + (int)(Math.random() * ((Max - Min) ));
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
				if(S==indice) {//on place le monstre à la kème case libre du plateau 
					x=i;
					y=j;
					i=n;
					break;

				}

			}
		}
	}
	public void Aleatoire_deplacement() {

		int xD=nbAleat(-1,2);
		int yD=nbAleat(-1,2);// entier aléatoire entre [-1;1]
		if(p.getPlateau()[x+xD][y+yD].equals(p.getChemin())) {
			setPos(x+xD,y+yD);
		}
		
	}


	public abstract boolean deplacer();
	public int getX() {
		return x;
	}
	public String toString() {
		return x +" "+y+" id :"+id;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getPoint_de_vie() {
		return point_de_vie;
	}
	public void setPoint_de_vie(int point_de_vie) {
		this.point_de_vie = point_de_vie;
	}
	public void setPos(int x,int y) {
		this.x=x;
		this.y=y;
	}
	protected int distanceToHerosX() {
		return Math.abs(this.x-p.getHeros().getX());
	}
	protected int distanceToHerosY() {
		return Math.abs(this.y-p.getHeros().getY());
		
	}
	
	public boolean Attaquer() {
	
		if(distanceToHerosX()<=1 &&  distanceToHerosY()<=1) {
			int life=p.getHeros().getLife();
			if(life>0) {
				p.getHeros().setLife(life-1);
			}
	
			return  true;
		}
		return false;
	}
}
