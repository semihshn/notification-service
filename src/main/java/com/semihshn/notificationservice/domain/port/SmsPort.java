package com.semihshn.notificationservice.domain.port;

import com.semihshn.notificationservice.domain.notification.twilio.SmsNotification;
import com.semihshn.notificationservice.domain.notification.twilio.SmsResponse;

public interface SmsPort {

    SmsResponse send(SmsNotification notification);
}
