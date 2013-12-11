package mafia.client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {

	private static View _view;
	private static  ActionDispatch a;
	private static Controller c;
	public static void main(String args[])
	{
		
		_view=new View();
		a=new ActionDispatch(_view);
		c=new Controller(_view,a);
		
		
		_view.show();
		
		
		
		
		
		
	}
	
	

}
