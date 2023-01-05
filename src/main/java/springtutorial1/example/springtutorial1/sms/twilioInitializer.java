package springtutorial1.example.springtutorial1.sms;

import com.twilio.Twilio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class twilioInitializer {
    private final twilioConfiguration twilioConfiguration;

    @Autowired
    public twilioInitializer(twilioConfiguration twilioConfiguration){
        this.twilioConfiguration = twilioConfiguration;
        Twilio.init(
//                "AC2705fac931fb450ea96cddc562e733bd",
//                    "e0177bb859da3965f52621e7db361de8"
                twilioConfiguration.getAccount(),
                twilioConfiguration.getAuth()
        );
    }
}
