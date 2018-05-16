package Communication.Responses;

import java.io.Serializable;

import entities.Article;

public class ArticleResponse implements Serializable {

	private static final long serialVersionUID = 1L;
	private Article article;
	
	public ArticleResponse(Article article) {
		this.article = article;
	}
	
	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

}
