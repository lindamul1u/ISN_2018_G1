import java.awt.event.KeyEvent;
public class Personnages {
	private String nom;
	private int x;
	private int y;
	
	public Personnages(String nom, int x,int y){
		this.nom=nom;
		this.x=x;
		this.y=y;
	}


	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
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
	
	public String toString(){
		return nom + " de coordonnées : (" + x +","+ y+")";
	}
	
	
	/*private  boolean [] tabTouches ={false,false,false,false,false};
	public void touchePresse(KeyEvent event) {	

		//mise ‡ jour des variables pressees
		if(event.getKeyCode()==KeyEvent.VK_UP) tabTouches[0] = true;
		if(event.getKeyCode()==KeyEvent.VK_LEFT) tabTouches[1] = true;
		if(event.getKeyCode()==KeyEvent.VK_RIGHT) tabTouches[2] = true;
		if(event.getKeyCode()==KeyEvent.VK_ENTER) tabTouches[3] = true;
		if(event.getKeyCode()==KeyEvent.VK_SPACE) tabTouches[4] = true;

	}*/
	
	public void deplacer(int direction) {
		
			  switch(direction) {
		        // Haut
		        case 1:
		            this.y++;
		            break;
		             
		        // Bas
		        case 2:
		            this.y--;
		            break;
		             
		        // Gauche
		        case 3:
		            this.x--;
		            break;
		          
		        // Droite
		        case 4:
		            this.x++;
		            break;
      
        }
        
	}



	
	
	
	
	
	
	
	
	/*public void gestionDuClavier() {	


		int px = this.vaisseau.getX();

		// deplacement a droite
		if(tabTouches[2]==true && tabTouches[0]==false && tabTouches[1]==false){
			if(px<756)
			{
				this.vaisseau.setX(px+10);
			}
		}

		//deplacement a gauche
		else if(tabTouches[1]==true && tabTouches[0]==false && tabTouches[2]==false){
			if(px>10)
			{
				this.vaisseau.setX(px-10);
			}
		}

*/

}
