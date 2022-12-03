package com.semihshn.notificationservice.adapter.twilio;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Validated
@Configuration
@ConfigurationProperties(prefix = "twilio")
public class TwilioProperties {

    @NotBlank
    private String accountSid;

    @NotNull
    private String authToken;

    @NotNull
    private String phoneNumber;
}
