package News_Agency.Assignment_3_Server.communication.messages.requests;

import java.io.Serializable;

import News_Agency.Assignment_3_Server.data_access.entities.Author;

public class CreateArticleRequest implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private Author author;
	private String title;
	private String summary;
	private String body;
	
	public CreateArticleRequest(int id, Author author, String title, String summary, String body) {
		this.id = id;
		this.author = author;
		this.title = title;
		this.summary = summary;
		this.body = body;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Author getAuthor() {
		return author;
	}
	public void setAuthor(Author author) {
		this.author = author;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
}
