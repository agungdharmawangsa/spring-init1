package springtutorial1.example.springtutorial1.services;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springtutorial1.example.springtutorial1.models.entity.Category;
import springtutorial1.example.springtutorial1.models.entity.Supplier;
import springtutorial1.example.springtutorial1.models.repos.supplierRepo;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class supplierService {

    @Autowired
    private supplierRepo supplierRepo;

    public Supplier save(Supplier supplier){
        return supplierRepo.save(supplier);
    }

    public Optional<Supplier> findById(Long id){
        return supplierRepo.findById(id);
    }

    public List<Supplier> findAll(){
        return supplierRepo.findAll();
    }

    public void removeById(Long id){
        supplierRepo.deleteById(id);
    }

}
