package springtutorial1.example.springtutorial1.services;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springtutorial1.example.springtutorial1.models.entity.Product;
import springtutorial1.example.springtutorial1.models.entity.Supplier;
import springtutorial1.example.springtutorial1.models.repos.productRepo;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class productService {

    @Autowired
    private productRepo productRepo;

    @Autowired
    private supplierService supplierService;

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

    public void addSupplier(Supplier supplier, Long productId){
        Optional<Product> product_exist = findById(productId);
        if(product_exist.isEmpty()){
            throw new RuntimeException("Product with ID : "+productId+" not found");
        }
        Product product = product_exist.get();
        product.getSuppliers().add(supplier);
        save(product);
    }

    public List<Product> findBySupplier(Long supplierId){
        Optional<Supplier> supplier_exist = supplierService.findById(supplierId);
        if(supplier_exist.isEmpty()){
            throw new RuntimeException("Supplier with ID : "+supplierId+" not found");
        }
        Supplier supplier = supplier_exist.get();
        return productRepo.findProductBySupplier(supplier);
    }
}
