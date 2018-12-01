package game;

public abstract class Fantome  extends Monstres{
	protected boolean Etremur;
	
	public Fantome(Plateau p,int id) {
	super(p,id);

	this.PosInitialisation();
	System.out.println(this);
	}
	
	
	
	public abstract boolean deplacer();


	
	public void Aleatoire_deplacement() {

		int xD=nbAleat(-1,2);
		int yD=nbAleat(-1,2);
		while(xD==0&&yD==0) {
		 xD=nbAleat(-1,2);
		 yD=nbAleat(-1,2);// entier aléatoire entre [-1;1]
		}
		//System.out.println(" Fant dep= "+xD+" "+yD);

		xD=this.x+xD;
		yD=this.y+yD;
		
		if(p.appartientPlateau(xD, yD))
		{
			
		if(p.getPlateau()[xD][yD].equals(p.getChemin())) {
			this.x=xD;
			this.y=yD;
			this.Etremur=false;
			}

			else if(p.getPlateau()[xD][yD].equals(p.mur)) {
				this.x=xD;
				this.y=yD;
				
				this.Etremur=true;}

		else {
			this.Aleatoire_deplacement();
		}
		}
	
	}
	public boolean getBoolMur() {
		return this.Etremur;
	}

}
