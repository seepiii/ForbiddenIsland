import java.awt.image.BufferedImage;
import java.util.Random;
import java.util.Stack;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import javax.imageio.ImageIO;
public class GameState {
//	private BufferedImage fireTC, earthTC, waterTC, airTC, watersRiseTC, sandbagTC, heliTC;
	private BufferedImage tileWater;
	public static int waterLevel, tick, actionsLeft;
	//board
	private char[][] boardState=new char[6][6];
	private ArrayList<Tile> listOfTiles=new ArrayList<>();
	public static Tile[][] tiles=new Tile[6][6];
	//players
	private int playerCount=1;
	private ArrayList<Player> allPlayerTypes=new ArrayList<>();
	public static Player player1, player2, player3, player4, currentPlayer;
	//decks
	public static FloodCardDeck floodCards;
	public static TreasureCardDeck treasureCards;
	
	public static boolean lose=false;
	public static Treasure waterTreasure, fireTreasure, airTreasure, earthTreasure;
	//tiles
	private Tile breakersBridge, bronzeGate, caveOfEmbers, caveOfShadows, 
	cliffsOfAbandon, copperGate, coralPalace, crimsonForest, 
	dunesOfDeception, foolsLanding, goldGate, howlingGarden, 
	ironGate, lostLagoon, mistyMarsh, observatory, 
	phantomRock, silverGate, tidalPalace, templeOfTheMoon, 
	templeOfTheSun, twilightHollow, watchtower, whisperingGarden;
	
	private BufferedImage fireTC, earthTC, waterTC, airTC, watersRiseTC, sandbagTC, heliTC;
	
