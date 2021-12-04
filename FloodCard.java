import java.awt.image.BufferedImage;

public class FloodCard {
	private String placeName;
	private BufferedImage image;
	
	public FloodCard(String p, BufferedImage i) {
		placeName = p;
		image=i;
	}
	public BufferedImage getImage() {
		return image;
	}
	public String getPlaceName() {
		return placeName;
	}
}