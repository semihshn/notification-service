package com.semihshn.notificationservice.domain.notification;

import com.semihshn.notificationservice.domain.port.NotificationPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NotificationService {
    private final NotificationPort notificationPort;

    public Long create(Notification notification) {
        Notification temp = notificationPort.create(notification);
        return temp.getId();
    }

    public Notification retrieve(Long id) {
        return notificationPort.retrieve(id);
    }

    public void delete(Long id) {
        notificationPort.delete(id);
    }
}
