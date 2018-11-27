package game;

public class Fantome extends Monstres {
	private boolean Etremur;
	public Fantome(Plateau p,int id) {
	super(p,id);
	}

	
	
	public boolean deplacer(){ //déplacement du monstre dans une direction aléatoire
		Aleatoire_deplacement();
		
		boolean a=Attaquer();
		return a;
		}

	
	public void Aleatoire_deplacement() {

		
	
		int xD=nbAleat(-1,2);
		int yD=nbAleat(-1,2);// entier aléatoire entre [-1;1]
		if(p.getPlateau()[x+xD][y+yD].equals(p.getChemin())) {
			setPos(x+xD,y+yD);
			System.out.println("Chemin.");

			this.Etremur=false;
		}
		else if(p.getPlateau()[x+xD][y+yD].equals(p.mur)&& p.appartientPlateau(x+xD,y+yD)) {
			System.out.println("Mur");
			setPos(x+xD,y+yD);
			this.Etremur=true;}
	}
	public boolean getBoolMur() {
		return this.Etremur;
	}

}
