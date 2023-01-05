package springtutorial1.example.springtutorial1.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springtutorial1.example.springtutorial1.dto.emailData;
import springtutorial1.example.springtutorial1.services.emailSenderService;

@RestController
@RequestMapping("api/v1/email")
public class emailController {

    private final emailSenderService emailSenderService;

    public emailController(springtutorial1.example.springtutorial1.services.emailSenderService emailSenderService) {
        this.emailSenderService = emailSenderService;
    }

    @PostMapping("/send")
    public ResponseEntity sendEmail(@RequestBody emailData emailData){
        this.emailSenderService.sendEmail(emailData.getTo(), emailData.getSubject(), emailData.getMessage());
        return ResponseEntity.ok("Success");
    }
}
