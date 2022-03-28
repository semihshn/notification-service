package com.semihshn.notificationservice.domain.notification;

import com.semihshn.notificationservice.domain.port.NotificationPort;
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

    @BeforeEach
    void setUp() {
        notificationService = new NotificationService(notificationPort);
    }

    @Test
    void create() {
        //given
        Notification notification = Notification.builder().build();

        //mock
        Notification createdNotification = Notification.builder().id(3L).build();
        when(notificationPort.create(any())).thenReturn(createdNotification);

        //when
        Long createdNotificationId = notificationService.create(notification);

        //then
        assertThat(createdNotificationId).isEqualTo(3);
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