package com.semihshn.notificationservice.domain.notification;

import com.semihshn.notificationservice.domain.port.NotificationPort;
import com.semihshn.notificationservice.domain.port.TwilioPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class NotificationServiceTest {

    NotificationService notificationService;

    @Mock
    NotificationPort notificationPort;

    @Mock
    TwilioPort twilioPort;

    @BeforeEach
    void setUp() {
        notificationService = new NotificationService(notificationPort, twilioPort);
    }

    @Test
    void create() {
        //given
        String ACCOUNT_SID = "1001";
        String TO = "1002";
        String FROM = "1003";
        String MESSAGE = "message_test";

        Notification notification = Notification.builder().build();

        //mock
        Notification createdNotification = Notification.builder().id(3L).build();
        when(notificationPort.create(any())).thenReturn(createdNotification);

        TwilioResponse twilioResponse = TwilioResponse.builder()
                .accountSid(ACCOUNT_SID)
                .to(TO)
                .from(FROM)
                .build();
        when(twilioPort.sendSms(notification)).thenReturn(twilioResponse);

        //when
        TwilioResponse createdMessage = notificationService.send(notification);

        //then
        assertThat(createdMessage.getAccountSid()).isEqualTo(ACCOUNT_SID);
    }

    @Test
    void retrieve() {
        //mock
        when(notificationService.retrieve(anyLong())).thenReturn(Notification.builder().build());

        Notification mockNotification = Notification.builder()
                .id(1L)
                .driverId(1L)
                .firstName("Test_first_name")
                .lastName("Test_last_name")
                .birthDate(LocalDate.now())
                .telephoneAddress("0530 585 39 20")
                .message("Test_message")
                .build();

        when(notificationService.retrieve(1L)).thenReturn(mockNotification);

        //when
        Notification notification = notificationService.retrieve(1L);

        //then
        assertThat(notification).isNotNull();
        assertThat(notification.getId()).isEqualTo(1L);
        assertThat(notification.getTelephoneAddress()).isEqualTo("0530 585 39 20");
        assertThat(notification.getBirthDate()).isEqualTo(LocalDate.now());
    }

    @Test
    void delete() {
    }
}