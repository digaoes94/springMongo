package udemy.springMongo.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import udemy.springMongo.domain.User;
import udemy.springMongo.dto.UserDTO;
import udemy.springMongo.services.UserService;

@RestController
@RequestMapping(value="/users")
public class UserResource {
	@Autowired private UserService service;
	
	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody UserDTO dto) {
		User user = service.fromDTO(dto);
		user = service.insert(user);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity<Void> update(@RequestBody UserDTO dto, @PathVariable String id) {
		User user = service.fromDTO(dto);
		user.setId(dto.getId());
		service.update(user);
		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Void> delete(@PathVariable String id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping
	public ResponseEntity<List<UserDTO>> findAll() {
		List<User> listUser = service.findAll();
		List<UserDTO> listDTO = listUser.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<UserDTO> findById(@PathVariable String id) {
		UserDTO user = new UserDTO(service.findById(id));
		return ResponseEntity.ok().body(user);
	}
}