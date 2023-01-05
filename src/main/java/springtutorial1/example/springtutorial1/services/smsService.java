package springtutorial1.example.springtutorial1.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import springtutorial1.example.springtutorial1.sms.smsRequest;
import springtutorial1.example.springtutorial1.sms.smsSender;
import springtutorial1.example.springtutorial1.sms.twilioSmsSender;

@Service
public class smsService {

    private final smsSender smsSender;

    @Autowired
    public smsService(@Qualifier("twilio") smsSender smsSender){
        this.smsSender = smsSender;
    }

    public void sendSms(smsRequest smsRequest){
        smsSender.sendSms(smsRequest);
    }
}
