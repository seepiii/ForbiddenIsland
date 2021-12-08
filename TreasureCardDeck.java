import java.util.*;
import java.awt.image.BufferedImage;

public class TreasureCardDeck {
	private Stack<TreasureCard> cards = new Stack<TreasureCard>();
	private Stack<TreasureCard> discarded = new Stack<TreasureCard>();
	
	public TreasureCardDeck(BufferedImage ah, BufferedImage erff, BufferedImage fya, BufferedImage wotah, BufferedImage sahnd, BufferedImage heli, BufferedImage wotahrise) {
		//water rise, action, treasure
		TreasureCard air=new TreasureCard(ah, false, false, true);
		air.setTreasureType("Air");
		TreasureCard earth=new TreasureCard(erff, false, false, true);
		earth.setTreasureType("Earth");
		TreasureCard fire=new TreasureCard(fya, false, false, true);
		fire.setTreasureType("Fire");
		TreasureCard water=new TreasureCard(wotah, false, false, true);
		fire.setTreasureType("Water");
		
		TreasureCard sandbag=new TreasureCard(sahnd, false, true, false);
		sandbag.setActionType("Sandbag");
		TreasureCard helipad=new TreasureCard(heli, false, true, false);
		helipad.setActionType("Helipad");
		TreasureCard waterRise=new TreasureCard(wotahrise, true, false, false);
		
		for (int i=0; i<5; i++) {
			cards.push(air);
			cards.push(earth);
			cards.push(fire);
			cards.push(water);
		}
		
		for (int i=0; i<2; i++) {
			cards.push(sandbag);
			cards.push(helipad);
			cards.push(waterRise);
		}
		cards.push(helipad);
		cards.push(waterRise);
		//shuffling
		ArrayList<TreasureCard> list=new ArrayList<>();
		while (!cards.isEmpty()) {
			list.add(cards.pop());
		}
		Collections.shuffle(list);
		while (!list.isEmpty()) {
			TreasureCard tc=list.remove(0);
			cards.push(tc);
		}
	}
	
	public Stack getCards() {
		return cards;
	}
	
	public Stack getDiscardedCards() {
		return discarded;
	}
	public TreasureCard getTopDiscarded() {
		return discarded.peek();
	}
	public TreasureCard drawCard() {
		return cards.pop();
	}
	public void addToDiscard(TreasureCard tc) {
		discarded.push(tc);
	}
	public void reshuffle() {
		ArrayList<TreasureCard> cardsleft=new ArrayList<>();
		while (!discarded.isEmpty()) {
			cardsleft.add(discarded.pop());
		}
		while (!cards.isEmpty()) {
			cardsleft.add(cards.pop());
		}
		Collections.shuffle(cardsleft);
		while (!cardsleft.isEmpty()) {
			TreasureCard tc=cardsleft.remove(0);
			cards.push(tc);
		}
	}
}