package mafia.server;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class Frame extends JFrame {
	public Container container;

	public Frame() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		int screenWidth = (int) dim.getWidth() / 3;
		int screenHeight = (int) dim.getHeight() / 3;

		setLocation(screenWidth, screenHeight);

		container = this.getContentPane();
		setSize(screenWidth, screenHeight);
		addCloseAction();
	}

	private void onExit() {
		System.err.println("Exit");
		System.exit(0);
	}

	private void addCloseAction() {
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent evt) {
				System.out.println("Exit program");
				onExit();
			}
		});
	}
}
