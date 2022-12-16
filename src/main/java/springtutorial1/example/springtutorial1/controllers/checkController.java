package springtutorial1.example.springtutorial1.controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/check")
public class checkController {

    @GetMapping
    public String checkPing(){
        return "ping ok";
    }
}
