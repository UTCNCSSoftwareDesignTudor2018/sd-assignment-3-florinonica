package News_Agency.Assignment_3_Server.communication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import com.fasterxml.jackson.databind.ObjectMapper;

import News_Agency.Assignment_3_Server.communication.messages.requests.ArticleRequest;
import News_Agency.Assignment_3_Server.communication.messages.requests.CreateArticleRequest;
import News_Agency.Assignment_3_Server.communication.messages.requests.DeleteArticleRequest;
import News_Agency.Assignment_3_Server.communication.messages.requests.GetArticleListRequest;
import News_Agency.Assignment_3_Server.communication.messages.requests.LoginRequest;
import News_Agency.Assignment_3_Server.communication.messages.requests.UpdateArticleRequest;

public class ClientHandler extends Thread{
	private BufferedReader in;
	private PrintWriter out;
	private Socket ClientSocket;
	private static ObjectMapper objectMapper = new ObjectMapper();
	private RequestParser parser = new RequestParser();
	
	public ClientHandler(Socket socket) throws IOException {
		this.ClientSocket = socket;
		this.in = new BufferedReader(new InputStreamReader(ClientSocket.getInputStream()));
		this.out = new PrintWriter(ClientSocket.getOutputStream());
	}
	
	public String parse(String request) throws IOException {
		String response = null;
		String requestJson = in.readLine();
    	if(request.equals("LOGIN_REQUEST")) {
    		out.println("LOGIN_RESPONSE");
    		System.out.println(request);
    		response = "LOGIN_RESPONSE";
    		out.println(objectMapper.writeValueAsString(parser.executeRequestLogin(objectMapper.readValue(requestJson, LoginRequest.class))));
    		System.out.println(response);
    	} else if(request.equals("GET_ARTICLES_REQUEST")) {
    		out.println("GET_ARTICLES_RESPONSE");
    		System.out.println(request);
    		response = "GET_ARTICLES_RESPONSE";
    		response = objectMapper.writeValueAsString(parser.executeRequest());
    	} else if(request.equals("ARTICLE_REQUEST")) {
    		out.println("ARTICLE_RESPONSE");
    		response = objectMapper.writeValueAsString(parser.executeRequest(objectMapper.readValue(requestJson, ArticleRequest.class)));
    	} else if(request.equals("DELETE_ARTICLE_REQUEST")) {
    		parser.executeRequest(objectMapper.readValue(requestJson, DeleteArticleRequest.class));
    		response = "Done";
    	} else if(request.equals("CREATE_ARTICLE_REQUEST")) {
    		parser.executeRequest(objectMapper.readValue(requestJson, CreateArticleRequest.class));
    		response = "Done";
    	} else if(request.equals("UPDATE_ARTICLE_REQUEST")) {
    		parser.executeRequest(objectMapper.readValue(requestJson, UpdateArticleRequest.class));
    		response = "Done";
    	}
    	
		return response;
	}
	
	@Override
	public void run() {
		String response = null;
		String request = null;
		try {
            while ((request = in.readLine()) != null) {
                
                try {
                	System.out.println(request);
					response = parse(request);
				} catch (IOException e) {
					e.printStackTrace();
				}
                out.println(response);
            }
        } catch (IOException e) {
        	e.printStackTrace();
        } finally {
            try {
				ClientSocket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
        }
	}
}
