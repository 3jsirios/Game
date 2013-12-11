package mafia.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class GameServerSocket extends Thread {
	ServerSocket socket;
	Socket clientSocket;
	boolean serverIsRaning = false;


	public GameServerSocket() {

	}

	public void startServer(String serverPort) {
		int port = 8080;
		if (!serverPort.isEmpty()) {
			port = Integer.parseInt(serverPort);
		}
		try {
			sleep(100);
			socket = new ServerSocket(port);

		} catch (Exception e) {
			// TODO Автоматически созданный блок catch
			e.printStackTrace();
		}
		serverIsRaning = true;

		start();

	}

	public void stopServer() {
		try {
			serverIsRaning = false;
			socket.close();
			// socket = null;
			// clientSocket.close();
		} catch (Exception e) {
			// TODO Автоматически созданный блок catch
			e.printStackTrace();
		}
	}

	@Override
	public void run() {

		while (serverIsRaning) {
			try {
				clientSocket = socket.accept();
				
				ClientList.add(new Client(clientSocket));
				Frame.println("Client connected.");
			} catch (Exception e) {
				serverIsRaning = false;
				e.printStackTrace();

			}

		}

	}
}
