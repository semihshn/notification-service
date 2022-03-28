package com.semihshn.notificationservice.domain.port;

import com.semihshn.notificationservice.domain.notification.Notification;

public interface NotificationPort {
    Notification create(Notification notification);

    void delete(Long id);

    Notification retrieve(Long id);
}
