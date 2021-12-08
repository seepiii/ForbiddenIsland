import java.io.IOException;

import javax.swing.JFrame;

public class TreasureFrame extends JFrame {
	private static final int WIDTH = 200;
	private static final int HEIGHT = 450;
	public TreasureFrame(String title, ForbiddenIslandFrame f) throws IOException {
		super(title);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(WIDTH, HEIGHT);
		setLocationRelativeTo(f);
		setVisible(true);
	}
}
