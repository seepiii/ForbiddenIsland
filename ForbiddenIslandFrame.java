import java.awt.*;
import javax.swing.*;
public class ForbiddenIslandFrame extends JFrame {
	private static final int WIDTH = 1350;
	private static final int HEIGHT = 740;
	public ForbiddenIslandFrame(String title, int s, String w, int p) {
		super(title);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(WIDTH, HEIGHT);
		add(new ForbiddenIslandPanel(s, w, p));
		setVisible(true);
	}
}
