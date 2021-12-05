import java.awt.*;
import java.io.IOException;

import javax.swing.*;
public class ForbiddenIslandFrame extends JFrame {
	private static final int WIDTH = 1350;
	private static final int HEIGHT = 740;
	public ForbiddenIslandFrame(String title, String w) throws IOException {
		super(title);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(WIDTH, HEIGHT);
		add(new ForbiddenIslandPanel(w));
		setVisible(true);
	}
}