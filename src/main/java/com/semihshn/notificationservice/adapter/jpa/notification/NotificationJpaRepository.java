package com.semihshn.notificationservice.adapter.jpa.notification;

import org.springframework.data.jpa.repository.JpaRepository;


public interface NotificationJpaRepository extends JpaRepository<NotificationEntity, Long> {
}
