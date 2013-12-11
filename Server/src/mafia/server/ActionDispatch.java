package mafia.server;

import java.util.Map;

public class ActionDispatch {
	private static String requested_action ;
	public static void analize( Map<String, Object> request) {
		if (request.containsKey("action")) {
			requested_action = (String)request.get("action");
			findAction(requested_action );
		}		
		
	}
	
	private static void findAction(String action) {
		
	}

}
