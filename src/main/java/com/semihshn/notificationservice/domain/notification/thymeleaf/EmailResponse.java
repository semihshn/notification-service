package com.semihshn.notificationservice.domain.notification.thymeleaf;

import lombok.*;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmailResponse {

    private String from;
    private String to;

    public static EmailResponse from(String from, String to) {
        return EmailResponse.builder()
                .from(from)
                .to(to)
                .build();
    }
}
