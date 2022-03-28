package com.semihshn.notificationservice.adapter.jpa.notification;

import com.semihshn.notificationservice.adapter.jpa.common.BaseEntity;
import com.semihshn.notificationservice.adapter.jpa.common.Status;
import com.semihshn.notificationservice.domain.notification.Notification;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import java.math.BigInteger;
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
    private String telephoneAddress;
    private String message;

    public static NotificationEntity from(Notification notification) {
        NotificationEntity notificationEntity = new NotificationEntity();
        notificationEntity.id = notification.getId();
        notificationEntity.driverId=notification.getDriverId();
        notificationEntity.firstName=notification.getFirstName();
        notificationEntity.lastName=notification.getLastName();
        notificationEntity.birthDate=notification.getBirthDate();
        notificationEntity.telephoneAddress=notification.getTelephoneAddress();
        notificationEntity.message=notification.getMessage();
        notificationEntity.status = Status.ACTIVE;
        return notificationEntity;
    }

    public Notification toModel() {
        return Notification.builder()
                .id(id)
                .driverId(driverId)
                .firstName(firstName)
                .lastName(lastName)
                .birthDate(birthDate)
                .telephoneAddress(telephoneAddress)
                .message(message)
                .build();
    }
}
