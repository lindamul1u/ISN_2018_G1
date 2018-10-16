package game;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Scanner;
public class Lecture extends Thread implements KeyListener {
private char lecture=' ';

	public Lecture() {
		// TODO Auto-generated constructor stub
	
		
	}
	public void run() {
		Scanner sc = new Scanner(System.in); 
		String nl = System.getProperty("line.separator"); 
		String data = ""; 
		while(sc.hasNext()){ 
		    String str = sc.nextLine(); 
		    
		    data += str + nl;//comme ca on rajoute le char de fin de ligne de l'os

		} 
		sc.close(); 
		System.out.println(data); 
	}
	
	public char getLecture() {
		return lecture;
		
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		lecture=e.getKeyChar();
		
	}
	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
