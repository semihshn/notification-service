package com.semihshn.notificationservice.adapter.rest.notification.request;

import com.semihshn.notificationservice.adapter.jpa.notification.CardType;
import com.semihshn.notificationservice.domain.notification.Notification;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigInteger;
import java.time.LocalDate;

@Getter
@Setter
public class NotificationCreateRequest {

    @NotNull
    private Long driverId;

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;


    private LocalDate birthDate;

    @NotNull
    private String telephoneAddress;

    @NotNull
    private String message;


    public Notification convertToNotification() {
        return Notification.builder()
                .driverId(driverId)
                .firstName(firstName)
                .lastName(lastName)
                .birthDate(birthDate)
                .telephoneAddress(telephoneAddress)
                .message(message)
                .build();
    }
}
