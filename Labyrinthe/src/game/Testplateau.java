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
					System.out.println("ok");
				}
			}
		}

	
	}

}
