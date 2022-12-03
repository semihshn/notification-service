package com.semihshn.notificationservice.domain.notification;

import com.semihshn.notificationservice.domain.port.NotificationPort;
import com.semihshn.notificationservice.domain.port.TwilioPort;
import com.twilio.rest.api.v2010.account.Message;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class NotificationService {
    private final NotificationPort notificationPort;
    private final TwilioPort twilioPort;

    public TwilioResponse send(Notification notification) {
        TwilioResponse twilioResponse = twilioPort.sendSms(notification);

        Notification temp = notificationPort.create(notification);
        log.info("notification saved to db, notification persistence id: {}", temp.getId());

        return twilioResponse;
    }

    public Notification retrieve(Long id) {
        return notificationPort.retrieve(id);
    }

    public void delete(Long id) {
        notificationPort.delete(id);
    }
}
