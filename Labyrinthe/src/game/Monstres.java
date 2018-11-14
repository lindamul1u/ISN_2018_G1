
public class monstres {
	public int x;
	public int y;
	private int point_de_vie;
	private Plateau p;
	
	public monstres(int x, int y, int point_de_vie) {
		super();
		this.x = x;
		this.y = y;
		this.point_de_vie = point_de_vie;
	}
	public int getX() {
		return x;
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
	private int nbAleat(int Min,int Max) {
		return 2*Min + (int)(Math.random() * ((Max*10 - Min*9) ));
	}
	public void se_deplacer(){ //déplacement du monstre dans une direction aléatoire
		double o=Math.random()*4;
		
		int l=(int)o;
		if(l==0) {
			x=x-1;
			
		}
		else if(l==1) {
			y=y+1;
			
		}
		else if(l==2) {
			x=x+1;
		}
		else {
			y=y-1;
		}
			
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
