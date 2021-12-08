import java.awt.image.BufferedImage;

public class Engineer {
	//private static int[] coordinates;
	public Engineer() {
		//coordinates = new int[cs.length];
		//for (int i = 0; i < cs.length; i++) {
		//	coordinates[i] = cs[i];
		//}
	}
	public boolean shoreUp() {
		return true;
	}
	public static boolean move() {
		if (ForbiddenIslandPanel.distanceX2() <= 165 && ForbiddenIslandPanel.distanceY2() <= 165) {
			return true;
		}
		return false;
	}
	public String toString () {
		return ""+ ForbiddenIslandPanel.distanceX2();
	}
	/*public BufferedImage getTreasureCards() {
		
	}*/
}