import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.*;
public class ForbiddenIslandFrame extends JFrame {
	private static final int WIDTH = 1350;
	private static final int HEIGHT = 740;
	public ForbiddenIslandFrame(String title, String w) throws IOException {
		super(title);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(WIDTH, HEIGHT);
		
//		JButton move=new JButton("Move");
//		move.setBounds(980, 520, 140, 40);
//		add(move);
//		
//		JButton shoreup=new JButton("Shore Up");
//		shoreup.setBounds(1120, 520, 140, 40);
//		add(shoreup);
//		
//		JButton capturetreasure=new JButton("Capture Treasure");
//		capturetreasure.setBounds(980, 560, 140, 40);
//		add(capturetreasure);
//		
//		JButton givecard=new JButton("Give Card");
//		givecard.setBounds(1120, 560, 140, 40);
//		add(givecard);
//		
//		JButton quit=new JButton("End Turn");
//		quit.setBounds(980, 600, 140, 40);
//		quit.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				boolean endTurn=true;
//			}
//		});
//		add(quit);
//		
//		JButton special=new JButton("Special Action");
//		special.setBounds(1120, 600, 140, 40);
//		add(special);
		
		add(new ForbiddenIslandPanel(w));
		setLocationRelativeTo(null);
		setVisible(true);
	}
}