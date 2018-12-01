package game;

public class Fantome_intel extends Fantome {
	

	public Fantome_intel(Plateau p,int id) {
		// TODO Auto-generated constructor stub
		super(p,id);
		this.PosInitialisation();
	}

	@Override
	public boolean deplacer() {
		// TODO Auto-generated method stub
		int xOpt=x+getDirectionX();
		int yOpt=y+getDirectionY();
		boolean a=Attaquer();
	
		 if(this.deplacementPossible(xOpt,yOpt)) {
			this.setPos(xOpt, yOpt);
		}
		else if(deplacementPossible(x,yOpt)) {
			this.setPos(x, yOpt);
		}
		else if(deplacementPossible(xOpt,y)) {
			this.setPos(xOpt, y);
		}
		
		
		return a;
		
		
	}
	public boolean deplacementPossible(int x,int y) {
		System.out.println(this);

		if(p.appartientPlateau(x, y))
		{
			System.out.println("Deplacement possible");
		if(p.getPlateau()[x][y].equals(p.getChemin())) {
			this.x=x;
			this.y=y;
			this.Etremur=false;
			}

			else if(p.getPlateau()[x][y].equals(p.mur)) {
				this.x=x;
				this.y=y;
				
				this.Etremur=true;
				}
		System.out.println(this);

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
