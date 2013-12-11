package mafia.server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Map;

import org.yaml.snakeyaml.Yaml;

public class Client extends Thread{
	public String id;
	
	private boolean isConected = false;
	private Socket socket;
	private BufferedReader in;
	private PrintWriter out;
	private Map<String, Object> request;
	private Yaml yaml = new Yaml();

	public Client(Socket socket) {
		this.socket = socket;
		id = socket.getPort()+"";
		
		try {
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(
					socket.getOutputStream())), true);
			send("{action: user_registration, user_id:"+ id +"}");
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	
	public void send(String str){
		out.println(str);
	}
	public void closeConection(){
		isConected =false;
		try {
			socket.close();
		} catch (IOException e) {
			// TODO Автоматически созданный блок catch
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		String str;
		while(isConected){
			try {
				str = in.readLine().replace(";;", "\n");
				request = (Map<String, Object>) yaml.load(str);
				ActionDispatch.analize(request);				
			} catch (Exception e) {
				// TODO Автоматически созданный блок catch
				e.printStackTrace();
			}
		}
	}
}
