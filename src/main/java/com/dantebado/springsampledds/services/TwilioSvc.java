package com.dantebado.springsampledds.services;

import com.dantebado.springsampledds.config.TwilioConfiguration;
import com.twilio.rest.api.v2010.account.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TwilioSvc {

    @Autowired
    TwilioConfiguration twilioConfiguration;

    public void testTwilioConfig() {
        twilioConfiguration.setupTwilioAccount();
    }

}
