package springtutorial1.example.springtutorial1.services;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springtutorial1.example.springtutorial1.models.entity.Category;
import springtutorial1.example.springtutorial1.models.entity.Product;
import springtutorial1.example.springtutorial1.models.repos.categoryRepo;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class categoryService {

    @Autowired
    private categoryRepo categoryRepo;

    public Category save(Category category){
        return categoryRepo.save(category);
    }

    public Optional<Category> findById(Long id){
        return categoryRepo.findById(id);
    }

    public List<Category> findAll(){
        return categoryRepo.findAll();
    }

    public void removeById(Long id){
        categoryRepo.deleteById(id);
    }

}
