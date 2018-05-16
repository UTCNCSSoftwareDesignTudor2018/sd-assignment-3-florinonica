package News_Agency.Assignment_3_Server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import News_Agency.Assignment_3_Server.communication.Server;

@SpringBootApplication
public class Assignment3ServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(Assignment3ServerApplication.class, args);
		Server server = new Server();
		server.run();
	}
}
