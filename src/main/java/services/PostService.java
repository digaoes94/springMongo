package services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import domain.Post;
import repositories.PostRepository;
import services.exceptions.ObjectNotFoundException;

@Service
public class PostService {
	@Autowired private PostRepository repo;
	
	public Post findById(String id) {
		Object post = repo.findById(id);
		
		if(post == null) {
			throw new ObjectNotFoundException("Objeto não encontrado.");
		}
		else {
			return (Post) post;
		}
	}
	
	public List<Post> findByTitle(String text) {
		return repo.findByTitleContainingIgnoreCase(text);
	}
}
