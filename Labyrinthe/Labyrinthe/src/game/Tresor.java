package game;

public class Tresor {
	
	private int x,y;
	private Plateau P;
	
	Tresor(Plateau P){
		this.P=P; }
	
	private void placer() {
		int n=P.getNblignes();
		int m=P.getcolonnes();
		while(!accessible(x,y)) {
			x=nbAleat(n,m);
			y=nbAleat(n,m);
		}
		P.setPlateau(x, y, "T");
	}
	
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

}
