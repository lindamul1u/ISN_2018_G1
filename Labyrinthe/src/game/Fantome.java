package game;

public class Fantome extends Monstres {
	private int xmur;
	private int ymur;
	public Fantome(Plateau p,int id) {
	super(p,id);
	}

	
	
	public boolean deplacer(){ //d�placement du monstre dans une direction al�atoire
		Aleatoire_deplacement();
		
		boolean a=Attaquer();
		return a;
		}
	public void traverserMur() {
		String[][] mat=p.getPlateau();
		if(mat[x][y]==p.mur) {
			xmur=x;
			ymur=y;
		}
		
		
	}
	public void ResetMur() {
		p.setPlateau(xmur, ymur, p.mur);
	}
	public void Aleatoire_deplacement() {
		ResetMur();
		
		int xD=nbAleat(-1,2);
		int yD=nbAleat(-1,2);// entier al�atoire entre [-1;1]
		if(p.appartientPlateau(x+xD,y+yD)) {
			setPos(x+xD,y+yD);
		}
		
	}

}
