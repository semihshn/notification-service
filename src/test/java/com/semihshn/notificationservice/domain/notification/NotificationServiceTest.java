package com.semihshn.notificationservice.domain.notification;

import com.semihshn.notificationservice.domain.notification.twilio.SmsNotification;
import com.semihshn.notificationservice.domain.notification.twilio.SmsResponse;
import com.semihshn.notificationservice.domain.port.EmailPort;
import com.semihshn.notificationservice.domain.port.PersistenceNotificationPort;
import com.semihshn.notificationservice.domain.port.SmsPort;
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
    PersistenceNotificationPort persistenceNotificationPort;

    @Mock
    SmsPort smsPort;

    @Mock
    EmailPort emailPort;

    @BeforeEach
    void setUp() {
        notificationService = new NotificationService(persistenceNotificationPort, smsPort, emailPort);
    }

    @Test
    void create() {
        //given
        String ACCOUNT_SID = "1001";
        String TO = "1002";
        String FROM = "1003";
        String MESSAGE = "message_test";

        SmsNotification notification = SmsNotification.builder().build();

        //mock
        SmsNotification createdNotification = SmsNotification.builder().id(3L).build();
        when(persistenceNotificationPort.create(any(SmsNotification.class))).thenReturn(createdNotification);

        SmsResponse smsResponse = SmsResponse.builder()
                .accountSid(ACCOUNT_SID)
                .to(TO)
                .from(FROM)
                .build();
        when(smsPort.send(notification)).thenReturn(smsResponse);

        //when
        SmsResponse createdMessage = notificationService.send(notification);

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