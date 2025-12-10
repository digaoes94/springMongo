package config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import domain.Post;
import domain.User;
import repositories.PostRepository;
import repositories.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {
	@Autowired UserRepository userRepo;
	@Autowired PostRepository postRepo;

	@Override
	public void run(String... args) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/YYYY");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		userRepo.deleteAll();
		postRepo.deleteAll();
		
		User u1 = new User(null, "maria", "maria@maria");
		User u2 = new User(null, "alex", "alex@alex");
		User u3 = new User(null, "sonic", "sonic@sonic");
		userRepo.saveAll(Arrays.asList(u1,u2,u3));
		
		
		
		Post p1 = new Post(null, "Alow", "Tchau", u1);
		Post p2 = new Post(null, "Hello", "Bye", u2);
		Post p3 = new Post(null, "Catchau", "Catchoi", u3);
		postRepo.saveAll(Arrays.asList(p1,p2,p3));
		
	}

}
