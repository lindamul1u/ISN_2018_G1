package game;

public class Monstreintel_simple extends Monstres {

	public Monstreintel_simple(Plateau p,int id) {
// TODO Auto-generated constructor stub
		super(p,id);
	}

	@Override
	public boolean deplacer() {
		// TODO Auto-generated method stub
		int xOpt=x+getDirectionX();
		int yOpt=y+getDirectionY();
		boolean a=Attaquer();
		if(xOpt==x && yOpt==y) {

			Aleatoire_deplacement();
		}
		else if(deplacementPossible(xOpt,yOpt)) {
			this.setPos(xOpt, yOpt);
		}
		else if(deplacementPossible(x,yOpt)) {
			this.setPos(x, yOpt);
		}
		else if(deplacementPossible(xOpt,y)) {
			this.setPos(xOpt, y);
		}
		
		else {
			Aleatoire_deplacement();
		}
		return a;
		
		
	}
	public boolean deplacementPossible(int x,int y) {
		if(p.getPlateau()[x][y].equals(p.getChemin())) {
			return true;
		}
		return false;
	}
	public int getDirectionX() {
		if(this.x-p.getHeros().getX()<0) {
			return 1;
		}
		else if(this.x-p.getHeros().getX()>0) {
		return -1;}
		return 0;
	}
	public int getDirectionY() {
		if(this.y-p.getHeros().getY()<0) {
			return 1;
		}
		else if(this.y-p.getHeros().getY()>0) {
			return -1;}
		return 0;
	}

}
