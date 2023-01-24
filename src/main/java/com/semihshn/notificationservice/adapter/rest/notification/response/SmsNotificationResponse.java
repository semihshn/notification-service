package com.semihshn.notificationservice.adapter.rest.notification.response;

import com.semihshn.notificationservice.domain.notification.twilio.SmsResponse;
import lombok.*;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SmsNotificationResponse {
    private String from;
    private String to;
    private String price;
    private String accountSid;

    public static SmsNotificationResponse from(SmsResponse smsResponse) {
        return SmsNotificationResponse.builder()
                .from(smsResponse.getFrom())
                .to(smsResponse.getTo())
                .price(smsResponse.getPrice())
                .accountSid(smsResponse.getAccountSid())
                .build();
    }
}
