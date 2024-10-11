package ee.devpipe.backend.repository;

import ee.devpipe.backend.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface ProductRepository extends MongoRepository<Product, String> {
    // Custom query method to find products by userId
    List<Product> findByUserId(String userId);
}