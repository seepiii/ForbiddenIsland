import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;
import java.awt.Font;
import javax.imageio.ImageIO;
import javax.swing.*;

public class GameStatusPanel extends JPanel {
	private boolean lost;
	private String reason;
	public GameStatusPanel(boolean l, String r) {
		lost=l;
		reason=r;
	}
	
	public void paint(Graphics g) {
		g.setFont(new Font("TimesRoman",Font.PLAIN,20));
		if (lost) {
			g.drawString("You have lost. Reason: "+reason, 10, 50);
		}
		if (!lost) {
			g.drawString("Good job! You won!", 10, 50);
		}
	}
}
