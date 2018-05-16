package presentation.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.stream.Collectors;

import com.fasterxml.jackson.databind.ObjectMapper;

import Communication.Requests.ArticleRequest;
import Communication.Requests.CreateArticleRequest;
import Communication.Requests.DeleteArticleRequest;
import Communication.Requests.LoginRequest;
import Communication.Requests.UpdateArticleRequest;
import Communication.Responses.ArticleResponse;
import Communication.Responses.GetArticleListResponse;
import Communication.Responses.LoginResponse;
import entities.Article;
import entities.Author;
import presentation.views.ArticleSelectionView;
import presentation.views.ArticleView;
import presentation.views.AuthorView;
import presentation.views.BasicView;

public class MainController implements Runnable {
	private BasicView basicView;
	private AuthorView authorView;
	private ArticleView articleView;
	private ArticleSelectionView articleSelectionView;
	private PrintWriter out;
	private BufferedReader in;
	private Author author;
	private static ObjectMapper objectMapper = new ObjectMapper();
	private int id = 100;

	public MainController(PrintWriter out, BufferedReader in) {
		this.out = out;
		this.in = in;
		this.basicView = new BasicView();
		//this.authorView = new AuthorView();
		this.articleView = new ArticleView();
		this.articleSelectionView = new ArticleSelectionView();
		basicView.addLoginListener(new LoginListener());
		basicView.addViewArticlesListener(new ViewArticlesListener());
		articleView.addArticleListListener(new ViewArticlesListener());
		articleView.addUpdateListener(new UpdateListener());
		articleView.addDeleteListener(new DeleteListener());
		articleSelectionView.addSelectListener(new SelectListener());
		//authorView.addViewArticlesListener(new ViewArticlesListener());
		//authorView.addLogoutListener(new LogoutListener());
		//authorView.addCreateArticleListener(new CreateArticleListener());
		this.basicView.setVisible(true);
	}

	class LoginListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			LoginRequest loginRequest = new LoginRequest(basicView.getUsername(), basicView.getPassword());
			out.println("LOGIN_REQUEST");
			try {
				System.out.println(objectMapper.writeValueAsString(loginRequest));
				out.println(objectMapper.writeValueAsString(loginRequest));
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}

	class ViewArticlesListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			out.println("GET_ARTICLES_REQUEST");
		}
	}

	class SelectListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			ArticleRequest articleRequest = new ArticleRequest(articleSelectionView.getArticle());
			out.println("ARTICLE_REQUEST");
			try {
				out.println(objectMapper.writeValueAsString(articleRequest));
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}

	class LogoutListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			out.println("LOGOUT_REQUEST");
		}
	}

	class UpdateListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			UpdateArticleRequest updateArticleRequest = new UpdateArticleRequest(articleView.getArticle().getId(),
					author, articleView.getTitle(), articleView.getSummary(), articleView.getContents());
			out.println("UPDATE_ARTICLE_REQUEST");
			try {
				out.println(objectMapper.writeValueAsString(updateArticleRequest));
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}

	class DeleteListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			DeleteArticleRequest deleteArticleRequest = new DeleteArticleRequest(articleView.getTitle());
			out.println("DELETE_ARTICLE_REQUEST");
			try {
				out.println(objectMapper.writeValueAsString(deleteArticleRequest));
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}

	class CreateArticleListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			id++;
			CreateArticleRequest createArticleRequest = new CreateArticleRequest(id, author, articleView.getTitle(),
					articleView.getSummary(), articleView.getContents());
			out.println("CREATE_ARTICLE_REQUEST");
			try {
				out.println(objectMapper.writeValueAsString(createArticleRequest));
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}

	public void parse(String response) throws IOException {
		String responseJson = null;
		//responseJson = in.readLine();
			if (response.equals("LOGIN_RESPONSE")) {
				
				//LoginResponse lr = objectMapper.readValue(responseJson, LoginResponse.class);
			    basicView.setVisible(false);this.authorView = new AuthorView();
				authorView.setVisible(true);
				
				authorView.addViewArticlesListener(new ViewArticlesListener());
				authorView.addLogoutListener(new LogoutListener());
				authorView.addCreateArticleListener(new CreateArticleListener());
				articleView.authorView();
				//this.author = lr.getAuthor();
			} else if (response.equals("GET_ARTICLES_RESPONSE")) {
				GetArticleListResponse galr = objectMapper.readValue(responseJson, GetArticleListResponse.class);
				articleSelectionView
						.setArticles(galr.getArticles().stream().map(Article::getTitle).collect(Collectors.toList()));
				articleSelectionView.setVisible(true);
			} else if (response.equals("ARTICLE_RESPONSE")) {
				ArticleResponse ar = objectMapper.readValue(responseJson, ArticleResponse.class);
				articleView.setArticle(ar.getArticle());
				articleView.setAuthor(ar.getArticle().getAuthor().getUsername());
				articleView.setTitle(ar.getArticle().getTitle());
				articleView.setSummary(ar.getArticle().getSummary());
				articleView.setContents(ar.getArticle().getBody());
				articleView.setVisible(true);
			} else if (response.equals("DELETE_ARTICLE_RESPONSE")) {
			} else if (response.equals("CREATE_ARTICLE_RESPONSE")) {
			} else if (response.equals("UPDATE_ARTICLE_RESPONSE")) {
			}
	}

	@Override
	public void run() {
		String response = null;
		try {
			while ((response = in.readLine()) != null) {
				//response = in.readLine();
				System.out.println("MARCEL" + response);
				parse(response);
				System.out.println(response);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
