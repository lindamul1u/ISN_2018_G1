
public class Heros extends Personnages{
	private String name;
	private int x;
	private int y;
	public Heros(String name, int x, int y){
		super(name, x, y);
	
	}
	public String toString(){
		return "Héros : " +super.toString();
	}
	
	
}
