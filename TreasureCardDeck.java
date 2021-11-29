import java.util.*;

public class TreasureCardDeck {
	private Stack<TreasureCard> cards = new Stack<TreasureCard>();
	private Stack<TreasureCard> discarded = new Stack<TreasureCard>();
	
	public TreasureCardDeck(Stack<TreasureCard> c, Stack<TreasureCard> d) {
		cards = c;
		discarded = d;
	}
	
	public Stack getCards() {
		return cards;
	}
	
	public Stack getDiscardedCards() {
		return discarded;
	}
	
	public TreasureCard drawCard() {
		return cards.pop();
	}
	public void addToDiscard(TreasureCard tc) {
		discarded.push(tc);
	}
}
