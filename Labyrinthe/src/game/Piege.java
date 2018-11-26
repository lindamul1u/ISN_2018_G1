package game;

public class Piege {

	private int x,y;
	private Plateau P;
	private int id;
	Piege (Plateau P,int id){
		this.P=P; 
		this.id=id;
		placer();
		
	}

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

	public void PerdreVie () {
		Heros h=P.getHeros();
		h.setLife(h.getLife()-1);
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public int getId() {
		return id;
	}
	public String toString() {
		String s=""+id;
		return s;
	}


}
