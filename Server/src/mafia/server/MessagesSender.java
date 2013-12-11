package mafia.server;

import java.util.ArrayList;


public class MessagesSender extends Thread {
	public static ArrayList<String> messages_list;
	public MessagesSender() {
		start();
	}

	@Override
	public void run() {
		try {
			while (true){
				if (!messages_list.isEmpty()){
					System.out.println(messages_list.size());
					String message = messages_list.get(0).replace("\n", ";;");	
					
					for(Client value : ClientList.clients.values()){
						value.send(message);
					}

					messages_list.remove(0);
				}
				sleep(100);
			}
		} catch (Exception e) {
			System.out.println("Exception Rised!!!");
		}
	}
}
