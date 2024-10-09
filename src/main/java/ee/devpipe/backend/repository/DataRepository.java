package ee.devpipe.backend.repository;

import ee.devpipe.backend.model.Data;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DataRepository extends JpaRepository<Data, Long> {
    // You can define custom query methods here if needed
}