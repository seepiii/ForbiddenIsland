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

public class ForbiddenIslandPanel extends JPanel implements MouseListener {
	private BufferedImage fcb, fcbs;
	private BufferedImage tcb, tcbs;
	private BufferedImage waterLevelMeter, discard;
	private BufferedImage arrow;

//	private int[] pl1coords;
	private int x, y;
	private int[] xTileCoords= {260, 380, 500, 620, 740, 860};
	private int[] yTileCoords = {13, 121, 229, 337, 445, 553};
	
	private int[] xmidpt= {305, 425, 545, 665, 785, 905};
	private int[] ymidpt= {60, 168, 276, 384, 492, 600};
	
	private int[] xCardCoords= {5, 48, 91, 134, 177};
	
	private boolean move, shoreUp, capture, giveCard, endTurn, special;

	private GameState gamestate;

	public ForbiddenIslandPanel(String w) throws IOException {
		gamestate=new GameState(w);
		try {
			tcb = ImageIO.read(ForbiddenIslandPanel.class.getResource("Image/Card_Back@2x.png"));
			fcb = ImageIO.read(ForbiddenIslandPanel.class.getResource("Image/Flood Card Back.png"));
			waterLevelMeter = ImageIO.read(ForbiddenIslandPanel.class.getResource("Image/Water Level Meter.png"));
			arrow = ImageIO.read(ForbiddenIslandPanel.class.getResource("Image/Weird Arrow.png"));
			discard=ImageIO.read(ForbiddenIslandPanel.class.getResource("Image/Card_Pressed@2x.png"));
		}
		catch(Exception E) {
			System.out.println("Exception Error");
			return;
		}

		addMouseListener(this);
		//button; doesn't work
//		JPanel panel1=new JPanel();
//		panel1.setBounds(980, 520, 150, 20);
//		add(panel1);
//		JButton moveBut=new JButton("Move");
//		moveBut.setSize(140, 20);
//		moveBut.setFont(new Font("TimesRoman",Font.BOLD,20));
//		panel1.add(moveBut);
//		validate();
	}
	public void paint(Graphics g) {
		//background
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, 1350, 750);
		g.fillRect(1177,182,183,321);
		g.fillRect(1075, 13, 15, 20);
		g.fillRect(1094, 45, 130, 20);
		//drawing the tiles
		for (int r=0; r<6; r++) {
			for (int c=0; c<6; c++) {
				g.drawImage(gamestate.getTileImage(r, c), xTileCoords[r], yTileCoords[c], 90, 95, null);
			}
		}
		//drawing waterLevel and treasures and discard piles
		g.drawImage(waterLevelMeter,  1200,  180,  125,  325,  null); //-200 from width
		g.drawImage(GameState.waterTreasure.getImage(),  960,  80,  90,  100,  null);
		g.drawImage(GameState.fireTreasure.getImage(),  1050,  80,  90,  100,  null);
		g.drawImage(GameState.airTreasure.getImage(),  1140,  80,  90,  100,  null);
		g.drawImage(GameState.earthTreasure.getImage(),  1230,  80,  90,  100,  null);
		g.drawImage(discard, 970, 210, 100, 130, null);
		g.drawImage(discard, 970, 370, 100, 130, null);
		if (GameState.treasureCards.getDiscardedCards().size()>0) {
			g.drawImage(GameState.treasureCards.getTopDiscarded().getImage(), 970, 210, 100, 130, null);
		}
		if (GameState.floodCards.getTopDiscarded()!=null) {
			g.drawImage(GameState.floodCards.getTopDiscarded().getImage(), 970, 370, 100, 130, null);
		}
		g.drawImage(tcb, 1080, 210, 100, 130, null);
		g.drawImage(fcb, 1080, 370, 100, 130, null);
		//drawing the pawns
		g.drawImage(GameState.player1.getImage(), 10, 5, 25, 35, null);
		g.drawImage(GameState.player2.getImage(), 10, 168, 25, 35, null);
		g.drawImage(GameState.player3.getImage(), 10, 327, 25, 35, null);
		g.drawImage(GameState.player4.getImage(), 10, 494, 25, 35, null);
		g.drawImage(GameState.player1.getImage(), xmidpt[GameState.player1.getRow()]-45, ymidpt[GameState.player1.getCol()]-47, 30, 50, null);
		g.drawImage(GameState.player2.getImage(), xmidpt[GameState.player2.getRow()]+15, ymidpt[GameState.player2.getCol()]-47, 30, 50, null);
		g.drawImage(GameState.player3.getImage(), xmidpt[GameState.player3.getRow()]-45, ymidpt[GameState.player3.getCol()], 30, 50, null);
		g.drawImage(GameState.player4.getImage(), xmidpt[GameState.player4.getRow()]+15, ymidpt[GameState.player4.getCol()], 30, 50, null);
		//drawing treasure cards
		g.setColor(Color.BLACK);
		g.setFont(new Font("TimesRoman", Font.PLAIN, 25));
		g.drawString(GameState.player1.getName(), 35, 30);
		g.drawString(GameState.player2.getName(), 35, 193);
		g.drawString(GameState.player3.getName(), 35, 352);
		g.drawString(GameState.player4.getName(), 35, 519);
		
