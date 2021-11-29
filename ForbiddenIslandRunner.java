import javax.swing.*;

public class ForbiddenIslandRunner {
	private int seed;
	private static int waterLevel;
	private int numPlayers;
	public static void main(String[] args) {
		int seed = Integer.parseInt(JOptionPane.showInputDialog(null,"Please enter the seed.","Seed",JOptionPane.QUESTION_MESSAGE));
		String waterLevel = JOptionPane.showInputDialog(null,"Please enter the water level you want to start the game at (2 - 5).","Water Level",JOptionPane.QUESTION_MESSAGE);
		int newWaterLevel = Integer.parseInt(waterLevel);
		while(newWaterLevel < 2 || newWaterLevel > 5 || (newWaterLevel != (int)newWaterLevel)) {
			JOptionPane.showMessageDialog(null, "Invalid input. Please submit a number within range.");
			newWaterLevel = Integer.parseInt(JOptionPane.showInputDialog(null,"Please enter the water level you want to start the game at (2 - 5).","Water Level",JOptionPane.QUESTION_MESSAGE));
		}
		int numPlayers = Integer.parseInt(JOptionPane.showInputDialog(null,"Please enter the number of players. (2 - 4)","Number of Players",JOptionPane.QUESTION_MESSAGE));
		while(numPlayers < 2 || numPlayers > 4 || (numPlayers != (int)numPlayers)) {
			JOptionPane.showMessageDialog(null, "Invalid input. Please submit a number within range.");
			numPlayers = Integer.parseInt(JOptionPane.showInputDialog(null,"Please enter the number of players. (2 - 4)","Number of Players",JOptionPane.QUESTION_MESSAGE));
}
ForbiddenIslandFrame b = new ForbiddenIslandFrame("hi", seed, waterLevel, numPlayers);
}
	public static int getWaterLevel() {
		return waterLevel;
	}
	
}