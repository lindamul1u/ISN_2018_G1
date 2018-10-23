import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class Fenetre extends JFrame {

	public Fenetre(){

		//D�finit un titre pour notre fen�tre
		this.setTitle("Ma premi�re fen�tre Java");

		//D�finit sa taille : 400 pixels de large et 100 pixels de haut
		this.setSize(700, 400);

		//Nous demandons � notre objet de se positionner au centre
		this.setLocationRelativeTo(null);

		//Termine le processus lorsqu'on clique sur la croix rouge
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// la rendre visible        
		this.setVisible(true);

		this.setContentPane(new Panneau());
		
		/*
		//Instanciation d'un objet JPanel
	    JPanel pan = new JPanel();

	    //D�finition de sa couleur de fond
	    pan.setBackground(Color.ORANGE);        
	    
	    //On pr�vient notre JFrame que notre JPanel sera son content pane
	    this.setContentPane(pan);               
	    this.setVisible(true);
	    */
		
	}

}