		for (int i=0; i<GameState.player1.getNumCards(); i++) {
			BufferedImage card=GameState.player1.getCards().get(i).getImage();
			g.drawImage(card, xCardCoords[i], 40, 77, 130, null);
		}
		for (int i=0; i<GameState.player2.getNumCards(); i++) {
			BufferedImage card=GameState.player2.getCards().get(i).getImage();
			g.drawImage(card, xCardCoords[i], 200, 77, 130, null);
		}
		for (int i=0; i<GameState.player3.getNumCards(); i++) {
			BufferedImage card=GameState.player3.getCards().get(i).getImage();
			g.drawImage(card, xCardCoords[i], 363, 77, 130, null);
		}
		for (int i=0; i<GameState.player4.getNumCards(); i++) {
			BufferedImage card=GameState.player4.getCards().get(i).getImage();
			g.drawImage(card, xCardCoords[i], 526, 77, 130, null);
		}
		
		System.out.println("Paint");
		//drawing "buttons"
		g.setColor(Color.BLACK);
		g.setFont(new Font("TimesRoman",Font.PLAIN,20));
		g.drawRect(980, 520, 140, 40);
		g.drawRect(1150, 520, 140, 40);
		g.drawRect(980, 580, 140, 40);
		g.drawRect(1150, 580, 140, 40);
		g.drawRect(980, 640, 140, 40);
		g.drawRect(1150, 640, 140, 40);
		g.drawString("Move", 1025, 545);
		g.drawString("Shore Up", 1180, 545);
		g.drawString("Capture Treasure", 982, 605);
		g.drawString("Give Treasure", 1165, 605);
		g.drawString("End Turn", 1015, 665);
		g.drawString("Special Action", 1162, 665);
		//status stuffs
		g.setFont(new Font("TimesRoman",Font.PLAIN,20));
		g.drawString("Actions Left: "+gamestate.getActionsLeft(), 970, 30);
		g.drawString("Current Player: "+gamestate.currentPlayer.getName(), 970, 60);
		
