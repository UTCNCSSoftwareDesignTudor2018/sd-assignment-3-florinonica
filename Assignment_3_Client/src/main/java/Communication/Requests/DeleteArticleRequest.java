package Communication.Requests;

import java.io.Serializable;

public class DeleteArticleRequest implements Serializable{
	private static final long serialVersionUID = 1L;
	private String articleTitle;
	
	public DeleteArticleRequest(String articleTitle) {
		this.articleTitle = articleTitle;
	}
	
	public String getArticleTitle() {
		return articleTitle;
	}
	
	public void setArticleTitle(String articleTitle) {
		this.articleTitle = articleTitle;
	}
}
