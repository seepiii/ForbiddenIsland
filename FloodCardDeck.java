import java.util.*;

public class FloodCardDeck {
	private Stack<FloodCard> cards = new Stack<FloodCard>();
	private Stack<FloodCard> discarded = new Stack<FloodCard>();
	
	public FloodCardDeck(Stack<FloodCard> c, Stack<FloodCard> d) {
		cards=c;
		discarded=d;
	}
	
	public Stack getCards() {
		return cards;
	}
	
	public Stack getDiscardedCards() {
		return discarded;
	}
	
	public FloodCard drawCard() {
		return cards.pop();
	}
	
	public void discard(FloodCard fc) {
		discarded.push(fc);
	}
}