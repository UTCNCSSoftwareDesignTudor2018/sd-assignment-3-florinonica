package News_Agency.Assignment_3_Server.communication;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import News_Agency.Assignment_3_Server.communication.messages.requests.ArticleRequest;
import News_Agency.Assignment_3_Server.communication.messages.requests.CreateArticleRequest;
import News_Agency.Assignment_3_Server.communication.messages.requests.DeleteArticleRequest;
import News_Agency.Assignment_3_Server.communication.messages.requests.LoginRequest;
import News_Agency.Assignment_3_Server.communication.messages.requests.UpdateArticleRequest;
import News_Agency.Assignment_3_Server.communication.messages.requests.responses.ArticleResponse;
import News_Agency.Assignment_3_Server.communication.messages.requests.responses.GetArticleListResponse;
import News_Agency.Assignment_3_Server.communication.messages.requests.responses.LoginResponse;
import News_Agency.Assignment_3_Server.data_access.entities.Article;
import News_Agency.Assignment_3_Server.data_access.entities.Author;
import News_Agency.Assignment_3_Server.services.ArticleService;
import News_Agency.Assignment_3_Server.services.AuthorService;

@Service
public class RequestParser {

	@Autowired
	private AuthorService authorService;

	@Autowired
	private ArticleService articleService;

	public LoginResponse executeRequestLogin(LoginRequest request) {
		String userName = request.getUsername();
		String password = request.getPassword();
		Author author = this.authorService.getAuthorByLoginCredentials(userName, password);
		LoginResponse response = new LoginResponse(author);
		return response;
	}

	public GetArticleListResponse executeRequest() {
		List<Article> articleList = articleService.getAll();
		GetArticleListResponse response = new GetArticleListResponse(articleList);
		return response;
	}

	public ArticleResponse executeRequest(ArticleRequest request) {
		String title = request.getTitle();
		Article article = articleService.getArticleByTitle(title);
		ArticleResponse response = new ArticleResponse(article);
		return response;
	}
	
	public void executeRequest(DeleteArticleRequest request) {
		String title = request.getTitle();
		articleService.delete(title);
	}
	
	public void executeRequest(UpdateArticleRequest request) {
		int id = request.getId();
		Author author = request.getAuthor();
		String title = request.getTitle();
		String summary = request.getSummary();
		String body = request.getBody();
		articleService.saveArticle(new Article(id, author, title, summary, body));
	}
	
	public void executeRequest(CreateArticleRequest request) {
		int id = request.getId();
		Author author = request.getAuthor();
		String title = request.getTitle();
		String summary = request.getSummary();
		String body = request.getBody();
		articleService.saveArticle(new Article(id, author, title, summary, body));
	}
}
