package game;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;

class Testplateau {
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}


	@Test
	public void testCreation() {
		Plateau p=new Plateau(10,10,50);//Création du plateau (nbr ligne,colones,nbr murs obstacle)

		int[][] m=p.getVoisin();
		String[][] pl=p.getPlateau();
		for(int i=1;i<m.length-1;i++) {
			for(int j=1;j<m[0].length-1;j++) {
				assertEquals(p.nombreVoisinCorrect(m,i,j),true);
			}
		}





	}

	@Test
	public void testHeros() {
		Plateau p=new Plateau(10,10,50);
		String[][] pl=p.getPlateau();
		Heros h=p.getHeros();
		int xh=h.getX();
		int yh=h.getY();
		for(int i=0;i<pl.length;i++) {
			for(int j=0;j<pl[0].length;j++) {
				if(pl[i][j]==p.getHerosS()) {
					assertEquals(i,xh);
					assertEquals(j,yh);
				}
			}
		}
	}
	@Test
	public void testTresor() {
		Plateau p=new Plateau(10,10,50);
		Tresor t=p.getTresor();
		String[][] pl=p.getPlateau();
		int xt=t.getX();
		int yt=t.getY();
		for(int i=0;i<pl.length;i++) {
			for(int j=0;j<pl[0].length;j++) {
				if(pl[i][j]==p.getTres()) {
					assertEquals(i,xt);
					assertEquals(j,yt);
					System.out.println("ok");
				}
			}
		
			assertFalse(Tresor.accessible(t.getX(),t.getY()));




		}
	}

	@Test
	public void testHerosDeplacement() {
		Plateau p=new Plateau(10,10,50);
		String[][] pl=p.getPlateau();
		Heros h=p.getHeros();
		int xh=h.getX();
		int yh=h.getY();
		char commande = 8;
		h.Deplacement(commande);
		int[] dep=h.getDeptest();
		pl=p.getPlateau();
		int xdh=h.getX();
		int ydh=h.getY();
		assertEquals(xdh,dep[0]+xh);
		assertEquals(ydh,dep[1]+yh);


	}
}


