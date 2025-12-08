package resources;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import domain.User;
import dtos.UserDTO;
import services.UserService;

@RestController
@RequestMapping(value="/users")
public class UserResource {
	@Autowired private UserService serv;
	
	@GetMapping
	public ResponseEntity<List<UserDTO>> findAll() {
		List<User> users = serv.findAll();
		List<UserDTO> dtos = users.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
		
		for(User user : users) {
			dtos.add(new UserDTO(user));
		}
		
		return ResponseEntity.ok().body(dtos);
	}
}
