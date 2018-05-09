package News_Agency.Assignment_3_Server.data_access.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import News_Agency.Assignment_3_Server.data_access.entities.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long>{
	public Optional<Author> findById(Long id);
	
	public Author findByUsernameAndPassword(String userName, String password);
}
