package game;

public class Fantome_aleat extends Fantome {
	public Fantome_aleat(Plateau p,int id) {
		super(p,id);
		this.PosInitialisation();
		}

		
		
		public boolean deplacer(){ //déplacement du monstre dans une direction aléatoire
			Aleatoire_deplacement();
			boolean a=Attaquer();

			return a;
			}
}
