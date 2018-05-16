package entities;

import java.io.Serializable;

public class Article implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private Author author;
	private String title;
	private String summary;
	private String body;
	
	public Article(int id, Author author, String title, String summary, String body) {
		this.id = id;
		this.author = author;
		this.title = title;
		this.summary = summary;
		this.body = body;
	}
	
	public Article() {}
	
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
