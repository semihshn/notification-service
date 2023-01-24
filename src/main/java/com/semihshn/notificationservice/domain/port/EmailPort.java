package com.semihshn.notificationservice.domain.port;

import com.semihshn.notificationservice.domain.notification.thymeleaf.EmailNotification;
import com.semihshn.notificationservice.domain.notification.thymeleaf.EmailResponse;

public interface EmailPort {

    EmailResponse send(EmailNotification notification);
}
