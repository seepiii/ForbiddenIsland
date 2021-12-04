import java.util.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class FloodCardDeck {
	private Stack<FloodCard> cards = new Stack<FloodCard>();
	private Stack<FloodCard> discarded = new Stack<FloodCard>();
	
	private BufferedImage breakersBridge, bronzeGate, caveOfEmbers, caveOfShadows, cliffsOfAbandon, copperGate,
	coralPalace, crimsonForest, dunesOfDeception, foolsLanding, goldGate, howlingGarden, ironGate, lostLagoon,
	mistyMarsh, observatory, phantomRock, silverGate, templeOfTheMoon, templeOfTheSun, tidalPalace, twilightHollow,
	watchtower, whisperingGarden;
	public FloodCardDeck() {
		try {
			breakersBridge = ImageIO.read(ForbiddenIslandPanel.class.getResource("/Image/Breakers Bridge.png"));
			bronzeGate = ImageIO.read(ForbiddenIslandPanel.class.getResource("/Image/Bronze Gate.png"));
			caveOfEmbers = ImageIO.read(ForbiddenIslandPanel.class.getResource("/Image/Cave of Embers.png"));
			caveOfShadows = ImageIO.read(ForbiddenIslandPanel.class.getResource("/Image/Cave of Shadows.png"));
			cliffsOfAbandon = ImageIO.read(ForbiddenIslandPanel.class.getResource("/Image/Cliffs of Abandon.png"));
			copperGate = ImageIO.read(ForbiddenIslandPanel.class.getResource("/Image/Copper Gate.png"));
			coralPalace = ImageIO.read(ForbiddenIslandPanel.class.getResource("/Image/Coral Palace.png"));
			crimsonForest = ImageIO.read(ForbiddenIslandPanel.class.getResource("/Image/Crimson Forest.png"));
			dunesOfDeception = ImageIO.read(ForbiddenIslandPanel.class.getResource("/Image/Dunes of Deception.png"));
			foolsLanding = ImageIO.read(ForbiddenIslandPanel.class.getResource("/Image/Foo's Landing.png"));
			goldGate = ImageIO.read(ForbiddenIslandPanel.class.getResource("/Image/Gold Gate.png"));
			howlingGarden = ImageIO.read(ForbiddenIslandPanel.class.getResource("/Image/Howling Garden.png"));
			ironGate = ImageIO.read(ForbiddenIslandPanel.class.getResource("/Image/Iron Gate.png"));
			lostLagoon = ImageIO.read(ForbiddenIslandPanel.class.getResource("/Image/Lost Lagoon.png"));
			mistyMarsh = ImageIO.read(ForbiddenIslandPanel.class.getResource("/Image/Misty Marsh.png"));
			observatory = ImageIO.read(ForbiddenIslandPanel.class.getResource("/Image/Observatory.png"));
			phantomRock = ImageIO.read(ForbiddenIslandPanel.class.getResource("/Image/Phantom Rock.png"));
			silverGate = ImageIO.read(ForbiddenIslandPanel.class.getResource("/Image/Silver Gate.png"));
			templeOfTheMoon = ImageIO.read(ForbiddenIslandPanel.class.getResource("/Image/Temple of the Moon.png"));
			templeOfTheSun = ImageIO.read(ForbiddenIslandPanel.class.getResource("/Image/Temple of the Sun.png"));
			tidalPalace = ImageIO.read(ForbiddenIslandPanel.class.getResource("/Image/Tidal Palace.png"));
			twilightHollow = ImageIO.read(ForbiddenIslandPanel.class.getResource("/Image/Twilight Hollow.png"));
			watchtower = ImageIO.read(ForbiddenIslandPanel.class.getResource("/Image/Watchtower.png"));
			whisperingGarden = ImageIO.read(ForbiddenIslandPanel.class.getResource("/Image/Whispering Garden.png"));
		}
		catch(Exception E) {
			System.out.println("FloodCardDeck Exception Error");
		}
		FloodCard temp=new FloodCard("Breakers Bridge", breakersBridge);
		cards.push(temp);
		temp=new FloodCard("Bronze Gate", bronzeGate);
		cards.push(temp);
		temp=new FloodCard("Cave of Embers", caveOfEmbers);
		cards.push(temp);
		temp=new FloodCard("Cave of Shadows", caveOfShadows);
		cards.push(temp);
		temp=new FloodCard("Cliffs of Abandon", cliffsOfAbandon);
		cards.push(temp);
		temp=new FloodCard("Copper Gate", copperGate);
		cards.push(temp);
		temp=new FloodCard("Coral Palace", coralPalace);
		cards.push(temp);
		temp=new FloodCard("Crimson Forest", crimsonForest);
		cards.push(temp);
		temp=new FloodCard("Dunes of Deception", dunesOfDeception);
		cards.push(temp);
		temp=new FloodCard("Fools Landing", foolsLanding);
		cards.push(temp);
		temp=new FloodCard("Gold Gate", goldGate);
		cards.push(temp);
		temp=new FloodCard("Howling Garden", howlingGarden);
		cards.push(temp);
		temp=new FloodCard("Iron Gate", ironGate);
		cards.push(temp);
		temp=new FloodCard("Lost Lagoon", lostLagoon);
		cards.push(temp);
		temp=new FloodCard("Misty Marsh", mistyMarsh);
		cards.push(temp);
		temp=new FloodCard("Observatory", observatory);
		cards.push(temp);
		temp=new FloodCard("Phantom Rock", phantomRock);
		cards.push(temp);
		temp=new FloodCard("Silver Gate", silverGate);
		cards.push(temp);
		temp=new FloodCard("Tidal Palace", tidalPalace);
		cards.push(temp);
		temp=new FloodCard("Temple of the Moon", templeOfTheMoon);
		cards.push(temp);
		temp=new FloodCard("Temple of the Sun", templeOfTheSun);
		cards.push(temp);
		temp=new FloodCard("Twilight Hollow", twilightHollow);
		cards.push(temp);
		temp=new FloodCard("Watchtower", watchtower);
		cards.push(temp);
		temp=new FloodCard("Whispering Garden", whisperingGarden);
		cards.push(temp);
		//shuffling
		ArrayList<FloodCard> list=new ArrayList<>();
		while (!cards.isEmpty()) {
			list.add(cards.pop());
		}
		Collections.shuffle(list);
		while (!list.isEmpty()) {
			FloodCard fc=list.remove(0);
			cards.push(fc);
		}
	}
	
	public Stack<FloodCard> getCards() {
		return cards;
	}
	public Stack<FloodCard> getDiscardedCards() {
		return discarded;
	}
	public FloodCard getTopDiscarded() {
		return cards.peek();
	}
	public FloodCard drawCard() {
		FloodCard fc=cards.pop();
		discarded.push(fc);
		return fc;
	}
	public void sunk(FloodCard fc) {
		discarded.remove(fc);
	}
	public void reshuffle() {
		ArrayList<FloodCard> list=new ArrayList<>();
		while (!discarded.isEmpty()) {
			list.add(discarded.pop());
		}
		while (!cards.isEmpty()) {
			list.add(cards.pop());
		}
		Collections.shuffle(list);
		while (!list.isEmpty()) {
			FloodCard fc=list.remove(0);
			cards.push(fc);
		}
	}
}