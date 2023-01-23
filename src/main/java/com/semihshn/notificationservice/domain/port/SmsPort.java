package com.semihshn.notificationservice.domain.port;

import com.semihshn.notificationservice.domain.notification.SmsNotification;
import com.semihshn.notificationservice.domain.notification.SmsResponse;

public interface SmsPort {

    SmsResponse send(SmsNotification notification);
}
