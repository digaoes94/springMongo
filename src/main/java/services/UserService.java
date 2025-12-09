package services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import domain.User;
import dtos.UserDTO;
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
	
	public User insert(User user) {
		return repo.insert(user);
	}
	
	public User fromDTO(UserDTO dto) {
		return new User(dto);
	}
}
