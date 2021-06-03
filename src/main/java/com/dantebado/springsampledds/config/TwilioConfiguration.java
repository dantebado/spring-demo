package com.dantebado.springsampledds.config;

import com.twilio.Twilio;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TwilioConfiguration {

    @Value("${twilio.account-sid}")
    String ACCOUNT_SID;
    @Value("${twilio.auth_token}")
    String AUTH_TOKEN;

    public void setupTwilioAccount() {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
    }

}
