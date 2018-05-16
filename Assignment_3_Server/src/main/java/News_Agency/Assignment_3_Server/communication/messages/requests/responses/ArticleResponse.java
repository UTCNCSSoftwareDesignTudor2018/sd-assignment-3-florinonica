package News_Agency.Assignment_3_Server.communication.messages.requests.responses;

import java.io.Serializable;

import News_Agency.Assignment_3_Server.data_access.entities.Article;

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
