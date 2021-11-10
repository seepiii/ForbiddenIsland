import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Map;
import java.awt.Font;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.awt.event.MouseListener;
public class ForbiddenIslandPanel extends JPanel implements MouseListener {
	private BufferedImage fcb, fcbs;
	private BufferedImage foolsLanding, templeOfTheSun;
	private BufferedImage tcb, tcbs;
	private Map<String, BufferedImage> gameSquares;
	private int seed, waterLevel, numPlayers;
	private BufferedImage choice1, choice2;
  //add other variables as needed
  
	public ForbiddenIslandPanel(int s, int w, int p) {
		seed=s;
		waterLevel=w;
		numPlayers=p;
		//add everything else that happens in the constructor (written by sampadaa?)
		try {
			tcb = ImageIO.read(ForbiddenIslandPanel.class.getResource("/Image/Card_Back@2x (3).png"));
			System.out.println("Constructor");
			tcbs = ImageIO.read(ForbiddenIslandPanel.class.getResource("/Image/Card_BackSelect@2x.png"));
			foolsLanding = ImageIO.read(ForbiddenIslandPanel.class.getResource("/Image/Foo's Landing.png"));
			fcb = ImageIO.read(ForbiddenIslandPanel.class.getResource("/Image/Flood Card Back.png"));
			fcbs = ImageIO.read(ForbiddenIslandPanel.class.getResource("/Image/Flood Card Back Select.png"));
			templeOfTheSun = ImageIO.read(ForbiddenIslandPanel.class.getResource("/Image/Temple of the Sun.png"));

		}
		catch(Exception E) {
			System.out.println("Exception Error");
			return;
		}
		choice1 = tcb;
		choice2 = fcb;
		addMouseListener(this);
	}
public void paint(Graphics g) {
	g.drawImage(tcb,  60,  534,  170,  101,  null);
	//g.drawImage(foolsLanding,  589,  13,  111,  117,  null); //-200 from width
	g.drawImage(choice1,  60,  534,  170,  101,  null);
	g.drawImage(foolsLanding,  589,  13,  111,  117,  null); //-200 from width
	g.drawImage(templeOfTheSun,  737,  13,  111,  117,  null); //-200 from width
	g.drawImage(fcb,  1225,  534,  170,  101,  null); //-200 from width
	g.drawImage(choice2,  1225,  534,  170,  101,  null); //-200 from width

	System.out.println("Paint");

	}
public void mousePressed(MouseEvent e) { }
public void mouseReleased(MouseEvent e) { }
public void mouseEntered(MouseEvent e) { }
public void mouseExited(MouseEvent e) { }
public void mouseClicked(MouseEvent e) {
	
	//for (int r = 0; r < allNums.length; r++) {
		//for (int c = 0; c < allNums[r].length; c++) {
			int x = e.getX();
			int y = e.getY();
			int w = getWidth();
			int h = getHeight();
			System.out.println("loc is ("+x+","+y+")" + w + " " + h);
			if (e.getButton() == e.BUTTON1) {
				if (x >= 60 && x <= 230 && y >= 534 && y <= 634) {
					if(choice1 == tcb) {
						choice1 = tcbs;
					}
					else {
						choice1 = tcb;
					}
				}			
				if (x >= 1225 && x <= 1395 && y >= 534 && y <= 634) {
					if(choice2 == fcb) {
						choice2 = fcbs;
					}
					else {
						choice2 = fcb;
					}
				}
		
		repaint();
	}
}
}

