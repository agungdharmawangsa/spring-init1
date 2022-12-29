package springtutorial1.example.springtutorial1.controllers;

import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import springtutorial1.example.springtutorial1.dto.categoryData;
import springtutorial1.example.springtutorial1.dto.responseData;
import springtutorial1.example.springtutorial1.models.entity.Category;
import springtutorial1.example.springtutorial1.models.entity.Supplier;
import springtutorial1.example.springtutorial1.services.categoryService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/categories")
public class categoryController {

    @Autowired
    private categoryService categoryService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("/save")
    public ResponseEntity<responseData<Category>> save(@Valid @RequestBody categoryData categoryData, Errors errors){
        responseData<Category> responseData = new responseData<>();

        if(errors.hasErrors()){
            for(ObjectError error : errors.getAllErrors()){
                responseData.getError_messages().add(error.getDefaultMessage());
            }
            responseData.setStatus(false);
            responseData.setPayload(null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }
        Category category = modelMapper.map(categoryData, Category.class);
        responseData.setStatus(true);
        responseData.setPayload(categoryService.save(category));
        return ResponseEntity.ok(responseData);
    }

    @GetMapping("/all")
    public List<Category> listAllSupplier(){
        return categoryService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Category> findByID(@PathVariable("id") Long id){
        return categoryService.findById(id);
    }

    @PutMapping("/update")
    public ResponseEntity<responseData<Category>> update(@Valid @RequestBody categoryData categoryData, Errors errors){
        responseData<Category> responseData = new responseData<>();

        if(errors.hasErrors()){
            for(ObjectError error : errors.getAllErrors()){
                responseData.getError_messages().add(error.getDefaultMessage());
            }
            responseData.setStatus(false);
            responseData.setPayload(null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }
        Category category = modelMapper.map(categoryData, Category.class);
        responseData.setStatus(true);
        responseData.setPayload(categoryService.save(category));
        return ResponseEntity.ok(responseData);
    }
}
