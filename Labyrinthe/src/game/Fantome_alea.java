package game;

public class Fantome_alea extends Fantome {

	public Fantome_alea(Plateau p,int id) {
// TODO Auto-generated constructor stub
		super(p,id);
		this.PosInitialisation();
	}
	public boolean deplacer(){ //déplacement du fantome dans une direction aléatoire
		Aleatoire_deplacement();
		
		boolean a=Attaquer();
		return a;
		}
}
