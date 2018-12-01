package game;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Fond extends JPanel  {
	int N;
	
	public Fond() {
		N=0;
		
	}
	private BufferedImage image;
public void setN() {
	N++;
	N=N%2;
}
	public void setImage(String s){
		try {
			this.image = image = ImageIO.read(new File(s));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
	}

	public void paintComponent(Graphics g ){
		if(N==0) {
			setImage("fond.png");
			g.drawImage(image,0,0,null);
			setN();
			
		}
		else {
			setImage("dem1.png");
			g.drawImage(image,0,0,null);
			setN();
			
		}
		
	}

}
