public class Fantome extends Monstres  {
	
	public Fantome(Plateau p,int id) {
		
		super(p,id);
// TODO Auto-generated constructor stub
	}
	protected int nbAleat(int Min,int Max) {
		return Min + (int)(Math.random() * ((Max - Min) ));

	}
	public boolean deplacer() { //se déplace à travers les murs

		Aleatoire_deplacement();
		traverser_les_murs();
		boolean a=Attaquer();

		return a;

	}

	public void Aleatoire_deplacement() {
		int xD=nbAleat(-1,2);
		int yD=nbAleat(-1,2);// entier aléatoire entre [-1;1]
		x=x+xD;
		y=y+yD;
	}
	
	public void traverser_les_murs() {
		
		
		
		if(p.getPlateau()[x][y]=="X") {
			//fontome prend la place de mur
			p.setPlateau(x, y, "F");
		}
		else {
			Aleatoire_deplacement() ;
			
		}
		
		
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public int getX() {

		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
	return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getPoint_de_vie() {
		return point_de_vie;
	}

	public void setPoint_de_vie(int point_de_vie) {

		this.point_de_vie = point_de_vie;
	}
	public Plateau getP() {
		return p;
	}
	public void setP(Plateau p) {
		this.p = p;
	}

	

	

	



}