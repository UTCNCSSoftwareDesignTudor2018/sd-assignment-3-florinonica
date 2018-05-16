package News_Agency.Assignment_3_Server.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import News_Agency.Assignment_3_Server.data_access.entities.Article;
import News_Agency.Assignment_3_Server.data_access.entities.Author;
import News_Agency.Assignment_3_Server.data_access.repositories.ArticleRepository;

@Service
public class ArticleService {
	@Autowired
	private ArticleRepository articleRepository;
	
	public Article getArticleById(int id) {
		return articleRepository.findById(id).get();
	}
	
	public Article getArticleByTitle(String title) {
		return articleRepository.findByTitle(title);
	}
	
	public void delete(String title) {
		articleRepository.deleteByTitle(title);
	}
	
	public List<Article> getArticleByAuthor(Author author) {
		return articleRepository.findAllByAuthor(author);
	}
	
	public List<Article> getAll() {
		return articleRepository.findAll();
	}
	
	public Article saveArticle(Article a) {
		return articleRepository.save(a);
	}
}
