package game;

public class Fantome_aleat extends Fantome {
	public Fantome_aleat(Plateau p,int id) {
		super(p,id);
		this.PosInitialisation();
		}

		
		
		public boolean deplacer(){ //d�placement du monstre dans une direction al�atoire
			Aleatoire_deplacement();
			boolean a=Attaquer();

			return a;
			}
}
