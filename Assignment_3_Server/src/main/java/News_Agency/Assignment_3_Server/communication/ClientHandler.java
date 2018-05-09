package News_Agency.Assignment_3_Server.communication;

import java.net.Socket;

public class ClientHandler implements Runnable{
	private Socket ClientSocket;
	public ClientHandler(Socket socket) {
		this.ClientSocket = socket;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
}
