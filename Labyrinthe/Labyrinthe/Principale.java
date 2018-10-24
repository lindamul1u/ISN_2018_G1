import java.util.Scanner;


public class Principale {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=12;
		int m=12;
		Plateau p=new Plateau(n,m,50);
		System.out.println(p);
		
		//Personnage
		int x=1;
		int y=1;
		System.out.println("Le personnage : ");
		Personnages perso =new Personnages("Mario",x,y);
		System.out.println(perso.toString());
		while((x>0 && x<=n)||(y>0 && y<=m)){
			System.out.println("Vous voulez aller dans quelle direction ?(1=haut,2=bas,3=gauche,4=droite)");
			Scanner sc1=new Scanner(System.in);
			int direction =sc1.nextInt();
			perso.deplacer(direction);
			System.out.println(perso.toString());
			
		}
		System.out.println("Vous êtes sortis du plateau");
		
		
		
	}

}