	public GameState(String w) {
		Player diver, explorer, engineer, messenger, navigator, pilot;
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
			//treasure card images
			airTC = ImageIO.read(ForbiddenIslandPanel.class.getResource("/Image/Wind Treasure Card.png"));
			earthTC = ImageIO.read(ForbiddenIslandPanel.class.getResource("/Image/Earth Treasure Card.png"));
			fireTC = ImageIO.read(ForbiddenIslandPanel.class.getResource("/Image/Fire Treasure Card.png"));
			waterTC = ImageIO.read(ForbiddenIslandPanel.class.getResource("/Image/Ocean Treasure Card.png"));
			sandbagTC = ImageIO.read(ForbiddenIslandPanel.class.getResource("/Image/Sandbag TC.png"));
			heliTC = ImageIO.read(ForbiddenIslandPanel.class.getResource("/Image/Helicopter Lift.png"));
			watersRiseTC = ImageIO.read(ForbiddenIslandPanel.class.getResource("/Image/Waters Rise TC.png"));
			
			tileWater=ImageIO.read(ForbiddenIslandPanel.class.getResource("/Image/Tile_Flood_Water@2x.png"));
		}	
		catch(Exception E) {
			System.out.println("GameState Exception Error");
			return;
		}
		try {
			//tiles
			breakersBridge=new Tile("Breakers Bridge", ImageIO.read(ForbiddenIslandPanel.class.getResource("/Image/Breakers Bridge@2x.png")), ImageIO.read(ForbiddenIslandPanel.class.getResource("/Image/Breakers Bridge_flood@2x.png")));
			bronzeGate=new Tile("Bronze Gate", ImageIO.read(ForbiddenIslandPanel.class.getResource("/Image/Bronze Gate@2x.png")), ImageIO.read(ForbiddenIslandPanel.class.getResource("/Image/Bronze Gate_flood@2x.png")));
			caveOfEmbers=new Tile("Cave of Embers", ImageIO.read(ForbiddenIslandPanel.class.getResource("/Image/Cave of Embers@2x.png")), ImageIO.read(ForbiddenIslandPanel.class.getResource("/Image/Cave of Embers_flood@2x.png")));
			caveOfShadows=new Tile("Cave of Shadows", ImageIO.read(ForbiddenIslandPanel.class.getResource("/Image/Cave of Shadows@2x.png")), ImageIO.read(ForbiddenIslandPanel.class.getResource("/Image/Cave of Shadows_flood@2x.png")));
			cliffsOfAbandon=new Tile("Cliffs of Abandon", ImageIO.read(ForbiddenIslandPanel.class.getResource("/Image/Cliffs of Abandon@2x.png")), ImageIO.read(ForbiddenIslandPanel.class.getResource("/Image/Cliffs of Abandon_flood@2x.png")));
			copperGate=new Tile("Copper Gate", ImageIO.read(ForbiddenIslandPanel.class.getResource("/Image/Copper Gate@2x.png")), ImageIO.read(ForbiddenIslandPanel.class.getResource("/Image/Copper Gate_flood@2x.png")));
			coralPalace=new Tile("Coral Palace", ImageIO.read(ForbiddenIslandPanel.class.getResource("/Image/Coral Palace@2x.png")), ImageIO.read(ForbiddenIslandPanel.class.getResource("/Image/Coral Palace_flood@2x.png")));
			crimsonForest=new Tile("Crimson Forest", ImageIO.read(ForbiddenIslandPanel.class.getResource("/Image/Crimson Forest@2x.png")), ImageIO.read(ForbiddenIslandPanel.class.getResource("/Image/Crimson Forest_flood@2x.png")));
			dunesOfDeception=new Tile("Dunes of Deception", ImageIO.read(ForbiddenIslandPanel.class.getResource("/Image/Dunes of Deception@2x.png")), ImageIO.read(ForbiddenIslandPanel.class.getResource("/Image/Dunes of Deception_flood@2x.png")));
			foolsLanding=new Tile("Fools Landing", ImageIO.read(ForbiddenIslandPanel.class.getResource("/Image/Fools' Landing@2x.png")), ImageIO.read(ForbiddenIslandPanel.class.getResource("/Image/Fools' Landing_flood@2x.png")));
			goldGate=new Tile("Gold Gate", ImageIO.read(ForbiddenIslandPanel.class.getResource("/Image/Gold Gate@2x.png")), ImageIO.read(ForbiddenIslandPanel.class.getResource("/Image/Gold Gate_flood@2x.png")));
			howlingGarden=new Tile("Howling Garden", ImageIO.read(ForbiddenIslandPanel.class.getResource("/Image/Howling Garden@2x.png")), ImageIO.read(ForbiddenIslandPanel.class.getResource("/Image/Howling Garden_flood@2x.png")));
			ironGate=new Tile("Iron Gate", ImageIO.read(ForbiddenIslandPanel.class.getResource("/Image/Iron Gate@2x.png")), ImageIO.read(ForbiddenIslandPanel.class.getResource("/Image/Iron Gate_flood@2x.png")));
			lostLagoon=new Tile("Lost Lagoon", ImageIO.read(ForbiddenIslandPanel.class.getResource("/Image/Lost Lagoon@2x.png")), ImageIO.read(ForbiddenIslandPanel.class.getResource("/Image/Lost Lagoon_flood@2x.png")));
			mistyMarsh=new Tile("Misty Marsh", ImageIO.read(ForbiddenIslandPanel.class.getResource("/Image/Misty Marsh@2x.png")), ImageIO.read(ForbiddenIslandPanel.class.getResource("/Image/Misty Marsh_flood@2x.png")));
			observatory=new Tile("Observatory", ImageIO.read(ForbiddenIslandPanel.class.getResource("/Image/Observatory@2x.png")), ImageIO.read(ForbiddenIslandPanel.class.getResource("/Image/Observatory_flood@2x.png")));
			phantomRock=new Tile("Phantom Rock", ImageIO.read(ForbiddenIslandPanel.class.getResource("/Image/Phantom Rock@2x.png")), ImageIO.read(ForbiddenIslandPanel.class.getResource("/Image/Phantom Rock_flood@2x.png")));
			silverGate=new Tile("Silver Gate", ImageIO.read(ForbiddenIslandPanel.class.getResource("/Image/Silver Gate@2x.png")), ImageIO.read(ForbiddenIslandPanel.class.getResource("/Image/Silver Gate_flood@2x.png")));
			tidalPalace=new Tile("Tidal Palace", ImageIO.read(ForbiddenIslandPanel.class.getResource("/Image/Tidal Palace@2x.png")), ImageIO.read(ForbiddenIslandPanel.class.getResource("/Image/Tidal Palace_flood@2x.png")));
			templeOfTheMoon=new Tile("Temple of the Moon", ImageIO.read(ForbiddenIslandPanel.class.getResource("/Image/Temple of the Moon@2x.png")), ImageIO.read(ForbiddenIslandPanel.class.getResource("/Image/Temple of the Moon_flood@2x.png")));
			templeOfTheSun=new Tile("Temple of the Sun", ImageIO.read(ForbiddenIslandPanel.class.getResource("/Image/Temple of the Sun@2x.png")), ImageIO.read(ForbiddenIslandPanel.class.getResource("/Image/Temple of the Sun_flood@2x.png")));
			twilightHollow=new Tile("Twilight Hollow", ImageIO.read(ForbiddenIslandPanel.class.getResource("/Image/Twilight Hollow@2x.png")), ImageIO.read(ForbiddenIslandPanel.class.getResource("/Image/Twilight Hollow_flood@2x.png")));
			watchtower=new Tile("Watchtower", ImageIO.read(ForbiddenIslandPanel.class.getResource("/Image/Watchtower@2x.png")), ImageIO.read(ForbiddenIslandPanel.class.getResource("/Image/Watchtower_flood@2x.png")));
			whisperingGarden=new Tile("Whispering Garden", ImageIO.read(ForbiddenIslandPanel.class.getResource("/Image/Whispering Garden@2x.png")), ImageIO.read(ForbiddenIslandPanel.class.getResource("/Image/Whispering Garden_flood@2x.png")));
		}
		catch(Exception e) {
			System.out.println("Tile Error");
			return;
		}
		try {
			diver=new Player(ImageIO.read(ForbiddenIslandPanel.class.getResource("/Image/Diver Icon.png")), "black", "Diver");
			engineer=new Player(ImageIO.read(ForbiddenIslandPanel.class.getResource("/Image/Engineer Icon.png")), "red", "Engineer");
			explorer=new Player(ImageIO.read(ForbiddenIslandPanel.class.getResource("/Image/Explorer Icon.png")), "green", "Explorer");
			messenger=new Player(ImageIO.read(ForbiddenIslandPanel.class.getResource("/Image/Messenger Icon.png")), "white", "Messenger");
			navigator=new Player(ImageIO.read(ForbiddenIslandPanel.class.getResource("/Image/Navigator Icon.png")), "yellow", "Navigator");
			pilot=new Player(ImageIO.read(ForbiddenIslandPanel.class.getResource("/Image/Pilot Icon.png")), "blue", "Pilot");
		}
		catch(Exception e) {
			System.out.println("Player Image Error");
			return;
		}
		try {
			waterTreasure = new Treasure("Water", ImageIO.read(GameState.class.getResource("Image/Blue Treasure.png")), ImageIO.read(GameState.class.getResource("Image/Unclaimed Water Treasure.png")));
			fireTreasure = new Treasure("Fire", ImageIO.read(ForbiddenIslandPanel.class.getResource("Image/Fire Treasure.png")), ImageIO.read(GameState.class.getResource("Image/Unclaimed Fire Treasure.png")));
			airTreasure = new Treasure("Air", ImageIO.read(ForbiddenIslandPanel.class.getResource("Image/Air Treasure.png")), ImageIO.read(GameState.class.getResource("Image/Unclaimed Earth Treasure.png")));
			earthTreasure = new Treasure("Earth", ImageIO.read(ForbiddenIslandPanel.class.getResource("Image/Earth Treasure.png")), ImageIO.read(GameState.class.getResource("Image/Unclaimed Air Treasure.png")));
		}
		catch(Exception e) {
			System.out.println("Treasure Error");
			return;
		}
		//makes card decks
		treasureCards=new TreasureCardDeck(airTC, earthTC, fireTC, waterTC, sandbagTC, heliTC, watersRiseTC);
		floodCards=new FloodCardDeck();
		//randomizes tiles and stores them
		listOfTiles.add(breakersBridge);
		listOfTiles.add(bronzeGate);
		listOfTiles.add(whisperingGarden);
		listOfTiles.add(watchtower);
		listOfTiles.add(templeOfTheSun);
		listOfTiles.add(templeOfTheMoon);
		listOfTiles.add(tidalPalace);
		listOfTiles.add(silverGate);
		listOfTiles.add(observatory);
		listOfTiles.add(ironGate);
		listOfTiles.add(howlingGarden);
		listOfTiles.add(goldGate);
		listOfTiles.add(dunesOfDeception);
		listOfTiles.add(crimsonForest);
		listOfTiles.add(coralPalace);
		listOfTiles.add(copperGate);
		listOfTiles.add(caveOfShadows);
		listOfTiles.add(caveOfEmbers);
		listOfTiles.add(twilightHollow);
		listOfTiles.add(phantomRock);
		listOfTiles.add(mistyMarsh);
		listOfTiles.add(lostLagoon);
		listOfTiles.add(foolsLanding);
		listOfTiles.add(cliffsOfAbandon);
		Collections.shuffle(listOfTiles);
		int cnt=0;
		for (int r=0; r<6; r++) {
			for (int c=0; c<6; c++) {
				if ((r==0&&c==0)||(r==0&&c==1)||(r==1&&c==0)||
					(r==0&&c==4)||(r==0&&c==5)||(r==1&&c==5)||
					(r==5&&c==0)||(r==4&&c==0)||(r==5&&c==1)||
					(r==5&&c==5)||(r==5&&c==4)||(r==4&&c==5)) {
					tiles[r][c]=null;
					boardState[r][c]='X';
				}
				else {
					tiles[r][c]=listOfTiles.get(cnt);
					cnt++;
					boardState[r][c]='O';
				}
			}
		}
		int count=0;
		while (count<6) {
			FloodCard fc=floodCards.drawCard();
			for (int r=0; r<6; r++) {
				for (int c=0; c<6; c++) {
					if (tiles[r][c]!=null&&tiles[r][c].getName().equals(fc.getPlaceName())) {
						tiles[r][c].flood();
					}
				}
			}
			count++;
		}
		//makes and randomizes players
		allPlayerTypes.add(diver);
		allPlayerTypes.add(explorer);
		allPlayerTypes.add(engineer);
		allPlayerTypes.add(messenger);
		allPlayerTypes.add(navigator);
		allPlayerTypes.add(pilot);
		Collections.shuffle(allPlayerTypes);
		player1=allPlayerTypes.get(0);
		player2=allPlayerTypes.get(1);
		player3=allPlayerTypes.get(2);
		player4=allPlayerTypes.get(3);
		currentPlayer=player1;
		//sets players to the tile locations
		for (int r=0; r<6; r++) {
			for (int c=0; c<6; c++) {
				if (tiles[r][c]!=null) {
					if (tiles[r][c].getName().equals("Bronze Gate")) {
						if (player1.getColor().equals("red"))
							player1.setCoords(r, c);
						if (player2.getColor().equals("red"))
							player2.setCoords(r, c);
						else if (player3.getColor().equals("red"))
							player3.setCoords(r, c);
						else if (player4.getColor().equals("red"))
							player4.setCoords(r, c);
					}
					if (tiles[r][c].getName().equals("Copper Gate")) {
						if (player1.getColor().equals("green"))
							player1.setCoords(r, c);
						if (player2.getColor().equals("green"))
							player2.setCoords(r, c);
						else if (player3.getColor().equals("green"))
							player3.setCoords(r, c);
						else if (player4.getColor().equals("green"))
							player4.setCoords(r, c);
					}
					if (tiles[r][c].getName().equals("Gold Gate")) {
						if (player1.getColor().equals("yellow"))
							player1.setCoords(r, c);
						if (player2.getColor().equals("yellow"))
							player2.setCoords(r, c);
						else if (player3.getColor().equals("yellow"))
							player3.setCoords(r, c);
						else if (player4.getColor().equals("yellow"))
							player4.setCoords(r, c);
					}
					if (tiles[r][c].getName().equals("Iron Gate")) {
						if (player1.getColor().equals("black"))
							player1.setCoords(r, c);
						if (player2.getColor().equals("black"))
							player2.setCoords(r, c);
						else if (player3.getColor().equals("black"))
							player3.setCoords(r, c);
						else if (player4.getColor().equals("black"))
							player4.setCoords(r, c);
					}
					if (tiles[r][c].getName().equals("Silver Gate")) {
						if (player1.getColor().equals("white"))
							player1.setCoords(r, c);
						if (player2.getColor().equals("white"))
							player2.setCoords(r, c);
						else if (player3.getColor().equals("white"))
							player3.setCoords(r, c);
						else if (player4.getColor().equals("white"))
							player4.setCoords(r, c);
					}
					if (tiles[r][c].getName().equals("Fools Landing")) {
						if (player1.getColor().equals("blue"))
							player1.setCoords(r, c);
						if (player2.getColor().equals("blue"))
							player2.setCoords(r, c);
						else if (player3.getColor().equals("blue"))
							player3.setCoords(r, c);
						else if (player4.getColor().equals("blue"))
							player4.setCoords(r, c);
					}
//					if (tiles[r][c].getName().equals("Cave of Embers")) {
//						player1.setCoords(r, c);
//					}
				}
			}
		}
		
//		player1.addTreasureCard(new TreasureCard(fireTC, false, false, true));
//		player1.addTreasureCard(new TreasureCard(fireTC, false, false, true));
//		player1.addTreasureCard(new TreasureCard(fireTC, false, false, true));
//		player1.addTreasureCard(new TreasureCard(fireTC, false, false, true));
		while (player1.getCards().size()<2) {
			TreasureCard tc=treasureCards.drawCard();
			while (tc.isWaterRises()) {
				treasureCards.addToDiscard(tc);
				treasureCards.reshuffle();
				tc=treasureCards.drawCard();
			}
			player1.addTreasureCard(tc);
		}
		while (player2.getCards().size()<2) {
			TreasureCard tc=treasureCards.drawCard();
			while (tc.isWaterRises()) {
				treasureCards.addToDiscard(tc);
				treasureCards.reshuffle();
				tc=treasureCards.drawCard();
			}
			player2.addTreasureCard(tc);
		}
		while (player3.getCards().size()<2) {
			TreasureCard tc=treasureCards.drawCard();
			while (tc.isWaterRises()) {
				treasureCards.addToDiscard(tc);
				treasureCards.reshuffle();
				tc=treasureCards.drawCard();
			}
			player3.addTreasureCard(tc);
		}
		while (player4.getCards().size()<2) {
			TreasureCard tc=treasureCards.drawCard();
			while (tc.isWaterRises()) {
				treasureCards.addToDiscard(tc);
				treasureCards.reshuffle();
				tc=treasureCards.drawCard();
			}
			player4.addTreasureCard(tc);
		}
		actionsLeft=3;
	}
	public boolean foolsLandingSunk() {
		if (!listOfTiles.contains(foolsLanding)) {
			lose=true;
			return true;
		}
		return false;
	}
	public boolean bothTreasureTilesSunk() {
		if (waterTreasure.getState().equals("unclaimed")&&!listOfTiles.contains(tidalPalace)&&!listOfTiles.contains(coralPalace)) {
			lose=true;
			return true;
		}
		if (fireTreasure.getState().equals("unclaimed")&&!listOfTiles.contains(caveOfShadows)&&!listOfTiles.contains(caveOfEmbers)) {
			lose=true;
			return true;
		}
		if (earthTreasure.getState().equals("unclaimed")&&!listOfTiles.contains(templeOfTheMoon)&&!listOfTiles.contains(templeOfTheSun)) {
			lose=true;
			return true;
		}
		if (airTreasure.getState().equals("unclaimed")&&!listOfTiles.contains(howlingGarden)&&!listOfTiles.contains(whisperingGarden)) {
			lose=true;
			return true;
		}
		return false;
	}
	public boolean playerStuck(Player p) {
		if (tiles[p.getRow()][p.getCol()]==null && !p.getName().equals("Pilot")) {
			if (tiles[p.getRow()-1][p.getCol()]==null && tiles[p.getRow()+1][p.getCol()]==null
				&& tiles[p.getRow()][p.getCol()-1]==null && tiles[p.getRow()][p.getCol()+1]==null) {
				if (p.getName().equals("Explorer")) {
					if (tiles[p.getRow()-1][p.getCol()-1]==null && tiles[p.getRow()-1][p.getCol()+1]==null
						&& tiles[p.getRow()+1][p.getCol()-1]==null && tiles[p.getRow()+1][p.getCol()+1]==null) 
							return true;
					else return false;
				}
				return true;
			}
		}
		return false;
	}
	public boolean checkIfLost() {
		if (foolsLandingSunk() || bothTreasureTilesSunk() || playerStuck(player1) || playerStuck(player2) || playerStuck(player3) || playerStuck(player4)) {
			lose=true;
			return true;
		}
		return false;
	}
	public String reason() {
		if (foolsLandingSunk()) {
			return "Fool's Landing has sunk.";
		}
		if (bothTreasureTilesSunk()) {
			return "treasure-claiming tiles have sunk before claiming treasure.";
		}
		else {
			return "a player has drowned.";
		}
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
		floodCards.reshuffle();
	}
	public void drawTreasureCard() {
		TreasureCard tc=treasureCards.drawCard();
		if (tc.isWaterRises()) {
			makeWaterRise();
		}
		else {
			currentPlayer.addTreasureCard(tc);
		}
		//return tc;
	}
	public void remove4(TreasureCard tc) {
		for (int i=0; i<4; i++) {
			int loc=currentPlayer.getCards().indexOf(tc);
			treasureCards.addToDiscard(currentPlayer.getCards().remove(loc));
		}
	}
	//should draw the number of cards and make the corresponding tile flooded or sunk and change the letter in board
	public FloodCard drawFloodCards() {
		int count=0;
		while (count<waterLevel) {
			FloodCard fc=floodCards.drawCard();
			for (int r=0; r<6; r++) {
				for (int c=0; c<6; c++) {
					if (tiles[r][c]!=null&&tiles[r][c].getName().equals(fc.getPlaceName())) {
						if (tiles[r][c].isFlooded()) {
							tiles[r][c]=null;
							floodCards.sunk(fc);
							listOfTiles.remove(fc);
						}
						else {
							tiles[r][c].flood();
						}
					}
				}
			}
			count++;
		}
		return floodCards.getTopDiscarded();
	}
	
	public void endTurn() {
		actionsLeft=3;
		playerCount++;
		int count=0;
		while (currentPlayer.getNumCards()<6&&count<2) {
			TreasureCard tc=treasureCards.drawCard();
			if (tc.isWaterRises()) {
				treasureCards.addToDiscard(tc);
				makeWaterRise();
				count++;
			}
			else {
				currentPlayer.addTreasureCard(tc);
				count++;
			}
		}
		drawFloodCards();
		if (playerCount%4==1) {
			currentPlayer=player1;
		}
		else if (playerCount%4==2) {
			currentPlayer=player2;
		}
		else if (playerCount%4==3) {
			currentPlayer=player3;
		}
		else if (playerCount%4==0) {
			currentPlayer=player4;
		}
	}
	
	public boolean captureTreasure() {
		String str=currentPlayer.getPossibleTreasureType();
		Tile current=tiles[currentPlayer.getRow()][currentPlayer.getCol()];
		TreasureCard air=new TreasureCard(airTC, false, false, true);
		air.setTreasureType("Air");
		TreasureCard earth=new TreasureCard(earthTC, false, false, true);
		earth.setTreasureType("Earth");
		TreasureCard fire=new TreasureCard(fireTC, false, false, true);
		fire.setTreasureType("Fire");
		TreasureCard water=new TreasureCard(waterTC, false, false, true);
		fire.setTreasureType("Water");
		if (str!=null) {
			//if (str.equals("Fire")&&(current.getName().equals("Cave of Embers")||current.equals(caveOfShadows))) {
			if (str.equals("Fire")&&(current.equals("caveOfEmbers")||current.equals(caveOfShadows))) {
				fireTreasure.claim();
				remove4(fire);
				return true;
			}
			if (str.equals("Water")&&(current.equals(coralPalace)||current.equals(tidalPalace))) {
				waterTreasure.claim();
				remove4(water);
				return true;
			}
			if (str.equals("Earth")&&(current.equals(templeOfTheMoon)||current.equals(templeOfTheSun))) {
				earthTreasure.claim();
				remove4(earth);
				return true;
			}
			if (str.equals("Air")&&(current.equals(howlingGarden)||current.equals(whisperingGarden))) {
				airTreasure.claim();
				remove4(air);
				return true;
			}
		}
//		System.out.println("current tile: "+current.getName());
		return false;
	}
	
	public boolean canMove(int r, int c, Player p) {
		int playerR=p.getRow();
		int playerC=p.getCol();
		if (tiles[r][c]==null) {
			return false;
		}
		if (p.getName().equals("Pilot")) {
			return true;
		}
		if (r==playerR-1&&c==playerC) {
			return true;
		}
		if (r==playerR+1&&c==playerC) {
			return true;
		}
		if (r==playerR&&c==playerC-1) {
			return true;
		}
		if (r==playerR&&c==playerC+1) {
			return true;
		}
		if (p.getName().equals("Explorer")) {
			if (r==playerR-1&&c==playerC-1) {
				return true;
			}
			if (r==playerR+1&&c==playerC-1) {
				return true;
			}
			if (r==playerR-1&&c==playerC-1) {
				return true;
			}
			if (r==playerR+1&&c==playerC+1) {
				return true;
			}
		}
		return false;
	}
	public void move(int r, int c, Player p) {
		p.setRow(r);
		p.setCol(c);
	}
	
	//get methods
	public int getTick() {
		return tick;
	}
	public BufferedImage getTileImage(int r, int c) {
		if (tiles[r][c]==null) {
			return tileWater;
		}
		return tiles[r][c].getImage();
	}
	public int getWaterLevel() {
		return waterLevel;
	}
	public int getActionsLeft() {
		return actionsLeft;
	}
}