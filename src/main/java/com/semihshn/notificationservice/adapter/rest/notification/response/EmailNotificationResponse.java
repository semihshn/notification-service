package com.semihshn.notificationservice.adapter.rest.notification.response;

import com.semihshn.notificationservice.domain.notification.EmailResponse;
import lombok.*;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmailNotificationResponse {

    private String from;
    private String to;

    public static EmailNotificationResponse from(EmailResponse emailResponse) {
        return EmailNotificationResponse.builder()
                .from(emailResponse.getFrom())
                .to(emailResponse.getTo())
                .build();
    }
}
