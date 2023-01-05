package springtutorial1.example.springtutorial1.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springtutorial1.example.springtutorial1.services.smsService;
import springtutorial1.example.springtutorial1.sms.smsRequest;

@RestController
@RequestMapping("api/v1/sms")
public class smsController {

    private final smsService smsService;

    @Autowired
    public smsController(smsService smsService){
        this.smsService = smsService;
    }

    @PostMapping("/send")
    public void sendSms(@Valid @RequestBody smsRequest smsRequest){
        smsService.sendSms(smsRequest);
    }
}
