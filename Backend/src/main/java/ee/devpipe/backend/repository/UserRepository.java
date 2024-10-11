package ee.devpipe.backend.repository;

import ee.devpipe.backend.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
    // Additional query methods can be defined here
}