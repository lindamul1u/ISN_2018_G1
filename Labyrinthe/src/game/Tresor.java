package game;

public class Tresor {
	
	private int x,y;
	private Plateau P;
	
	Tresor(Plateau P){
		this.P=P; 
		placer();
		System.out.println(x+" "+y);}	
	private void placer() {
		int n=P.getNblignes();
		int m=P.getcolonnes();
		x=0;
		y=0;
		while(!accessible(x,y)) {
			x=nbAleat(1,n-1);
			y=nbAleat(1,m-1);
			
		}
		P.setPlateau(x, y, P.getTres());}
	
	private boolean accessible(int x, int y) {
		if(P.getPlateau()[x][y].equals(P.getChemin())) {
			return true;
		
		}
		return false;
		
	}
	
	private int nbAleat(int Min,int Max) {
		return Min + (int)(Math.random() * ((Max - Min) ));
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
	public void Victoire() {
		
	}

}
