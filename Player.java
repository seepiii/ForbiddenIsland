import java.util.ArrayList;

public class Player {
	private ArrayList<TreasureCard> cards=new ArrayList<>();
	private int actionsTaken;
	private int[] coordinates=new int[2];
	
	
	public Player(int[] coords) {
		coordinates=coords;
	}
	
	public void captureTreasure() {
		
	}
	
	public void giveTreasureCard(Player p, TreasureCard tc) {
		int ind=cards.indexOf(tc);
		TreasureCard temp=cards.remove(ind);
		p.addTreasureCard(temp);
	}
	
	public void shoreUp(int[] coords) {
		
	}
	
	public void moveRight(int[] coords) {
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