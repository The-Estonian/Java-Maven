package ee.devpipe.backend.repository;

import ee.devpipe.backend.model.AppUser;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.Optional;

public interface UserRepository extends MongoRepository<AppUser, String> {
    Optional<AppUser> findByEmail(String email);
}