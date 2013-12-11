package mafia.server;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class Frame extends JFrame {
	public Container container;
	public Frame() {
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		int screenWidth = (int) dim.getWidth() / 3;
		int screenHeight = (int) dim.getHeight() /3;
		
		setLocation(screenWidth, screenHeight);
		
		
		container=this.getContentPane();
		setSize(screenWidth,screenHeight);
	}
}
