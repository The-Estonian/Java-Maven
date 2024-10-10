package ee.devpipe.backend.repository;

import ee.devpipe.backend.model.Data;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DataRepository extends MongoRepository<Data, String> {
    // Additional query methods can be defined here
}