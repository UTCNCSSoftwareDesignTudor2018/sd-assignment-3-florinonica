package Communication.Responses;

import java.io.Serializable;

import entities.Author;

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