		g.setFont(new Font("TimesRoman",Font.BOLD,25));
		g.setColor(Color.RED);
		if (gamestate.getTick()==1) {
			g.drawImage(arrow,  1180,  445,  25,  15,  null);
			//g.drawString(">", 1400, 615);
		}
		else if (gamestate.getTick()==2) {
			g.drawImage(arrow,  1180,  416,  25,  15,  null);
		}
		else if (gamestate.getTick()==3) {
			g.drawImage(arrow,  1180,  387,  25,  15,  null);
			//g.drawString(">", 1400, 570);
		}
		else if (gamestate.getTick()==4) {
			g.drawImage(arrow,  1180,  358,  25,  15,  null);
		}
		else if (gamestate.getTick()==5) {
			g.drawImage(arrow,  1180,  332,  25,  15,  null);
		}
		else if (gamestate.getTick()==6) {
			g.drawImage(arrow,  1180,  306,  25,  15,  null);
			//g.drawString(">", 1400, 480);
		}
		else if (gamestate.getTick()==7) {
			g.drawImage(arrow,  1180,  280,  25,  15,  null);
		}
		else if (gamestate.getTick()==8) {
			g.drawImage(arrow,  1180,  255,  25,  15,  null);
			//g.drawString(">", 1400, 570);
		}
		else if (gamestate.getTick()==9) {
			g.drawImage(arrow,  1180,  229,  25,  15,  null);
		}
		else {
			g.drawImage(arrow,  1180,  200,  25,  15,  null);
			gamestate.lose=true;
		}
		//}

	}


	public void mousePressed(MouseEvent e) { }
	public void mouseReleased(MouseEvent e) { }
	public void mouseEntered(MouseEvent e) { }
	public void mouseExited(MouseEvent e) { }
	public void mouseClicked(MouseEvent e) {
		x = e.getX();
		y = e.getY();
		int w = getWidth();
		int h = getHeight();
		System.out.println("loc is ("+x+","+y+")" + w + " " + h);
		int rand=0;
		Coordinates coords=new Coordinates(x, y);
		int r=coords.getRow();
		int c=coords.getCol();
		if (e.getButton() == e.BUTTON1) {
			//performing the actions?
			if (move) {
				System.out.println(r+", "+c);
				if (r>5||c>5||!gamestate.canMove(r, c, gamestate.currentPlayer)) {
					JOptionPane.showMessageDialog(null, "Invalid.");
					move=false;
				}
				else {
					gamestate.move(r, c, gamestate.currentPlayer);
					gamestate.actionsLeft--;
					move=false;
				}
			}			
			
			//checks which button is pressed
			if (x>=980&&x<=1120&&y>=520&&y<=560) {
				move=true;
				rand=1;
			}
			else if (x>=1150&&x<=1290&&y>=520&&y<=560) {
				shoreUp=true;
				rand=2;
			}
			else if (x>=980&&x<=1120&&y>=580&&y<=620) {
				capture=true;
				rand=3;
				boolean ca=gamestate.captureTreasure();
				if (ca==false) {
					JOptionPane.showMessageDialog(null, "Invalid.");
					capture=false;
				}
				else {
					gamestate.actionsLeft--;
					capture=false;
				}
			}
			else if (x>=1150&&x<=1290&&y>=580&&y<=620) {
				giveCard=true;
				rand=4;
			}
			else if (x>=980&&x<=1120&&y>=640&&y<=680) {
				endTurn=true;
				rand=5;
				gamestate.endTurn();
				endTurn=false;
			}
			else if (x>=1150&&x<=1290&&y>=640&&y<=680) {
				special=true;
				rand=6;
			}
			if (gamestate.actionsLeft==0) {
				gamestate.endTurn();
				if (gamestate.tiles[gamestate.player1.getRow()][gamestate.player1.getCol()]==null) {
					if (r>5||c>5||!gamestate.canMove(r, c, gamestate.player1)) {
						JOptionPane.showMessageDialog(null, "Please move "+gamestate.player1.getName()+" to a valid tile.");
					}
					else {
						gamestate.move(r, c, gamestate.player1);
					}
				}
				if (gamestate.tiles[gamestate.player2.getRow()][gamestate.player2.getCol()]==null) {
					if (r>5||c>5||!gamestate.canMove(r, c, gamestate.player2)) {
						JOptionPane.showMessageDialog(null, "Please move "+gamestate.player2.getName()+" to a valid tile.");
					}
					else {
						gamestate.move(r, c, gamestate.player2);
					}
				}
				if (gamestate.tiles[gamestate.player3.getRow()][gamestate.player3.getCol()]==null) {
					if (r>5||c>5||!gamestate.canMove(r, c, gamestate.player3)) {
						JOptionPane.showMessageDialog(null, "Please move "+gamestate.player3.getName()+" to a valid tile.");
					}
					else {
						gamestate.move(r, c, gamestate.player3);
					}
				}
				if (gamestate.tiles[gamestate.player4.getRow()][gamestate.player4.getCol()]==null) {
					if (r>5||c>5||!gamestate.canMove(r, c, gamestate.player4)) {
						JOptionPane.showMessageDialog(null, "Please move "+gamestate.player4.getName()+" to a valid tile.");
					}
					else {
						gamestate.move(r, c, gamestate.player4);
					}
				}
			}
			if (gamestate.checkIfLost()) {
				try {
					GameStatusFrame gsf=new GameStatusFrame("Status", true, gamestate.reason());
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					System.out.println("Status Error");
					return;
				}
			}
		}
		repaint();
	}
}



