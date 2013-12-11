package mafia.server;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.*;

public class Frame extends JFrame {
	
	public Container container;
	private static JTextArea logTextArea;
	public JPanel panel;
	public JButton startServer;
	public JTextField portText;
	public JLabel portLabel;
	
	
	public Frame() {		
		container = this.getContentPane();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		int screenWidth = (int) dim.getWidth() / 3;
		int screenHeight = (int) dim.getHeight() / 3;
		container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
	    
		logTextArea = new JTextArea();
		container.add(BorderLayout.NORTH,logTextArea);
		panel = new JPanel();			
		container.add( BorderLayout.CENTER, panel);
		
		startServer = new JButton("Start Server");
		panel.add(startServer);
		
		portLabel = new JLabel("Server Port:");
		panel.add(portLabel);
		portText = new JTextField(6);
		portText.setText("8080");
		panel.add(portText);
		
		
		
		
		
		setLocation(screenWidth, screenHeight);
		
		setSize(screenWidth, screenHeight);
		addCloseAction();
	}
	
	public static void println(String str) {
		String timeStamp = new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime());
		logTextArea.append(timeStamp);;
		logTextArea.append(": ");
		logTextArea.append(str);
		logTextArea.append("\n");
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
