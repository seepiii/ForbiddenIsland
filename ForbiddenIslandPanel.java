import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Map;
import java.awt.Font;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
 
public class ForbiddenIslandPanel extends JPanel /*implements mouse*/ {
	private BufferedImage treasureCardBack, floodCardBack;
	private Map<String, BufferedImage> gameSquares;
	private int seed, waterLevel, numPlayers;
  //add other variables as needed
  
	public ForbiddenIslandPanel(int s, int w, int p) {
		seed=s;
		waterLevel=w;
		numPlayers=p;
		//add everything else that happens in the constructor (written by sampadaa?)
		try {
			treasureCardBack = ImageIO.read(new File("TreasureCardBack.jpg"));
			//floodCardBack = ImageIO.read(ForbiddenIslandPanel.class.getResource("/Image/Flood_Card_Back@2x.png"));
		}
		catch(Exception E) {
			System.out.println("Exception Error");
			return;
		}
	}
public void paint(Graphics g) {
		g.drawImage(treasureCardBack, 450, 500, 100, 120, null);
	}
}

