package udemy.springMongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import udemy.springMongo.domain.User;
import udemy.springMongo.repositories.UserRepository;

@Service
public class UserService {
	@Autowired private UserRepository repo;
	
	public List<User> findAll() {
		return repo.findAll();
	}
}