package Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import game.Monstres;
import game.Plateau;
import jdk.nashorn.internal.runtime.ECMAException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.Vector;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;



class TestDeplacementFantome {

	



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
			int NbMo=2;

			int NbMa=0;

			int NbF=1;

			int NbP=1;
			int n=10;

			int m=10;

			int nbrmurs=50;

			int life=2;
			
			Plateau p=new Plateau(NbMo,NbMa,NbF,NbP,n,m,nbrmurs,life);
			String[][]m1=p.copie();
		
			System.out.println(p);
		
			p.DeplacementFant();
		
			System.out.println(p);
			String[][]m2=p.copie();
			
			
			assertNotEquals(m1,m2);//Verifie que m1,m2 n'est pas la même adresse memoire
			
			for(int i=0;i<m2.length;i++) {// vérifie le plateau a était modifié 
				for(int j=0;j<m2[0].length;j++) {
					if(m2[i][j].equals(p.Fant)  ) {
						assertNotEquals(m1[i][j],m2[i][j]);
						
					}
				}
			}}
			
				
		
				
			
			
			
		}
		


