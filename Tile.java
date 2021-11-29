import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class Tile {
	private boolean isFlooded;
	private String name;
	private BufferedImage regular;
	private BufferedImage flooded;
	private BufferedImage state;
	private int[] coordinates;
	
	public Tile (String n, BufferedImage reg, BufferedImage flood, int[] c) {
		isFlooded=false;
		name = n;
		regular = reg;
		flooded = flood;
		state = regular;
		coordinates = c;
	}
	
	public void shoreUp() {
		if (isFlooded) {
			isFlooded = false;
			state = regular;
		}
	}
	
	public void flood() {
		isFlooded = true;
		state = flooded;
	}
	
	//get methods
	public int[] getCoordinates() {
		return coordinates;		
	}
	public boolean isFlooded() {
		return isFlooded;
	}
	public String getName() {
		return name;
	}
	public BufferedImage getImage() {
		return state;
	}
	public void shuffle() {
		
	}
}