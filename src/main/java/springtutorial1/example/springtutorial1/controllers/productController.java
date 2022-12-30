package springtutorial1.example.springtutorial1.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import springtutorial1.example.springtutorial1.dto.responseData;
import springtutorial1.example.springtutorial1.models.entity.Product;
import springtutorial1.example.springtutorial1.models.entity.Supplier;
import springtutorial1.example.springtutorial1.services.productService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/products")
public class productController {

    @Autowired
    private productService productService;

    @GetMapping("/all")
    public List<Product> listAllProduct(){
        return productService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Product> findByID( @PathVariable("id") Long id){
        return productService.findById(id);
    }

    @PostMapping("/save")
    public ResponseEntity<responseData<Product>> save(@Valid @RequestBody Product product, Errors errors){

        responseData<Product> responseData = new responseData<>();
        if(errors.hasErrors()){
            for(ObjectError error : errors.getAllErrors()){
                responseData.getError_messages().add(error.getDefaultMessage());
            }
            responseData.setStatus(false);
            responseData.setPayload(null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }
        responseData.setStatus(true);
        responseData.setPayload(productService.save(product));
        return ResponseEntity.status(HttpStatus.OK).body(responseData);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteByID(@PathVariable("id") Long id){ productService.removeById(id);}

    @PutMapping("/update")
    public ResponseEntity<responseData<Product>> update(@Valid @RequestBody Product product, Errors errors){

        responseData<Product> responseData = new responseData<>();
        if(errors.hasErrors()){
            for(ObjectError error : errors.getAllErrors()){
                responseData.getError_messages().add(error.getDefaultMessage());
            }
            responseData.setStatus(false);
            responseData.setPayload(null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }
        responseData.setStatus(true);
        responseData.setPayload(productService.save(product));
        return ResponseEntity.status(HttpStatus.OK).body(responseData);
    }

    @PostMapping("/addSupplier/{id}")
    public void addSupplier(@RequestBody Supplier supplier, @PathVariable("id") Long productId){
        productService.addSupplier(supplier, productId);
    }

    @GetMapping("/search/supplier/{supplierId}")
    public List<Product> getProductByCategory(@PathVariable("supplierId") Long supplierId){
        return productService.findBySupplier(supplierId);
    }
}
