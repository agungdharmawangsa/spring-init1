package springtutorial1.example.springtutorial1.models.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import springtutorial1.example.springtutorial1.models.entity.Supplier;

public interface supplierRepo extends JpaRepository<Supplier, Long> {
}
