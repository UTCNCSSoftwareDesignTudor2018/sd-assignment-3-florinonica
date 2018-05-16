package News_Agency.Assignment_3_Server.communication.messages.requests.responses;

import java.io.Serializable;
import java.util.List;

import News_Agency.Assignment_3_Server.data_access.entities.Article;

public class GetArticleListResponse implements Serializable {

	private static final long serialVersionUID = 1L;
	private List<Article> articles;
	
	public GetArticleListResponse(List<Article> articles) {
		this.articles = articles;
	}
	
	public List<Article> getArticles() {
		return articles;
	}

	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}

}
