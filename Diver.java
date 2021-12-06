public class Diver {
	//private static int[] coordinates;
	public Diver() {
		//coordinates = new int[cs.length];
		//for (int i = 0; i < cs.length; i++) {
		//	coordinates[i] = cs[i];
		//}
	}
	public boolean shoreUp() {
		return true;
	}
	public static boolean move() {
		if (ForbiddenIslandPanel.distanceX() <= 165 && ForbiddenIslandPanel.distanceY() <= 130) {
			return true;
		}
		return false;
	}
	public String toString () {
		return ""+ ForbiddenIslandPanel.distanceX();
	}
}
