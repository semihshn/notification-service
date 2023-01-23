package com.semihshn.notificationservice.domain.notification;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Builder
public class EmailNotification {

    private Long id;
    private Long driverId;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private String mail;
    private String message;
}
