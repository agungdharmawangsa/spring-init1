package springtutorial1.example.springtutorial1.models.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import springtutorial1.example.springtutorial1.models.entity.Category;

public interface categoryRepo extends JpaRepository<Category, Long> {
}
