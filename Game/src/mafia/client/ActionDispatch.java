package mafia.client;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.Socket;

public class ActionDispatch {

	Socket client;
	
	View v;
	int port;
	String adress;
	String name;
	
	public ActionDispatch(View _v) {
		
		this.v=_v;
		
		v.autorize.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				if ((v.port1.getText()!=null)||(v.adress1.getText()!=null)||(v.name.getText()!=null))
				{
				
				port=Integer.parseInt(v.port1.getText().trim());
				setConnection(v.adress1.getText().trim(),port);
				
				if(client.isConnected())
				{
					v.gameGUI(true);
				}
				}
			}});
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
