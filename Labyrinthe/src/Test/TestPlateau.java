package Test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import game.Plateau;



public class TestPlateau {


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
	@Test(expected = java.lang.NegativeArraySizeException.class  )
	public void TestCreationplateau () {
		try {
			int NbMo=10;

			int NbMa=0;

			int NbF=0;

			int NbP=0;
			int n=-2;

			int m=-1;

			int nbrmurs=1;

			int life=this.nbAleat(0, 51);
			
			Plateau p=new Plateau(NbMo,NbMa,NbF,NbP,n,m,nbrmurs,life);
			System.out.println(p);
			String[][] M=p.getPlateau();
			int Nmon=6;
			int Nma=3;
			int Nbf=1;
			int Nbp=2;

			int ligne=5;
			int colone=10;
			int Nlife=5;

			for(int i=0;i<M.length;i++) {
				for(int j=0;j<M[0].length;j++) {
					
					if(M[i][j].equals(p.Magie)) {
						Nma++;
						
					}
					else if(M[i][j].equals(p.Fant)) {
						Nbf++;
						
					}
					else if(M[i][j].equals(p.monstre)) {
						Nmon++;
						
					}
					else if(M[i][j].equals(p.piege)) {
						Nbp++;
						
					}
					
					
				}
			}
			assertEquals(Nma,NbMa);
			assertEquals(NbF,Nbf);
			assertEquals(Nmon,NbMo);
			assertEquals(Nbp,NbP);
			assertEquals(n,M.length);
			assertEquals(m,M[0].length);
			assertEquals(life,p.getHeros().getLife());
			System.out.println("Ok");
		

			
			
			
		}
		catch(ErreurPlateauException e) {
			fail();
		}

	
	}
	private int nbAleat(int Min,int Max) {
		return Min + (int)(Math.random() * ((Max - Min) ));
	}

}
