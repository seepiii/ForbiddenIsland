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
	private BufferedImage blueTreasure, fireTreasure, airTreasure, earthTreasure;
	private BufferedImage arrow;
	private BufferedImage engTile;	
	private BufferedImage diver, diverSelect;
	private Map<String, BufferedImage> gameSquares;
	private static int seed, numPlayers;
	private static String waterLevel;
	private BufferedImage choice1, choice2;
	private BufferedImage p1, p2, p3, p4;
	
	private int[] pl1coords;
	private boolean[] playerTurn;
	private Map<String, Boolean> actions;
	private int x, y;
  //add other variables as needed
	private boolean moveTurn;
	
	private String currentMoveType;
	
	
	private String[][] board;
  
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
			blueTreasure = ImageIO.read(ForbiddenIslandPanel.class.getResource("/Image/Blue Treasure.png"));
			fireTreasure = ImageIO.read(ForbiddenIslandPanel.class.getResource("/Image/Fire Treasure.png"));
			airTreasure = ImageIO.read(ForbiddenIslandPanel.class.getResource("/Image/Air Treasure.png"));
			earthTreasure = ImageIO.read(ForbiddenIslandPanel.class.getResource("/Image/Earth Treasure.png"));
			engTile = ImageIO.read(ForbiddenIslandPanel.class.getResource("/Image/Engineer Icon.png"));
			diver = ImageIO.read(ForbiddenIslandPanel.class.getResource("/Image/Diver Icon.png"));
			diverSelect = ImageIO.read(ForbiddenIslandPanel.class.getResource("/Image/Diver Icon Select.png"));

		}
		catch(Exception E) {
			System.out.println("Exception Error");
			return;
		}
		choice1 = tcb;
		choice2 = fcb;
		p1 = diver;
		addMouseListener(this);
		/*actions.put("Special Action", false);
		actions.put("Move", false);
		actions.put("Shore Up", false);
		actions.put("Capture Treasure", false);
		actions.put("Give Treasure", false);*/
		//if ()
		/*playerTurn = new boolean[4];
		for (int i = 0; i < 4; i++) {
			playerTurn[i] = false;
		}*/
		moveTurn = false;
		currentMoveType = "";
		pl1coords = new int[2];
		pl1coords[0] = 501;
		pl1coords[1] = 20;
		
		
	board = new String[6][6];
	for (int r = 0; r < board.length; r++) {
		for (int c = 0; c < board[r].length; c++) {
			board[r][c] = "O";
		}
	}
	board[0][0] = "X";
	board[0][1] = "X";
	board[1][0] = "X";
	board[1][5] = "X";
	board[0][4] = "X";
	board[0][5] = "X";
	board[4][0] = "X";
	board[5][0] = "X";
	board[5][1] = "X";
	board[5][4] = "X";
	board[5][5] = "X";
	board[4][5] = "X";
	}
public void paint(Graphics g) {
	g.drawImage(tcb,  60,  314,  130,  77,  null);
	//g.drawImage(foolsLanding,  589,  13,  111,  117,  null); //-200 from width
	g.drawImage(choice1,  60,  314,  130,  77,  null);
	g.drawImage(foolsLanding,  500,  13,  90,  95,  null); //-200 from width
	g.drawImage(templeOfTheSun,  620,  13,  90,  95,  null); //-200 from width
	g.drawImage(fcb,  1000,  314,  130,  77,  null); //-200 from width
	g.drawImage(choice2,  1000,  314,  130,  77,  null); //-200 from width
	g.drawImage(waterLevelMeter,  1200,  180,  125,  325,  null); //-200 from width
	g.drawImage(blueB,  400,  670,  125,  50,  null); //-200 from width
	g.drawImage(blueB,  555,  670,  125,  50,  null); //-200 from width
	g.drawImage(blueB,  710,  670,  125,  50,  null); //-200 from width
	g.drawImage(blueB,  865,  670,  125,  50,  null); //-200 from width
	g.drawImage(blueB,  1020,  670,  125,  50,  null); //-200 from width
	g.drawImage(blueTreasure,  350,  70,  90,  100,  null);
	g.drawImage(fireTreasure,  800,  70,  90,  100,  null);
	g.drawImage(airTreasure,  350,  790,  90,  100,  null);
	g.drawImage(earthTreasure,  1150,  790,  90,  100,  null);
	g.drawImage(engTile,  1300,  680,  90,  90,  null);
	//g.drawImage(diver,  590,  20,  60,  87,  null);
	g.drawImage(p1,  pl1coords[0],  pl1coords[1],  49,  71,  null);

	
	System.out.println("Paint");
	g.setFont(new Font("TimesRoman",Font.PLAIN,12));
	g.drawString("SPECIAL ACTION", 405, 697);
	g.drawString("SHORE UP", 715, 697);
	g.drawString("CAPTURE TREASURE", 867, 697);
	g.drawString("GIVE TREASURE", 1025, 697);
	g.setFont(new Font("TimesRoman",Font.PLAIN,25));
	g.drawString("MOVE", 560, 697);
	
	g.setFont(new Font("TimesRoman",Font.PLAIN,30));
	g.drawString("Actions Left:", 320, 50);

	g.drawString(waterLevel, 500, 50);

		/*if (actions.get("Special Action") == true) {
			
		}*/
	g.setFont(new Font("TimesRoman",Font.BOLD,25));
	g.setColor(Color.RED);
	//for (int i = 0; i < 5; i++) { KEEP WHEN ADJUSTING create method that returns number it is and then print according to that after adjusting
		if (waterLevel.equals("2")) {
			g.drawImage(arrow,  1180,  445,  25,  15,  null); 
			//g.drawString(">", 1400, 615);

		}
		if (waterLevel.equals("4")) {
			g.drawImage(arrow,  1180,  303,  25,  15,  null); 
			//g.drawString(">", 1400, 480);
		}

		if (waterLevel.equals("3")) {
			g.drawImage(arrow,  1180,  387,  25,  15,  null); 
			//g.drawString(">", 1400, 570);
		}
		if (waterLevel.equals("5")) {
			g.drawImage(arrow,  1180,  255,  25,  15,  null); 
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
			 x = e.getX();
			 y = e.getY();
			int w = getWidth();
			int h = getHeight();
			System.out.println("loc is ("+x+","+y+")" + w + " " + h);
			if (e.getButton() == e.BUTTON1) {
				if (x >= 60 && x <= 190 && y >= 314 && y <= 414) {
					if(choice1 == tcb) {
						choice1 = tcbs;
					}
					else {
						choice1 = tcb;
					}
				}			
				if (x >= 1000 && x <= 1130 && y >= 314 && y <= 414) {
					if(choice2 == fcb) {
						choice2 = fcbs;
					}
					else {
						choice2 = fcb;
					}
				}
				if (x >= 400 && x < 550 && y >= 1030) {
					
				}
				if (x >= 550 && x <= 680 && y >= 665) {
					if(p1 == diver) {
						p1 = diverSelect;
						moveTurn = true;
						
					}
					else {
						p1 = diver;
						moveTurn = false;
					}
				}
				if (moveTurn == true && y < 595) {
					pl1coords[0] = x;
					pl1coords[1] = y;
					currentMoveType = "move"; 
				}
				}
		repaint();
	}
}