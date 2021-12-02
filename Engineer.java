public class Engineer {
	private int[] engCoords;
		public Engineer(int[] coords) {
			engCoords = coords;
		}
		
		//shoreUp will see if the two set of coordinates are able to shore up
		public boolean shoreUp(int[] firstTileShoreUp, int[] secondTileShoreUp) {
			
			//not done with shore up stuff, 
			
		}
	
	public void giveTreasureCard(Player p, TreasureCard tc) {
		p.addTreasureCard(tc);
		this.getCards().remove(tc);
	}
	
	
}
