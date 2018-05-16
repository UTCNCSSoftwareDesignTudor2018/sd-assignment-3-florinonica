package News_Agency.Assignment_3_Server.communication.messages.requests.responses;

import java.io.Serializable;

import News_Agency.Assignment_3_Server.data_access.entities.Author;

public class LoginResponse implements Serializable{
	private static final long serialVersionUID = 1L;
	private Author author;
	
	public LoginResponse(Author Author) {
		this.author = Author;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}
}
