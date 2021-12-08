import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class Tile {
	private boolean isFlooded;
	private String name;
	private BufferedImage regular;
	private BufferedImage flooded;
	private BufferedImage state;
	private int[] coordinates;
	
	
	public Tile (String n, BufferedImage reg, BufferedImage flood) {
		isFlooded=false;
		name = n;
		regular = reg;
		flooded = flood;
		state = regular;
		//coordinates = c;
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
//	public int[] getCoordinates() {
//		return coordinates;		
//	}
	public boolean isFlooded() {
		return isFlooded;
	}
	public String getName() {
		return name;
	}
	public BufferedImage getImage() {
		return state;
	}
	public ArrayList<BufferedImage> shuffle() {
		return null;
		
	}
}