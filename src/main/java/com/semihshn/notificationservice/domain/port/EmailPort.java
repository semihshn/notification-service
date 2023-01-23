package com.semihshn.notificationservice.domain.port;

import com.semihshn.notificationservice.domain.notification.EmailNotification;
import com.semihshn.notificationservice.domain.notification.EmailResponse;

public interface EmailPort {

    EmailResponse send(EmailNotification notification);
}
