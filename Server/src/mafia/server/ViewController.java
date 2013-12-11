package mafia.server;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewController {
	public Frame view;
	GameServerSocket server;

	public ViewController(Frame frame, GameServerSocket socket) {
		server = socket;
		view = frame;
		
		initEvents();
	}

	private void initEvents(){
		startButtonclick();
	}
	
	
	private void startButtonclick() {
		view.startServer.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				view.startServer.setEnabled(false);
				server.startServer(view.portText.getText());
				

			}
		});
	}
	
	
}
