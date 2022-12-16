package springtutorial1.example.springtutorial1.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springtutorial1.example.springtutorial1.models.entity.Product;
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
    public Optional<Product> findByiD(@PathVariable("id") Long id){
        return productService.findById(id);
    }

    @PostMapping("/save")
    public Object save(@RequestBody Product product){
        Map<String, Object> response = new HashMap<String, Object>();
        response.put("data", product);
        try{
            productService.save(product);
            response.put("message", "successfully insert your data");
            return response;
        }
        catch (Exception e){
            response.put("error", e);
            return response;
        }
    }
}
