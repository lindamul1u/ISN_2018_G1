package game;

public class Fantome extends Monstres {
	private boolean Etremur;
	public Fantome(Plateau p,int id) {
	super(p,id);
	this.PosInitialisation();
	System.out.println(this);
	}

	
	
	public boolean deplacer(){ //d�placement du monstre dans une direction al�atoire
		Aleatoire_deplacement();
		
		boolean a=Attaquer();
		return a;
		}

	
	public void Aleatoire_deplacement() {

		
	
		int xD=nbAleat(-1,2);
		int yD=nbAleat(-1,2);// entier al�atoire entre [-1;1]
		if(p.appartientPlateau(x+xD, y+yD))
		{
			if(p.getPlateau()[x+xD][y+yD].equals(p.getChemin())) {
		setPos(x+xD,y+yD);
		this.Etremur=false;
		}

		else if(p.getPlateau()[x+xD][y+yD].equals(p.mur)&& p.appartientPlateau(x+xD,y+yD)) {
		
			setPos(x+xD,y+yD);
			this.Etremur=true;}

			
		}
		else {
			this.Aleatoire_deplacement();
			
		}
	}
	public boolean getBoolMur() {
		return this.Etremur;
	}

}
