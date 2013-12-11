package mafia.server;

import java.util.Map;


public class ClientList {
	public static Map<String, Client> clients;

	public static void add(Client client) {
		clients.put(client.id, client);
	}
	
	public static void send(String message){
		
	}
	
	
	
}
