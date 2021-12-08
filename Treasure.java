import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class Treasure {
	private String name;
	private BufferedImage claimed, unclaimed, state;
	private String s;
	
	public Treasure(String n, BufferedImage r, BufferedImage notClaimed) {
		name=n;
		claimed=r;
		unclaimed=notClaimed;
		state=unclaimed;
		s="unclaimed";
	}
	public void claim() {
		state=claimed;
		s="claimed";
	}
	public String getName() {
		return name;
	}
	public String getState() {
		return s;
	}
	public BufferedImage getImage() {
		return state;
	}
}