package com.semihshn.notificationservice.adapter.rest.notification.request;

import com.semihshn.notificationservice.domain.notification.SmsNotification;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@Setter
public class SmsNotificationRequest {

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

    public SmsNotification convertToNotification() {
        return SmsNotification.builder()
                .driverId(driverId)
                .firstName(firstName)
                .lastName(lastName)
                .birthDate(birthDate)
                .telephoneAddress(telephoneAddress)
                .message(message)
                .build();
    }
}
