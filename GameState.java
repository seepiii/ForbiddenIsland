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
	public static Tile[] gameTiles;
	//public static Map<String, BufferedImage[]> tiles;
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

		tiles = Map.ofEntries(
				Map.entry("BreakersBridge", 	new BufferedImage[]{ImageIO.read(new File("/Images/Tiles/Breakers Bridge@2x.png")), ImageIO.read(new File("/Images/Tiles/Breakers Bridge_flood@2x.png"))}),
				Map.entry("BronzeGate", 	new BufferedImage[]{ImageIO.read(new File("/Images/Tiles/Bronze Gate@2x.png")), ImageIO.read(new File("/Images/Tiles/Bronze Gate_flood@2x.png"))}),
				Map.entry("CaveOfEmbers", new BufferedImage[]{ImageIO.read(new File("/Images/Tiles/Cave of Embers@2x.png")), ImageIO.read(new File("/Images/Tiles/Cave of Embers_flood@2x.png"))}),
				Map.entry("CaveOfShadows", new BufferedImage[]{ImageIO.read(new File("/Images/Tiles/Cave of Shadows@2x.png")), ImageIO.read(new File("/Images/Tiles/Cave of Shadows@2x.png"))}),
				Map.entry("CliffsOfAbandon", new BufferedImage[]{ImageIO.read(new File("/Images/Tiles/Cliffs of Abandon@2x.png")), ImageIO.read(new File("/Images/Tiles/Cliffs of Abandon_flood@2x.png"))}),
				Map.entry("CopperGate", 	new BufferedImage[]{ImageIO.read(new File("/Images/Tiles/Copper Gate@2x.png")), ImageIO.read(new File("/Images/Tiles/Copper Gate_flood@2x.png"))}),
				Map.entry("CoralPalace", new BufferedImage[]{ImageIO.read(new File("/Images/Tiles/Coral Palace@2x.png")), ImageIO.read(new File("/Images/Tiles/Coral Palace_flood@2x.png"))}),
				Map.entry("CrimsonForest", new BufferedImage[]{ImageIO.read(new File("/Images/Tiles/Crimson Forest@2x.png")), ImageIO.read(new File("/Images/Tiles/Crimson Forest_flood@2x.png"))}),
				Map.entry("DunesOfDeception", new BufferedImage[]{ImageIO.read(new File("/Images/Tiles/Dunes of Deception@2x.png")), ImageIO.read(new File("/Images/Tiles/Dunes of Deception_flood@2x.png"))}),
				Map.entry("FoolsLanding", new BufferedImage[]{ImageIO.read(new File("/Images/Tiles/Fools_ Landing@2x.png")), ImageIO.read(new File("/Images/Tiles/Fools_ Landing_flood@2x.png"))}),
				Map.entry("GoldGate", new BufferedImage[]{ImageIO.read(new File("/Images/Tiles/Gold Gate@2x.png")), ImageIO.read(new File("/Images/Tiles/Gold Gate_flood@2x.png"))}),
				Map.entry("HowlingGarden", new BufferedImage[]{ImageIO.read(new File("/Images/Tiles/Howling Garden@2x.png")), ImageIO.read(new File("/Images/Tiles/Howling Garden_flood@2x.png"))}),
				Map.entry("IronGate", new BufferedImage[]{ImageIO.read(new File("/Images/Tiles/Iron Gate@2x.png")), ImageIO.read(new File("/Images/Tiles/Iron Gate_flood@2x.png"))}),
				Map.entry("LostLagoon", new BufferedImage[]{ImageIO.read(new File("/Images/Tiles/Lost Lagoon@2x.png")), ImageIO.read(new File("/Images/Tiles/Lost Lagoon_flood@2x.png"))}),
				Map.entry("MistyMarsh", new BufferedImage[]{ImageIO.read(new File("/Images/Tiles/Misty Marsh@2x.png")), ImageIO.read(new File("/Images/Tiles/Misty Marsh_flood@2x.png"))}),
				Map.entry("Observatory", new BufferedImage[]{ImageIO.read(new File("/Images/Tiles/Observatory@2x.png")), ImageIO.read(new File("/Images/Tiles/Observatory_flood@2x.png"))}),
				Map.entry("PhantomRock", new BufferedImage[]{ImageIO.read(new File("/Images/Tiles/Phantom Rock@2x.png")), ImageIO.read(new File("/Images/Tiles/Phantom Rock_flood@2x.png"))}),
				Map.entry("SilverGate", new BufferedImage[]{ImageIO.read(new File("/Images/Tiles/Silver Gate@2x.png")), ImageIO.read(new File("/Images/Tiles/Silver Gate_flood@2x.png"))}),
				Map.entry("TempleOfTheMoon", new BufferedImage[]{ImageIO.read(new File("/Images/Tiles/Temple of the Moon@2x.png")), ImageIO.read(new File("/Images/Tiles/Temple of the Moon_flood@2x.png"))}),
				Map.entry("TempleOfTheSun", new BufferedImage[]{ImageIO.read(new File("/Images/Tiles/Temple of the Sun@2x.png")), ImageIO.read(new File("/Images/Tiles/Temple of the Sun_flood@2x.png"))}),
				Map.entry("TidalPalace", new BufferedImage[]{ImageIO.read(new File("/Images/Tiles/Tidal Palace@2x.png")), ImageIO.read(new File("/Images/Tiles/Tidal Palace_flood@2x.png"))}),
				Map.entry("TwilightHollow", new BufferedImage[]{ImageIO.read(new File("/Images/Tiles/Twilight Hollow@2x.png")), ImageIO.read(new File("/Images/Tiles/Twilight Hollow_flood@2x.png"))}),
				Map.entry("Watchtower", new BufferedImage[]{ImageIO.read(new File("/Images/Tiles/Watchtower@2x.png")), ImageIO.read(new File("/Images/Tiles/Watchtower_flood@2x.png"))}),
				Map.entry("WhisperingGarden", new BufferedImage[]{ImageIO.read(new File("/Images/Tiles/Whispering Garden@2x.png")), ImageIO.read(new File("/Images/Tiles/Whispering Garden_flood@2x.png"))}),
				Map.entry("Sunk", new BufferedImage[]{ImageIO.read(new File("/Images/Tiles/extra/Tile_Flood_Water@2x.png"))})
		);

		String[] randomizedTiles = new String[]{"MistyMarsh", "Observatory", "IronGate", "TidalPalace", "CrimsonForest",
				"BreakersBridge", "CaveOfEmbers", "TwilightHollow", "DunesOfDeception",
				"TempleOfTheMoon", "LostLagoon", "CaveOfShadows", "PhantomRock", "SilverGate",
				"Watchtower", "CopperGate", "CliffsOfAbandon", "WhisperingGarden", "TempleOfTheSun",
				"CoralPalace", "GoldGate", "FoolsLanding", "HowlingGarden", "BronzeGate"};

		//shuffle
		List<String> tileShuffler = Arrays.asList(randomizedTiles);
		Collections.shuffle(tileShuffler);
		randomizedTiles = tileShuffler.toArray(new String[tileShuffle.size()]);

		int[][] pos = new int[][]{
				{0, 2}, {0, 3}, {1, 1}, {1, 2}, {1, 3}, {1, 4}, {2, 0}, {2, 1}, {2, 2}, {2, 3}, {2, 4}, {2, 5}, {3, 0}, {3, 1}, {3, 2}, {3, 3}, {3, 4}, {3, 5}, {4, 1}, {4, 2}, {4, 3}, {4, 4}, {5, 2}, {5, 3}
		};

		gameTiles = new Tile[24];

		for(int i = 0; i < 24; i++){
			BufferedImage[] br = tiles.get(randomizedTiles[i]);
			gameTiles[i] = new Tile(randomizedTiles[i], br[0], br[1], pos[i]);
		}




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
	public FloodCard drawFloodCard() {
		FloodCard fc = floodCards.drawCard();
		return fc;
	}
	
	//get methods
	public int getTick() {
		return tick;
	}
}
