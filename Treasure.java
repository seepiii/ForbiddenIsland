import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class Treasure {
	private String name;
	private BufferedImage image;
	
	public Treasure(String n, BufferedImage i) {
		name=n;
		image=i;
	}
	
	public String getName() {
		return name;
	}
	public BufferedImage getImage() {
		return image;
	}
}