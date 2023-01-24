package com.semihshn.notificationservice.adapter.jpa.notification;

import com.semihshn.notificationservice.adapter.jpa.common.BaseEntity;
import com.semihshn.notificationservice.adapter.jpa.common.Status;
import com.semihshn.notificationservice.domain.notification.thymeleaf.EmailNotification;
import com.semihshn.notificationservice.domain.notification.Notification;
import com.semihshn.notificationservice.domain.notification.twilio.SmsNotification;
import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.Nullable;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

@Getter
@Setter
@Entity(name = "notifications")
@Table(name = "notifications")
public class NotificationEntity extends BaseEntity {

    private Long driverId;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private String message;

    @Nullable
    private String telephoneAddress;

    @Nullable
    private String mail;

    public static NotificationEntity from(SmsNotification notification) {
        NotificationEntity notificationEntity = new NotificationEntity();
        notificationEntity.id = notification.getId();
        notificationEntity.driverId = notification.getDriverId();
        notificationEntity.firstName = notification.getFirstName();
        notificationEntity.lastName = notification.getLastName();
        notificationEntity.birthDate = notification.getBirthDate();
        notificationEntity.telephoneAddress = notification.getTelephoneAddress();
        notificationEntity.message = notification.getMessage();
        notificationEntity.status = Status.ACTIVE;
        return notificationEntity;
    }

    public static NotificationEntity from(EmailNotification notification) {
        NotificationEntity notificationEntity = new NotificationEntity();
        notificationEntity.id = notification.getId();
        notificationEntity.driverId = notification.getDriverId();
        notificationEntity.firstName = notification.getFirstName();
        notificationEntity.lastName = notification.getLastName();
        notificationEntity.birthDate = notification.getBirthDate();
        notificationEntity.mail = notification.getMail();
        notificationEntity.message = notification.getMessage();
        notificationEntity.status = Status.ACTIVE;
        return notificationEntity;
    }

    public EmailNotification toEmailModel() {
        return EmailNotification.builder()
                .id(id)
                .driverId(driverId)
                .firstName(firstName)
                .lastName(lastName)
                .birthDate(birthDate)
                .mail(mail)
                .message(message)
                .build();
    }

    public SmsNotification toSmsModel() {
        return SmsNotification.builder()
                .id(id)
                .driverId(driverId)
                .firstName(firstName)
                .lastName(lastName)
                .birthDate(birthDate)
                .telephoneAddress(telephoneAddress)
                .message(message)
                .build();
    }

    public Notification toModel() {
        return Notification.builder()
                .id(id)
                .driverId(driverId)
                .firstName(firstName)
                .lastName(lastName)
                .birthDate(birthDate)
                .telephoneAddress(telephoneAddress)
                .mail(mail)
                .message(message)
                .build();
    }
}
