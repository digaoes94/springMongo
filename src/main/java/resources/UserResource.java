package resources;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
		List<UserDTO> dtos = new ArrayList<UserDTO>();
		
		for(User u : users) {
			dtos.add(new UserDTO(u));
		}
		
		return ResponseEntity.ok().body(dtos);
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<UserDTO> findById(@PathVariable String id) {
		User user = serv.findById(id);
		return ResponseEntity.ok().body(new UserDTO(user));
	}
	
	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody UserDTO dto) {
		User user = serv.fromDTO(dto);
		user = serv.insert(user);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable String id) {
		serv.deleteById(id);
		return ResponseEntity.noContent().build();
	}
}
