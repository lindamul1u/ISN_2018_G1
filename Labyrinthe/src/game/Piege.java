package game;

public class Piege {

	private int x,y;
	private Plateau P;
	
	Piege (Plateau P){
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
	
public void PerdreVie () {
	Heros.setLife(Heros.getLife()-1);
}
	
	
}
