package com.semihshn.notificationservice.adapter.jpa.notification;

import com.semihshn.notificationservice.adapter.jpa.common.Status;
import com.semihshn.notificationservice.domain.exception.ExceptionType;
import com.semihshn.notificationservice.domain.exception.SemDataNotFoundException;
import com.semihshn.notificationservice.domain.notification.Notification;
import com.semihshn.notificationservice.domain.port.NotificationPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NotificationJpaAdapter implements NotificationPort {
    private final NotificationJpaRepository notificationJpaRepository;

    @Override
    public Notification create(Notification notification) {
        return notificationJpaRepository.save(NotificationEntity.from(notification)).toModel();
    }

    @Override
    public void delete(Long id) {
        notificationJpaRepository.findById(id)
                .ifPresent(user -> {
                    user.setStatus(Status.DELETED);
                    notificationJpaRepository.save(user);
                });
    }

    @Override
    public Notification retrieve(Long id) {
        return retrieveNotificationEntity(id)
                .toModel();
    }

    private NotificationEntity retrieveNotificationEntity(Long id) {
        return notificationJpaRepository.findById(id)
                .orElseThrow(() -> new SemDataNotFoundException(ExceptionType.NOTIFICATION_DATA_NOT_FOUND));
    }
}
