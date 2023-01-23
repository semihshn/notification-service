package com.semihshn.notificationservice.adapter.jpa.notification;

import com.semihshn.notificationservice.adapter.jpa.common.Status;
import com.semihshn.notificationservice.domain.exception.ExceptionType;
import com.semihshn.notificationservice.domain.exception.SemDataNotFoundException;
import com.semihshn.notificationservice.domain.notification.EmailNotification;
import com.semihshn.notificationservice.domain.notification.Notification;
import com.semihshn.notificationservice.domain.notification.SmsNotification;
import com.semihshn.notificationservice.domain.port.PersistenceNotificationPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PersistenceNotificationJpaAdapter implements PersistenceNotificationPort {
    private final NotificationJpaRepository notificationJpaRepository;

    @Override
    public EmailNotification create(EmailNotification notification) {
        return notificationJpaRepository.save(NotificationEntity.from(notification)).toEmailModel();
    }

    @Override
    public SmsNotification create(SmsNotification notification) {
        return notificationJpaRepository.save(NotificationEntity.from(notification)).toSmsModel();
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
