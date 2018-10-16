package game;
import java.awt.Dimension;
import java.awt.Label;
import java.awt.TextArea;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class Fenetre extends JFrame implements KeyListener{
	private Graphique gr = new Graphique();
	private Grapheh h = new Grapheh();
	private TextArea area;
	private Plateau p;
	private char Commande;


	public Fenetre(Plateau p){     
		this.p=p;
	
		this.setTitle("Animation");
		this.setSize(300, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.setContentPane(gr);
		
		area=new TextArea();  
		area.setBounds(10,10,20,20);  


		area.addKeyListener(this);  
		this.setVisible(true);
		this.add(area);
		this.setSize(1080, 720);
		setLayout(null);  
		setVisible(true);  
		go();

	}
	private void go(){
		int n=p.getNblignes();
		int m=p.getcolonnes();
		int x0=50;
		int y0=50;
		int x=0;
		int y=0;
		String[][] mat=p.getPlateau();
		for(int i = 0; i < n; i++){
			for(int j=0;j<m;j++) {
				if(mat[i][j].equals(p.getMurs())) {
					x=x0+i*10;
					y=y0+j*10;
					gr.setPosX(x);
					gr.setPosY(y);
					gr.repaint();  
					try {
						Thread.sleep(35);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				else if(mat[i][j].equals("0")) {
					x=x0+i*10;
					y=y0+j*10;
					h.setPosX(x);
					h.setPosY(y);
					h.repaint();  
					try {
						Thread.sleep(35);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}


		}
		System.out.println(p);
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
		Commande=arg0.getKeyChar();
		p.setCommande(Commande);

	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}
	public char getCommande() {
		return Commande;
	}
}
