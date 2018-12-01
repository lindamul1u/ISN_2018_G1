package game;

public class CaseMagique {
	private int x,y;
	private Plateau P;
	private int n;
	private int id;
	private boolean acquis;
	private int type_magique;
	CaseMagique (Plateau P,int id){
		this.P=P;
		this.id=id;
		placer();
		acquis =false;
		type_magique = this.nbAleat(1, 4);
		switch(type_magique) {
		case (1):
			this.Armure_1();
		break;
		case(2):
			this.Attaque_distance_2();
		break;
	
		case(3):
			this.Teleporter_3();
		break;
		}
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
		P.setPlateau(x, y, P.getTres());
		}
	private boolean accessible(int x, int y) {
		if(P.getPlateau()[x][y].equals(P.getChemin())) {
			return true;

		}
		return false;

	}
	public boolean getAcquis() {
		return acquis;
	}
	public void setAcqui() {
		this.acquis=true;
	}
	public int getTypeMage() {
		return this.type_magique;
	}

	private int nbAleat(int Min,int Max) {
		return Min + (int)(Math.random() * ((Max - Min) ));
	}
	public void Armure_1 () {
		this.type_magique=1;

	}
	public void Attaque_distance_2() {
		this.type_magique=2;


	}
	public void Teleporter_3() {
		this.type_magique=3;
	}
	public int GetX() {
		return x;
	}
	public int GetY() {
		return y;
	}
	public String toString() {
		String s=""+id;
		return s;
	}







}
