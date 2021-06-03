package com.dantebado.springsampledds.services;

import com.dantebado.springsampledds.config.TwilioConfiguration;
import com.dantebado.springsampledds.model.users.User;
import com.twilio.rest.api.v2010.account.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class TwilioSvc {

    @Autowired
    TwilioConfiguration twilioConfiguration;

    @Value("${twilio.whatsapp.phone-number}")
    String TWILIO_WHATSAPP_FROM_NUMBER;

    @Value("${twilio.sms.phone-number}")
    String TWILIO_SMS_FROM_NUMBER;

    @Async
    public void sendRecoveryCodeToUser(User user) {
        if (user.getMobilePhoneNumber() == null) return;

        twilioConfiguration.setupTwilioAccount();

        Message.creator(
            new com.twilio.type.PhoneNumber("whatsapp:" + user.getMobilePhoneNumber()),
            new com.twilio.type.PhoneNumber("whatsapp:" + TWILIO_WHATSAPP_FROM_NUMBER),
            "*Hi " + user.getEmail() + "!*\nThis is your Pet's recovery code. Do not share it.\n\n*Code:* " + user.getPasswordRecoveryCode())
            .create();

        Message.creator(
            new com.twilio.type.PhoneNumber(user.getMobilePhoneNumber()),
            new com.twilio.type.PhoneNumber(TWILIO_SMS_FROM_NUMBER),
            "Hi " + user.getEmail() + "!\nThis is your Pet's recovery code. Do not share it.\n\nCode: " + user.getPasswordRecoveryCode())
            .create();
    }

}
