package app;

import java.io.IOException;

public class ServerThread extends Thread{

   Server server = null;
	
	public void run() {
		
		// Create an instance of a Server
		server = new Server();
		try {
			
			//Start server on specified port
			server.start(4321);
			
		}catch(IOException e) {
			
			e.printStackTrace();
		}
		
		
	}
	
	
	
	
}
