package config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import domain.User;
import repositories.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {
	@Autowired UserRepository userRepo;

	@Override
	public void run(String... args) throws Exception {
		userRepo.deleteAll();
		
		User u1 = new User(null, "maria", "maria@maria");
		User u2 = new User(null, "alex", "alex@alex");
		User u3 = new User(null, "sonic", "sonic@sonic");
		
		userRepo.saveAll(Arrays.asList(u1,u2,u3));
		
	}

}
