package News_Agency.Assignment_3_Server.data_access.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import News_Agency.Assignment_3_Server.data_access.entities.Article;
import News_Agency.Assignment_3_Server.data_access.entities.Author;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Integer>{
	public Optional<Article> findById(int id);
	
	public Article findByTitle(String title);
	
	public Article deleteByTitle(String title);
	
	public List<Article> findAllByAuthor(Author author);
	
	public List<Article> findAll();
}
