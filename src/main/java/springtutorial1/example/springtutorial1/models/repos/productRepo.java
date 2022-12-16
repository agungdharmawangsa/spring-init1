package springtutorial1.example.springtutorial1.models.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import springtutorial1.example.springtutorial1.models.entity.Product;

import java.util.List;

public interface productRepo extends JpaRepository<Product, Long> {

    List<Product> findByNameContains(String name);
}
