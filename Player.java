import java.util.ArrayList;
import java.awt.image.BufferedImage;

public class Player {
	private ArrayList<TreasureCard> cards=new ArrayList<>();
	private int actionsTaken;
	private int[] coordinates=new int[2];
	private BufferedImage pawn, pawnSelect;
	private ArrayList<Tile> tilesNextTo;
	
	public Player(BufferedImage p, BufferedImage ps, int[] coords) {
		//coordinates=coords;
		pawn = p;
		pawnSelect = ps;
		coordinates[0] = coords[0];
		coordinates[1] = coords[1];
		tilesNextTo = new ArrayList<>();
		//tilesNextTo.add(); //all tile objects?
	}
	public BufferedImage pawnImage() {
		return pawn;
	}
	public BufferedImage pawnSelectImage() {
		return pawnSelect;
	}
	public String captureTreasure() {
		for (int i = 0; i < GameState.getTiles().size(); i++) {
		if (coordinates[0]-GameState.getTiles().get(i).getCoordinates()[0] <100 ) {
			
		}
		}
		return "";//name of treasure	
		}
	
	public void giveTreasureCard(TreasureCard tc) {
		int ind=cards.indexOf(tc);
		TreasureCard temp=cards.remove(ind);
		addTreasureCard(temp);
	}
	
	public void shoreUp(int[] coords) {
		
	}
	public static boolean move() {
		if (ForbiddenIslandPanel.distanceX() <= 165 && ForbiddenIslandPanel.distanceY() <= 130) {
			return true;
		}
		return false;
	}
/*	public void moveRight(int[] coords) {
		coordinates[0] += 259;
		
	}
	
	public void moveLeft(int[] coords) {
		coordinates[0] -= 259;
	}
	
	public void moveDown(int[] coords) {
		coordinates[1] -= 259;
	}
	
	public void moveUp(int[] coords) {
		coordinates[1] += 259;
	}
*/
	public void addTreasureCard(TreasureCard tc) {
		cards.add(tc);
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
}
