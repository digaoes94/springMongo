package resources;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import domain.User;

@RestController
@RequestMapping(value="/users")
public class UserResource {
	
	@GetMapping(value="/users")
	public ArrayList<User> findAll() {
		User maria = new User("1", "maria", "maria@maria");
		User alex = new User("2", "alex", "alex@alex");
		
		ArrayList<User> lista = new ArrayList<User>();
		lista.addAll(Arrays.asList(maria, alex));
		
		return lista;
	}
}
