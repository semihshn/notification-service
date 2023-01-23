package com.semihshn.notificationservice.adapter.rest.notification.response;

import com.semihshn.notificationservice.domain.notification.Notification;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NotificationResponse {
    private Long id;
    private Long driverId;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private String telephoneAddress;
    private String mail;
    private String message;

    public static NotificationResponse from(Notification notification) {
        return NotificationResponse.builder()
                .id(notification.getId())
                .driverId(notification.getDriverId())
                .firstName(notification.getFirstName())
                .lastName(notification.getLastName())
                .birthDate(notification.getBirthDate())
                .telephoneAddress(notification.getTelephoneAddress())
                .mail(notification.getMail())
                .message(notification.getMessage())
                .build();
    }
}
