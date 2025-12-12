package resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import domain.Post;
import resources.utils.URL;
import services.PostService;

@RestController
@RequestMapping(value="/posts")
public class PostResource {
	@Autowired private PostService serv;
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Post> findById(@PathVariable String id) {
		Post post = serv.findById(id);
		return ResponseEntity.ok().body(post);
	}
	
	@GetMapping(value="/titlesearch")
	public ResponseEntity<List<Post>> findByTitle(@RequestParam(value="text", defaultValue="") String text) {
		text = URL.decodeParameter(text);
		List<Post> lista = serv.findByTitle(text);
		
		return ResponseEntity.ok().body(lista);
	}
}
