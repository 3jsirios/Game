package mafia.server;


public class MainServer {



	public static void main(String[] args) {
		// TODO Автоматически созданная заглушка метода
		
		Frame frame = new Frame();
		new MessagesSender();
		GameServerSocket serverSocket = new GameServerSocket();
		ViewController viewController = new ViewController(frame, serverSocket);
		frame.show();
		
	}

}
