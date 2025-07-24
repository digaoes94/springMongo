package udemy.springMongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import udemy.springMongo.domain.User;
import udemy.springMongo.dto.UserDTO;
import udemy.springMongo.repositories.UserRepository;
import udemy.springMongo.services.exceptions.ObjectNotFoundException;

@Service
public class UserService {
	@Autowired private UserRepository repo;
	
	public User insert(User user) {
		return repo.insert(user);
	}
	
	public void delete(String id) {
		findById(id);
		repo.deleteById(id);
	}
	
	public List<User> findAll() {
		return repo.findAll();
	}
	
	public User findById(String id) {
		Optional<User> user = repo.findById(id);
		return user.orElseThrow(() -> new ObjectNotFoundException("User not found."));
	}
	
	public User fromDTO(UserDTO dto) {
		return new User(dto);
	}
}