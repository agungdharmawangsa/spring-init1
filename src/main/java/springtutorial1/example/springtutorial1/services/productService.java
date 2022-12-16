package springtutorial1.example.springtutorial1.services;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springtutorial1.example.springtutorial1.models.entity.Product;
import springtutorial1.example.springtutorial1.models.repos.productRepo;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class productService {

    @Autowired
    private productRepo productRepo;

    public Product save(Product product){
        return productRepo.save(product);
    }

    public Optional<Product> findById(Long id){
        return productRepo.findById(id);
    }

    public List<Product> findAll(){
        return productRepo.findAll();
    }

    public void removeById(Long id){
        productRepo.deleteById(id);
    }

    public List<Product> findByName(String name){
        return productRepo.findByNameContains(name);
    }
}
