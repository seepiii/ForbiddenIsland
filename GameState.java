import java.awt.image.BufferedImage;
import java.util.Random;
import java.util.Stack;
import java.util.ArrayList;
import java.util.HashMap;

import javax.imageio.ImageIO;
public class GameState {
	private BufferedImage fireTC, earthTC, waterTC, airTC, watersRiseTC, sandbagTC, heliTC;
//	private int seed;
	private int waterLevel, tick;
	//board
	private char[][] boardState;
	private ArrayList<Tile> tiles;
	//players
	private ArrayList<Player> allPlayerTypes=new ArrayList<>();
	private Player player1;
	private Player player2;
	private Player player3;
	private Player player4;
	//decks
	private FloodCardDeck floodCards;
	private TreasureCardDeck treasureCards;
	
	private boolean lose=false;
	private HashMap<String, Treasure> treasures;
	
	public GameState(String w) {
//		seed=s;
		//setting water level
		if (w.equals("Novice")) {
			tick=1;
			waterLevel=2;
		}
		else if (w.equals("Normal")) {
			tick=2;
			waterLevel=2;
		}
		else if (w.equals("Elite")) {
			tick=3;
			waterLevel=3;
		}
		else if (w.equals("Legendary")) {
			tick=4;
			waterLevel=3;
		}
		//reading in images?
		try {
		airTC = ImageIO.read(ForbiddenIslandPanel.class.getResource("/Image/Wind Treasure Card.png"));
		earthTC = ImageIO.read(ForbiddenIslandPanel.class.getResource("/Image/Earth Treasure Card.png"));
		fireTC = ImageIO.read(ForbiddenIslandPanel.class.getResource("/Image/Fire Treasure Card.png"));
		waterTC = ImageIO.read(ForbiddenIslandPanel.class.getResource("/Image/Ocean Treasure Card.png"));
		sandbagTC = ImageIO.read(ForbiddenIslandPanel.class.getResource("/Image/Sandbag TC.png"));
		heliTC = ImageIO.read(ForbiddenIslandPanel.class.getResource("/Image/Helicopter Lift.png"));
		watersRiseTC = ImageIO.read(ForbiddenIslandPanel.class.getResource("/Image/Waters Rise TC.png"));
		}
		catch(Exception E) {
			System.out.println("GameState Exception Error");
			return;
		}
		//make treasure card deck
		treasureCards=new TreasureCardDeck(airTC, earthTC, fireTC, waterTC, sandbagTC, heliTC, watersRiseTC);
		floodCards=new FloodCardDeck();
	}
	public boolean checkIfLost() {
		return lose;
	}
	public void makeWaterRise() {
		tick++;
		if (tick==1||tick==2) {
			waterLevel=2;
		}
		else if (tick<=5) {
			waterLevel=3;
		}
		else if (tick<=7) {
			waterLevel=4;
		}
		else if (tick<=9) {
			waterLevel=5;
		}
		else {
			lose=true;
		}
		
	}
	public TreasureCard drawTreasureCard() {
		TreasureCard tc=treasureCards.drawCard();
		if (tc.isWaterRises()) {
			makeWaterRise();
		}
		if (tc.isAction()) {
			
		}
		return tc;
	}
	//should draw the number of cards and make the corresponding tile flooded or sunk and change the letter in board
	public void drawFloodCards() {
		
	}
	
	//get methods
	public int getTick() {
		return tick;
	}
}