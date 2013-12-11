package mafia.client;


import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class View extends JFrame {

	public static JPanel gamePane,cardPane,chatPane,autorizePane;
	public static JLabel port,adress,name;
	public static JButton autorize,send;
	public static JTextField port1,adress1,name1,message;
	public static JTextArea memo;
	public static Container container;
	
	JPanel group;
	
	public View() {
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		int screenWidth = (int) dim.getWidth() / 2;
		int screenHeight = (int) dim.getHeight() / 2;

		setLocation(screenWidth/2, screenHeight/2);

		container = this.getContentPane();
		setSize(screenWidth, screenHeight);
		
		JButton autorize=new JButton("Autorize");
		JButton send=new JButton("Send");
		
		JLabel port=new JLabel("Port");
		JLabel adress=new JLabel("Host");
		JLabel name=new JLabel("Name");
		
		JTextField port1=new JTextField(10);
		JTextField adress1=new JTextField(10);
		JTextField name1=new JTextField(10);
		JTextField message=new JTextField(10);
		
		JTextArea memo=new JTextArea(20,10);
		
		JPanel cardPane=new JPanel();
		JPanel chatPane=new JPanel();
		JPanel gamePane=new JPanel();
		JPanel autorizePane =new JPanel();
		
		
		//autorize Panel
		autorizePane.add(port);
		autorizePane.add(port1);
		autorizePane.add(adress);
		autorizePane.add(adress1);
		autorizePane.add(name);
		autorizePane.add(name1);
		autorizePane.add(autorize);
		
		//chat Panel
		chatPane.add(memo);
		chatPane.add(message);
		chatPane.add(send);
		
		//grouping
		group=new JPanel();
		group.add(cardPane);
		group.add(chatPane);
				
		//container
		container.add(gamePane);
		container.add(group);
		container.add(autorizePane);
		
		//Layouts
		group.setLayout(new GridLayout(1,2));
		
		//colors
		cardPane.setBackground(Color.LIGHT_GRAY);
		gamePane.setBackground(Color.ORANGE);
		
		//Visible
		group.setVisible(false);
		gamePane.setVisible(false);
		autorizePane.setVisible(true);
		
		
		
		
	}
	
	public void gameGUI(boolean active)
	{
		if (active)
		{
			group.setVisible(true);
			gamePane.setVisible(true);
			autorizePane.setVisible(false);
			container.setLayout(new GridLayout(2,1));

		}
		else
		{
			group.setVisible(false);
			gamePane.setVisible(false);
			autorizePane.setVisible(true);

		}
	}

}
