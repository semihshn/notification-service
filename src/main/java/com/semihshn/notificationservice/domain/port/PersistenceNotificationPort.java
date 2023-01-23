package com.semihshn.notificationservice.domain.port;

import com.semihshn.notificationservice.domain.notification.EmailNotification;
import com.semihshn.notificationservice.domain.notification.Notification;
import com.semihshn.notificationservice.domain.notification.SmsNotification;

public interface PersistenceNotificationPort {
    EmailNotification create(EmailNotification notification);

    SmsNotification create(SmsNotification notification);

    void delete(Long id);

    Notification retrieve(Long id);
}
