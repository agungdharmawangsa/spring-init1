package springtutorial1.example.springtutorial1.models.repos;

import jakarta.websocket.server.PathParam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import springtutorial1.example.springtutorial1.models.entity.Product;
import springtutorial1.example.springtutorial1.models.entity.Supplier;

import java.util.List;

public interface productRepo extends JpaRepository<Product, Long> {

    List<Product> findByNameContains(String name);

    @Query("SELECT p FROM Product p WHERE :supplier MEMBER OF p.suppliers")
    List<Product> findProductBySupplier(@PathParam("supplier") Supplier supplier);
}
