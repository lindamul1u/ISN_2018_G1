package game;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestTresor {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}
	
	@Test
	public void testCreation() {
		Plateau p=new Plateau(10,10,50);//Création du plateau (nbr ligne,colones,nbr murs obstacle)
		System.out.println(p);
		int[][] m=p.getVoisin();
		String[][] pl=p.getPlateau();
		for(int i=1;i<m.length-1;i++) {
			for(int j=1;j<m[0].length-1;j++) {
				assertEquals(p.nombreVoisinCorrect(m,i,j),true);
			}
		}
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
		char commande = 8;
		h.Deplacement(commande);
		
		
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
	assertTrue(Tresor.accessible(4,8));
	assertFalse(Tresor.accessible(5,9));

	
	
		
	}
	}

}
