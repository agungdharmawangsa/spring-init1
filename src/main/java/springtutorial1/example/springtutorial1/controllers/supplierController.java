package springtutorial1.example.springtutorial1.controllers;

import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import springtutorial1.example.springtutorial1.dto.responseData;
import springtutorial1.example.springtutorial1.dto.supplierData;
import springtutorial1.example.springtutorial1.models.entity.Supplier;
import springtutorial1.example.springtutorial1.services.supplierService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/suppliers")
public class supplierController {

    @Autowired
    private supplierService supplierService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("/save")
    public ResponseEntity<responseData<Supplier>> save(@Valid @RequestBody supplierData supplierData, Errors errors){

        responseData<Supplier> responseData = new responseData<>();
        if(errors.hasErrors()){
            for(ObjectError error : errors.getAllErrors()){
                responseData.getError_messages().add(error.getDefaultMessage());
            }
            responseData.setStatus(false);
            responseData.setPayload(null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }

        Supplier supplier = modelMapper.map(supplierData, Supplier.class);

        responseData.setStatus(true);
        responseData.setPayload(supplierService.save(supplier));
        return ResponseEntity.ok(responseData);
    }

    @GetMapping("/all")
    public List<Supplier> listAllSupplier(){
        return supplierService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Supplier> findByID(@PathVariable("id") Long id){
        return supplierService.findById(id);
    }

    @PutMapping("/update")
    public ResponseEntity<responseData<Supplier>> update(@Valid @RequestBody supplierData supplierData, Errors errors){

        responseData<Supplier> responseData = new responseData<>();
        if(errors.hasErrors()){
            for(ObjectError error : errors.getAllErrors()){
                responseData.getError_messages().add(error.getDefaultMessage());
            }
            responseData.setStatus(false);
            responseData.setPayload(null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }

        Supplier supplier = modelMapper.map(supplierData, Supplier.class);

        responseData.setStatus(true);
        responseData.setPayload(supplierService.save(supplier));
        return ResponseEntity.ok(responseData);
    }

}
