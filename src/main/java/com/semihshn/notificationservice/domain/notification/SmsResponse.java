package com.semihshn.notificationservice.domain.notification;

import com.twilio.rest.api.v2010.account.Message;
import lombok.*;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SmsResponse {
    private String from;
    private String to;
    private String price;
    private String accountSid;

    public static SmsResponse from(Message message) {
        return SmsResponse.builder()
                .from(message.getFrom().getEndpoint())
                .to(message.getTo())
                .price(message.getPrice())
                .accountSid(message.getAccountSid())
                .build();
    }
}
