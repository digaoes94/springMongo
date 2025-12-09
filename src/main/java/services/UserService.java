package services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import domain.User;
import repositories.UserRepository;
import services.exceptions.ObjectNotFoundException;

@Service
public class UserService {
	@Autowired private UserRepository repo;
	
	public User findById(String id) {
		Object user = repo.findById(id);
		
		if(user == null) {
			throw new ObjectNotFoundException("Objeto não encontrado.");
		}
		else {
			return (User) user;
		}
	}
	
	public List<User> findAll() {
		return repo.findAll();
	}
}
