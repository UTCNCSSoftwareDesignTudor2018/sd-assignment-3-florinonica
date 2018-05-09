package News_Agency.Assignment_3_Server.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import News_Agency.Assignment_3_Server.data_access.entities.Author;
import News_Agency.Assignment_3_Server.data_access.repositories.AuthorRepository;

@Service
public class AuthorService {
	@Autowired
	private AuthorRepository authorRepository;
	
	public Author getAuthorById(Long id) {
		return authorRepository.findById(id).get();
	}
	
	public Author getAuthorByLoginCredentials(String userName, String password) {
		return authorRepository.findByUsernameAndPassword(userName, password);
	}
}
