package mafia.server;

import java.util.HashMap;
import java.util.Map;


public class ClientList {
	public static Map<String, Client> clients = new HashMap<String, Client>();

	public static void add(Client client) {
		clients.put(client.id, client);
	}
	
	public static void send(String message){
		
	}
	
	
	
}
