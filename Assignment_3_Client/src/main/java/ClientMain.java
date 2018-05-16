import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import presentation.controllers.MainController;

public class ClientMain {
	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket ClientSocket = null;
		try {
			ClientSocket = new Socket("localhost", 1234);
			PrintWriter out = new PrintWriter(ClientSocket.getOutputStream(), true);
			BufferedReader in = new BufferedReader(new InputStreamReader(ClientSocket.getInputStream()));
			MainController ctrl = new MainController(out, in);
			ctrl.run();	
		} finally {
			ClientSocket.close();
		}
	}
}
