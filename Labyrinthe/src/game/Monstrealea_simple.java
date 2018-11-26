package game;
public class Monstrealea_simple extends Monstres {
	
	public Monstrealea_simple(Plateau p,int id) {
	super(p,id);
	}

	
	
	public boolean deplacer(){ //déplacement du monstre dans une direction aléatoire
		Aleatoire_deplacement();
		boolean a=Attaquer();
		return a;
		}

			
		
		
		
		
		
		
		
	

}
