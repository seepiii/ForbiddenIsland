import java.awt.*;
import java.io.IOException;

import javax.swing.*;
public class GameStatusFrame extends JFrame {
	private static final int WIDTH = 500;
	private static final int HEIGHT = 200;
	public GameStatusFrame(String title, boolean lost, String reason) throws IOException {
		super(title);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(WIDTH, HEIGHT);
		add(new GameStatusPanel(lost, reason));
		setLocationRelativeTo(null);
		setVisible(true);
	}
}