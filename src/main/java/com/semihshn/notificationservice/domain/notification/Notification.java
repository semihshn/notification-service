package com.semihshn.notificationservice.domain.notification;

import com.semihshn.notificationservice.adapter.jpa.notification.CardType;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.math.BigInteger;
import java.time.LocalDate;

@Getter
@Setter
@Builder
public class Notification {

    private Long id;
    private Long driverId;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private String telephoneAddress;
    private String message;
}
