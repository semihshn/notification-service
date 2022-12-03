package com.semihshn.notificationservice.adapter.twilio;

import com.semihshn.notificationservice.domain.notification.Notification;
import com.semihshn.notificationservice.domain.notification.TwilioResponse;
import com.semihshn.notificationservice.domain.port.TwilioPort;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class TwilioAdapter implements TwilioPort {

    private final TwilioProperties twilioProperties;

    public TwilioAdapter(TwilioProperties twilioProperties) {
        this.twilioProperties = twilioProperties;
    }

    @Override
    public TwilioResponse sendSms(Notification notification) {
        Twilio.init(twilioProperties.getAccountSid(), twilioProperties.getAuthToken());
        Message message = Message.creator(
                        new PhoneNumber(notification.getTelephoneAddress()),
                        new PhoneNumber(twilioProperties.getPhoneNumber()),
                        notification.getMessage())
                .create();

        log.info("twilio message sent, message sid: {}",message.getSid());

        return TwilioResponse.from(message);
    }
}
