package com.semihshn.notificationservice.domain.port;

import com.semihshn.notificationservice.domain.notification.Notification;
import com.semihshn.notificationservice.domain.notification.TwilioResponse;

public interface TwilioPort {

    TwilioResponse sendSms(Notification notification);
}
