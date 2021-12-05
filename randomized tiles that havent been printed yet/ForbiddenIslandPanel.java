import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;
import java.awt.Font;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

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
	//	private static int seed, numPlayers;
//	private static int waterLevel;
	private BufferedImage choice1, choice2;
	private BufferedImage p1, p2, p3, p4;

	private int[] pl1coords;
	private boolean[] playerTurn;
	private Map<String, Boolean> actions;
	private int x, y;
	//add other variables as needed
	private boolean moveTurn;
	private boolean tcDraw, fcDraw;
	private String currentMoveType;

	private BufferedImage fireTC, earthTC, waterTC, airTC, watersRiseTC, sandbagTC, heliTC;

	private String[][] board;
	private int[] xTileCoords= {260, 380, 500, 620, 740, 860};
	private int[] yTileCoords = {13, 121, 229, 337, 445, 553};


	private ArrayList<BufferedImage> tiles = new ArrayList<>();

	private Stack<BufferedImage> treasureCards = new Stack<>();
	private boolean toPush, toPushFlood;

	private GameState gamestate;

	public ForbiddenIslandPanel(String w) throws IOException {
//		seed=s;
		gamestate=new GameState(w);
		//treasureCards = gs.fillUp();
		//add everything else that happens in the constructor (written by sampadaa?)
		try {
			tcb = ImageIO.read(ForbiddenIslandPanel.class.getResource("Image/Card_Back@2x (3).png"));
			System.out.println("Constructor");
			tcbs = ImageIO.read(ForbiddenIslandPanel.class.getResource("Image/Card_BackSelect@2x.png"));
			foolsLanding = ImageIO.read(ForbiddenIslandPanel.class.getResource("Image/Foo's Landing.png"));
			templeOfTheSun = ImageIO.read(ForbiddenIslandPanel.class.getResource("Image/Temple of the Sun.png"));
			fcb = ImageIO.read(ForbiddenIslandPanel.class.getResource("Image/Flood Card Back.png"));
			fcbs = ImageIO.read(ForbiddenIslandPanel.class.getResource("Image/Flood Card Back Select.png"));
			waterLevelMeter = ImageIO.read(ForbiddenIslandPanel.class.getResource("Image/Water Level Meter.png"));
			blueB = ImageIO.read(ForbiddenIslandPanel.class.getResource("Image/Blue Background.png"));
			arrow = ImageIO.read(ForbiddenIslandPanel.class.getResource("Image/Weird Arrow.png"));
			blueTreasure = ImageIO.read(ForbiddenIslandPanel.class.getResource("Image/Blue Treasure.png"));
			fireTreasure = ImageIO.read(ForbiddenIslandPanel.class.getResource("Image/Fire Treasure.png"));
			airTreasure = ImageIO.read(ForbiddenIslandPanel.class.getResource("Image/Air Treasure.png"));
			earthTreasure = ImageIO.read(ForbiddenIslandPanel.class.getResource("Image/Earth Treasure.png"));
			engTile = ImageIO.read(ForbiddenIslandPanel.class.getResource("Image/Engineer Icon.png"));
			diver = ImageIO.read(ForbiddenIslandPanel.class.getResource("Image/Diver Icon.png"));
			diverSelect = ImageIO.read(ForbiddenIslandPanel.class.getResource("Image/Diver Icon Select.png"));
			fireTC = ImageIO.read(ForbiddenIslandPanel.class.getResource("Image/Fire Treasure Card.png"));
			earthTC = ImageIO.read(ForbiddenIslandPanel.class.getResource("Image/Earth Treasure Card.png"));
			waterTC = ImageIO.read(ForbiddenIslandPanel.class.getResource("Image/Ocean Treasure Card.png"));
			airTC = ImageIO.read(ForbiddenIslandPanel.class.getResource("Image/Wind Treasure Card.png"));
			watersRiseTC = ImageIO.read(ForbiddenIslandPanel.class.getResource("Image/Waters Rise TC.png"));
			sandbagTC = ImageIO.read(ForbiddenIslandPanel.class.getResource("Image/Sandbag TC.png"));
			heliTC = ImageIO.read(ForbiddenIslandPanel.class.getResource("Image/Helicopter Lift.png"));
			HashMap<String, BufferedImage> tiles2 = new HashMap<String, BufferedImage>();
			tiles2.put("BreakersBridge", 	ImageIO.read(new File("/Image/Breakers Bridge@2x.png")));
			tiles2.put("BronzeGate", ImageIO.read(new File("/Image/Bronze Gate@2x.png")) );
			tiles2.put("CaveOfEmbers", ImageIO.read(new File("/Image/Cave of Embers@2x.png")));
			tiles2.put("CaveOfShadows", ImageIO.read(new File("/Image/Cave of Embers@2x.png")));
			tiles2.put("CliffsOfAbandon", ImageIO.read(new File("/Image/Cliffs of Abandon@2x.png")));
			tiles2.put("CopperGate", ImageIO.read(new File("/Image/Copper Gate@2x.png")));
			tiles2.put("CoralPalace", ImageIO.read(new File("/Image/Coral Palace@2x.png")));
			tiles2.put("CrimsonForest", ImageIO.read(new File("/Image/Crimson Forest@2x.png")));
			tiles2.put("DunesOfDeception",ImageIO.read(new File("/Image/Dunes of Deception@2x.png")) );
			tiles2.put("FoolsLanding", ImageIO.read(new File("/Image/Fools_ Landing@2x.png")));
			tiles2.put("GoldGate",ImageIO.read(new File("/Image/Gold Gate@2x.png")));
			tiles2.put("HowlingGarden",ImageIO.read(new File("/Image/Howling Garden@2x.png")));
			tiles2.put("IronGate", ImageIO.read(new File("/Image/Iron Gate@2x.png")));
			tiles2.put("LostLagoon", ImageIO.read(new File("/Image/Lost Lagoon@2x.png")));
			tiles2.put("MistyMarsh", ImageIO.read(new File("/Image/Misty Marsh@2x.png")));
			tiles2.put("Observatory", ImageIO.read(new File("/Image/Observatory@2x.png")));
			tiles2.put("PhantomRock", ImageIO.read(new File("/Image/Phantom Rock@2x.png")));
			tiles2.put("SilverGate",ImageIO.read(new File("/Image/Silver Gate@2x.png")));
			tiles2.put("TempleOfTheMoon", ImageIO.read(new File("/Image/Temple of the Moon@2x.png")));
			tiles2.put("TempleOfTheSun", ImageIO.read(new File("/Image/Temple of the Sun@2x.png")));
			tiles2.put("TidalPalace", ImageIO.read(new File("/Image/Tidal Palace@2x.png")));
			tiles2.put("TwilightHollow",ImageIO.read(new File("/Image/Twilight Hollow@2x.png")) );
			tiles2.put("Watchtower",ImageIO.read(new File("/Image/Watchtower@2x.png")) );
			tiles2.put("WhisperingGarden", ImageIO.read(new File("/Image/Whispering Garden@2x.png")));
			tiles2.put("Sunk",ImageIO.read(new File("/Image/Tile_Flood_Water@2x.png")));
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
		tcDraw = false;
		toPush = false;
		toPushFlood = false;
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

		//treasureCards = new Stack<>();
		//fillUp(treasureCards);
	/*xTileCoords = new int[6];
	xTileCoords = {260, 380, 500, 620, 740, 860};*/
		//treasureCards=fillUp();
		//Stack<BufferedImage> tem = fillUp();
	/*for (int i = 0; i < fillUp().size(); i++) {
		treasureCards.push(fillUp().pop());
	}*/
	}
	/*public Stack<BufferedImage> fillUp () {
		Stack<BufferedImage> input=new Stack<BufferedImage>();
		int cnt = 0;
		int cntF = 0;
		int cntW = 0;
		int cntE = 0;
		int cntA = 0;
		int cntWR = 0;
		int cntS = 0;
		int cntH = 0;
		Random rand=new Random(seed);
		while (cnt < 33) {
		
		int temp=rand.nextInt(7)+1;
		
		if (temp == 1 && cntF < 5) {
			input.push(fireTC);
			cntF++;
			cnt++;
		}
		if (temp == 2 && cntW < 5) {
			input.push(waterTC);
			cntW++;
			cnt++;
		}
		if (temp == 3 && cntE < 5) {
			input.push(earthTC);
			cntE++;
			cnt++;
		}
		if (temp == 4 && cntA < 5) {
			input.push(airTC);
			cntA++;
			cnt++;
		}
		if (temp == 5 && cntWR < 3) {
			input.push(watersRiseTC);
			cntWR++;
			cnt++;
		}
		if (temp == 6 && cntS < 2) {
			input.push(sandbagTC);
			cntS++;
			cnt++;
		}
		if (temp == 7 && cntH < 3) {
			input.push(heliTC);
			cntH++;
			cnt++;
		}
		}
		return input;
	}*/
	public void paint(Graphics g) {
	/*g.setColor(Color.WHITE);
	g.fillRect(0,0,1350,740);
	g.drawImage(tcb,  60,  314,  130,  77,  null);*/
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
		g.drawImage(airTreasure,  350,  470,  90,  100,  null);
		g.drawImage(earthTreasure,  800,  470,  90,  100,  null);
		g.drawImage(engTile,  1300,  680,  90,  90,  null);
		//g.drawImage(diver,  590,  20,  60,  87,  null);
		//LINE FUCKING 245 WAIT THAT SIT 
		//g.drawImage(p1,  pl1coords[0],  pl1coords[1],  49,  71, null);

		g.drawImage(blueB,  245,  670,  125,  50,  null); //-200 from width


		System.out.println("Paint");
		g.setFont(new Font("TimesRoman",Font.PLAIN,12));
		g.drawString("SPECIAL ACTION", 405, 697);
		g.drawString("SHORE UP", 715, 697);
		g.drawString("CAPTURE TREASURE", 867, 697);
		g.drawString("GIVE TREASURE", 1025, 697);
		g.setFont(new Font("TimesRoman",Font.PLAIN,25));
		g.drawString("MOVE", 560, 697);
		g.drawString("DRAW", 250, 697);
		g.setFont(new Font("TimesRoman",Font.PLAIN,30));
		g.drawString("Actions Left:", 320, 50);

		//g.drawString(""+waterLevel, 485, 50); print actions left instead


		if (toPush == true && y >= 660 && x < 400 && x >= 245) {
			g.drawImage(gamestate.drawTreasureCard().getImage(), 400, 314, 77, 130, null);
		}
		if (toPushFlood == true && y >= 660 && x < 400 && x >= 245) {
			g.drawImage(gamestate.drawFloodCard().getImage(), 600, 314, 77, 130, null);
		}
		/*if (actions.get("Special Action") == true) {
			
		}*/
		g.setFont(new Font("TimesRoman",Font.BOLD,25));
		g.setColor(Color.RED);
		//for (int i = 0; i < 5; i++) { KEEP WHEN ADJUSTING create method that returns number it is and then print according to that after adjusting
		if (gamestate.getTick()==1) {
			g.drawImage(arrow,  1180,  445,  25,  15,  null);
			//g.drawString(">", 1400, 615);
		}
		else if (gamestate.getTick()==2) {
			g.drawImage(arrow,  1180,  416,  25,  15,  null);
		}
		else if (gamestate.getTick()==3) {
			g.drawImage(arrow,  1180,  387,  25,  15,  null);
			//g.drawString(">", 1400, 570);
		}
		else if (gamestate.getTick()==4) {
			g.drawImage(arrow,  1180,  358,  25,  15,  null);
		}
		else if (gamestate.getTick()==5) {
			g.drawImage(arrow,  1180,  332,  25,  15,  null);
		}
		else if (gamestate.getTick()==6) {
			g.drawImage(arrow,  1180,  306,  25,  15,  null);
			//g.drawString(">", 1400, 480);
		}
		else if (gamestate.getTick()==7) {
			g.drawImage(arrow,  1180,  280,  25,  15,  null);
		}
		else if (gamestate.getTick()==8) {
			g.drawImage(arrow,  1180,  255,  25,  15,  null);
			//g.drawString(">", 1400, 570);
		}
		else if (gamestate.getTick()==9) {
			g.drawImage(arrow,  1180,  229,  25,  15,  null);
		}
		else {
			g.drawImage(arrow,  1180,  200,  25,  15,  null);
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
					tcDraw = true;
				}
				else {
					choice1 = tcb;
					tcDraw = false;
				}
			}
			if (x >= 1000 && x <= 1130 && y >= 314 && y <= 414) {
				if(choice2 == fcb) {
					choice2 = fcbs;
					fcDraw = true;
				}
				else {
					choice2 = fcb;
					fcDraw = false;
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
			if (tcDraw == true && x < 400 && x >= 245 && y >= 665) {
				toPush = true;
			}
			if (tcDraw == false && x < 400 && x >= 245 && y >= 665) {
				toPush = false;
			}

			if (fcDraw == true && x < 400 && x >= 245 && y >= 665) {
				toPushFlood = true;
			}
			if (fcDraw == false && x < 400 && x >= 245 && y >= 665) {
				toPushFlood = false;
			}

		}
		repaint();
	}
}