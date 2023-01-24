package com.semihshn.notificationservice.domain.notification;

import com.semihshn.notificationservice.domain.notification.thymeleaf.EmailNotification;
import com.semihshn.notificationservice.domain.notification.thymeleaf.EmailResponse;
import com.semihshn.notificationservice.domain.notification.twilio.SmsNotification;
import com.semihshn.notificationservice.domain.notification.twilio.SmsResponse;
import com.semihshn.notificationservice.domain.port.EmailPort;
import com.semihshn.notificationservice.domain.port.PersistenceNotificationPort;
import com.semihshn.notificationservice.domain.port.SmsPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class NotificationService {
    private final PersistenceNotificationPort persistenceNotificationPort;
    private final SmsPort smsPort;
    private final EmailPort emailPort;

    public SmsResponse send(SmsNotification notification) {
        SmsResponse smsResponse = smsPort.send(notification);

        SmsNotification temp = persistenceNotificationPort.create(notification);
        log.info("notification saved to db, notification persistence id: {}", temp.getId());

        return smsResponse;
    }

    public EmailResponse send(EmailNotification notification) {
        EmailResponse emailResponse = emailPort.send(notification);

        EmailNotification temp = persistenceNotificationPort.create(notification);
        log.info("notification saved to db, notification persistence id: {}", temp.getId());

        return emailResponse;
    }

    public Notification retrieve(Long id) {
        return persistenceNotificationPort.retrieve(id);
    }

    public void delete(Long id) {
        persistenceNotificationPort.delete(id);
    }
}
