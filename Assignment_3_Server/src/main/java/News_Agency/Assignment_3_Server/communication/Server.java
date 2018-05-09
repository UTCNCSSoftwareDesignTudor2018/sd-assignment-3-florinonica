package News_Agency.Assignment_3_Server.communication;

import java.io.IOException;
import java.net.ServerSocket;

public class Server implements Runnable{

	@Override
	public void run() {
		ServerSocket server;
		try {
			server = new ServerSocket(1234);		
			try {
				while(true)
				{
					new Thread(new ClientHandler(server.accept())).start();
				}
				
			} finally {
				server.close();
			}		
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
