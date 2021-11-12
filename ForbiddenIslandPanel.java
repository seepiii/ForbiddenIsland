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
import java.awt.event.MouseListener;
public class ForbiddenIslandPanel extends JPanel implements MouseListener {
	private BufferedImage fcb, fcbs;
	private BufferedImage tcb, tcbs;
	private BufferedImage foolsLanding, templeOfTheSun;
	private BufferedImage waterLevelMeter, blueB;
	private BufferedImage arrow;
	private Map<String, BufferedImage> gameSquares;
	private static int seed, numPlayers;
	private static String waterLevel;
	private BufferedImage choice1, choice2;
	private Map<String, Boolean> actions;
  //add other variables as needed
  
	public ForbiddenIslandPanel(int s, String w, int p) {
		seed=s;
		waterLevel=w;
		numPlayers=p;
		//add everything else that happens in the constructor (written by sampadaa?)
		try {
			tcb = ImageIO.read(ForbiddenIslandPanel.class.getResource("/Image/Card_Back@2x (3).png"));
			System.out.println("Constructor");
			tcbs = ImageIO.read(ForbiddenIslandPanel.class.getResource("/Image/Card_BackSelect@2x.png"));
			foolsLanding = ImageIO.read(ForbiddenIslandPanel.class.getResource("/Image/Foo's Landing.png"));
			fcb = ImageIO.read(ForbiddenIslandPanel.class.getResource("/Image/Flood Card Back.png"));
			fcbs = ImageIO.read(ForbiddenIslandPanel.class.getResource("/Image/Flood Card Back Select.png"));
			templeOfTheSun = ImageIO.read(ForbiddenIslandPanel.class.getResource("/Image/Temple of the Sun.png"));
			waterLevelMeter = ImageIO.read(ForbiddenIslandPanel.class.getResource("/Image/Water Level Meter.png"));
			blueB = ImageIO.read(ForbiddenIslandPanel.class.getResource("/Image/Blue Background.png"));
			arrow = ImageIO.read(ForbiddenIslandPanel.class.getResource("/Image/Weird Arrow.png"));

		}
		catch(Exception E) {
			System.out.println("Exception Error");
			return;
		}
		choice1 = tcb;
		choice2 = fcb;
		addMouseListener(this);
		/*actions.put("Special Action", false);
		actions.put("Move", false);
		actions.put("Shore Up", false);
		actions.put("Capture Treasure", false);
		actions.put("Give Treasure", false);*/
		//if ()

	}
public void paint(Graphics g) {
	g.drawImage(tcb,  60,  534,  170,  101,  null);
	//g.drawImage(foolsLanding,  589,  13,  111,  117,  null); //-200 from width
	g.drawImage(choice1,  60,  534,  170,  101,  null);
	g.drawImage(foolsLanding,  589,  13,  111,  117,  null); //-200 from width
	g.drawImage(templeOfTheSun,  737,  13,  111,  117,  null); //-200 from width
	g.drawImage(fcb,  1225,  534,  170,  101,  null); //-200 from width
	g.drawImage(choice2,  1225,  534,  170,  101,  null); //-200 from width
	g.drawImage(waterLevelMeter,  1420,  350,  125,  325,  null); //-200 from width
	g.drawImage(blueB,  400,  975,  125,  50,  null); //-200 from width
	g.drawImage(blueB,  555,  975,  125,  50,  null); //-200 from width
	g.drawImage(blueB,  710,  975,  125,  50,  null); //-200 from width
	g.drawImage(blueB,  865,  975,  125,  50,  null); //-200 from width
	g.drawImage(blueB,  1020,  975,  125,  50,  null); //-200 from width
	
	
	System.out.println("Paint");

	g.setFont(new Font("TimesRoman",Font.PLAIN,12));
	g.drawString("SPECIAL ACTION", 405, 1002);
	g.drawString("SHORE UP", 715, 1002);
	g.drawString("CAPTURE TREASURE", 867, 1002);
	g.drawString("GIVE TREASURE", 1025, 1002);
	g.setFont(new Font("TimesRoman",Font.PLAIN,25));
	g.drawString("MOVE", 560, 1002);
	
	g.setFont(new Font("TimesRoman",Font.PLAIN,30));
	g.drawString("Actions Left:", 320, 75);

	g.drawString(waterLevel, 320, 100);

		/*if (actions.get("Special Action") == true) {
			
		}*/
	g.setFont(new Font("TimesRoman",Font.BOLD,25));
	g.setColor(Color.RED);
	//for (int i = 0; i < 5; i++) { KEEP WHEN ADJUSTING create method that returns number it is and then print according to that after adjusting
		if (waterLevel.equals("2")) {
			g.drawImage(arrow,  1400,  615,  25,  15,  null); 
			//g.drawString(">", 1400, 615);

		}
		if (waterLevel.equals("4")) {
			g.drawImage(arrow,  1400,  473,  25,  15,  null); 
			//g.drawString(">", 1400, 480);
		}

		if (waterLevel.equals("3")) {
			g.drawImage(arrow,  1400,  557,  25,  15,  null); 
			//g.drawString(">", 1400, 570);
		}
		if (waterLevel.equals("5")) {
			g.drawImage(arrow,  1400,  425,  25,  15,  null); 
			//g.drawString(">", 1400, 570);
		}
	//}
	
	}
public void mousePressed(MouseEvent e) { }
public void mouseReleased(MouseEvent e) { }
public void mouseEntered(MouseEvent e) { }
public void mouseExited(MouseEvent e) { }
public void mouseClicked(MouseEvent e) {
	
	//for (int r = 0; r < allNums.length; r++) {
		//for (int c = 0; c < allNums[r].length; c++) {
			int x = e.getX();
			int y = e.getY();
			int w = getWidth();
			int h = getHeight();
			System.out.println("loc is ("+x+","+y+")" + w + " " + h);
			if (e.getButton() == e.BUTTON1) {
				if (x >= 60 && x <= 230 && y >= 534 && y <= 634) {
					if(choice1 == tcb) {
						choice1 = tcbs;
					}
					else {
						choice1 = tcb;
					}
				}			
				if (x >= 1225 && x <= 1395 && y >= 534 && y <= 634) {
					if(choice2 == fcb) {
						choice2 = fcbs;
					}
					else {
						choice2 = fcb;
					}
				}
				if (x >= 400 && x <= 550 && y >= 1030) {
					
				}
				}
		repaint();
	}
}


