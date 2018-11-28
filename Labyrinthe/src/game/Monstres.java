

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
		for(int i=2;i<p.n-1;i++) {
			for(int j=2;j<p.m-1;j++) {
				if(!M[i][j].equals(p.mur)) {
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
		int yD=nbAleat(-1,2);
		while(xD==0&&yD==0) {
		 xD=nbAleat(-1,2);
		 yD=nbAleat(-1,2);// entier aléatoire entre [-1;1]
		}
		
		if(p.appartientPlateau(x+xD, y+yD))
		{
			
			if(p.getPlateau()[x+xD][y+yD].equals(p.getChemin())) {
		setPos(x+xD,y+yD);}}
		else {
			this.Aleatoire_deplacement();
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
	Heros h=p.getHeros();
		if(distanceToHerosX()<=1 &&  distanceToHerosY()<=1) {
			int life=h.getLife();
			if(life>0) {
				h.setLife(life-1);
				p.supprMonstre(this);
			}
	
			return  true;
		}
		String[][] m=p.getPlateau();
		if(h.possedeAttaqueDist()) {
			System.out.println("Attaque distance disponible !!!!!!!!!!!");
			for(int i=x+1;i<m.length;i++) {
				if(m[i][this.y].equals(p.mur)) {
					break;
					}
					else if(m[i][this.y].equals(p.heros)) {
						System.out.println("Attaque !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
						h.removeAttdist();

						return true;
					}
			}
			for(int i=x-1;i>=0;i--) {
				if(m[i][this.y].equals(p.mur)) {
					break;
					}
					else if(m[i][this.y].equals(p.heros)) {
						System.out.println("Attaque !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
						h.removeAttdist();

						return true;
					}
			}
			for(int i=y+1;i<m[0].length;i++) {
				if(m[this.x][i].equals(p.mur)) {
					break;
					}
					else if(m[this.x][i].equals(p.heros)) {
						System.out.println("Attaque !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
						h.removeAttdist();

						return true;
					}
			}
			for(int i=y-1;i>=0;i--) {
				if(m[this.x][i].equals(p.mur)) {
					break;
					}
					else if(m[this.x][i].equals(p.heros)) {
						System.out.println("Attaque !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
						h.removeAttdist();

						return true;
					}
			}
		}
		return false;
	}
}
