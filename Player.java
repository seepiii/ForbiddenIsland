import java.util.ArrayList;
import java.awt.image.BufferedImage;

public class Player {
	private ArrayList<TreasureCard> cards=new ArrayList<>();
	private int actionsTaken;
	private int[] coordinates=new int[2];
	private BufferedImage pawn;
	private String color;
	private String name;
	private int fire=0, earth=0, water=0, air=0;
//	private ArrayList<Tile> tilesNextTo;
	
	public Player(BufferedImage p, String c, String n) {
		//coordinates=coords;
		pawn = p;
		color=c;
		name=n;
		//tilesNextTo.add(); //all tile objects?
	}
	public BufferedImage getImage() {
		return pawn;
	}
	public void giveTreasureCard(Player p, TreasureCard tc) {
		int ind=cards.indexOf(tc);
		TreasureCard temp=cards.remove(ind);
		p.addTreasureCard(temp);
	}
	
	public static boolean move() {
//		if (ForbiddenIslandPanel.distanceX() <= 165 && ForbiddenIslandPanel.distanceY() <= 130) {
//			return true;
//		}
		return false;
	}
	public void addTreasureCard(TreasureCard tc) {
		cards.add(tc);
		String str=tc.getTreasureType();
		if (str.equals("Fire")) {
			fire++;
		}
		if (str.equals("Air")) {
			air++;
		}
		if (str.equals("Earth")) {
			earth++;
		}
		if (str.equals("Water")) {
			water++;
		}
	}
	public void setCoords(int r, int c) {
		coordinates[0]=r;
		coordinates[1]=c;
	}
	public void setRow(int r) {
		coordinates[0]=r;
	}
	public void setCol(int c) {
		coordinates[1]=c;
	}
	public void remove4(TreasureCard tc) {
		for (int i=0; i<4; i++) {
			cards.remove(tc);
		}
	}
	//get methods
	public int getActionsTaken() {
		return actionsTaken;
	}
	public int getNumCards() {
		return cards.size();
	}
	public ArrayList<TreasureCard> getCards() {
		return cards;
	}
	public int[] getCoordinates() {
		return coordinates;
	}
	public String getColor() {
		return color;
	}
	public String getName() {
		return name;
	}
	public int getRow() {
		return coordinates[0];
	}
	public int getCol() {
		return coordinates[1];
	}
	public boolean hasCardsToCapture() {
		if (fire>=4||air>=4||earth>=4||water>=4) {
			return true;
		}
		return false;
	}
	public String getPossibleTreasureType() {

			if (fire>=4) {
				return "Fire";
			}
			else if (air>=4) {
				return "Air";
			}
			else if (earth>=4) {
				return "Earth";
			}
			else if (water>=4) {
				return "Water";
			}
		return null;
	}
}
