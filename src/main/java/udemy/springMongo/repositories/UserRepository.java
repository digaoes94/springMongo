package udemy.springMongo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import udemy.springMongo.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

}