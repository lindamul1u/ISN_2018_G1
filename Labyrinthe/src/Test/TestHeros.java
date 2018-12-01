package Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import game.Heros;
import game.Plateau;

public class TestHeros {


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
	public void testDeplacement() throws ErreurPlateauException {
		int NbMo=10;

		int NbMa=1;

		int NbF=1;

		int NbP=1;
		int n=10;

		int m=10;

		int nbrmurs=50;

		int life=2;
		
		Plateau p=new Plateau(NbMo,NbMa,NbF,NbP,n,m,nbrmurs,life);
		String[][]m1=p.copie();
		Heros h=p.getHeros();
		int x1=h.getX();
		int y1 =h.getY();
		h.Deplacement('8');
		
		int x2=h.getX();
		int y2=h.getY();
		
		
		//Verif colision mur
		for(int i=1;i<m-1;i++) {
			if(!m1[n-2][i].equals(p.mur)) {
			
				 h=p.getHeros();
				 h.setPos(n-2, i);
				x1=h.getX();
				y1 =h.getY();
				h.Deplacement('8');
				
				x2=h.getX();
				 y2=h.getY();
			assertEquals(x2,x1);
			assertEquals(y2,y1);

			



			break;

		}
			
		
		
		
	}
		
	}}


