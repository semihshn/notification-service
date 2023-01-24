package com.semihshn.notificationservice.adapter.rest.notification.request;

import com.semihshn.notificationservice.domain.notification.thymeleaf.EmailNotification;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@Setter
public class EmailNotificationRequest {

    @NotNull
    private Long driverId;

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    private LocalDate birthDate;

    @NotNull
    private String mail;

    @NotNull
    private String message;

    public EmailNotification convertToNotification() {
        return EmailNotification.builder()
                .driverId(driverId)
                .firstName(firstName)
                .lastName(lastName)
                .birthDate(birthDate)
                .mail(mail)
                .message(message)
                .build();
    }
}
