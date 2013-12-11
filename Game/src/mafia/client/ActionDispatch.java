package mafia.client;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.Socket;

public class ActionDispatch {

	Socket client=null;
	
	private View v;
	
	public ActionDispatch() {
		
		this.v=v;
		
	}
	
	public void setConnection(String adress,int port)
	{
		try
		{
			client=new Socket(adress,port);
		}
		catch(Exception e)
		{
			
		}
		
	}
	public void setGameGUI()
	{
	}

}
