package com.semihshn.notificationservice.adapter.rest.notification.response;

import com.semihshn.notificationservice.domain.notification.TwilioResponse;
import com.twilio.rest.api.v2010.account.Message;
import lombok.*;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NotificationSendResponse {
    private String from;
    private String to;
    private String price;
    private String accountSid;

    public static NotificationSendResponse from(TwilioResponse twilioResponse) {
        return NotificationSendResponse.builder()
                .from(twilioResponse.getFrom())
                .to(twilioResponse.getTo())
                .price(twilioResponse.getPrice())
                .accountSid(twilioResponse.getAccountSid())
                .build();
    }
}
