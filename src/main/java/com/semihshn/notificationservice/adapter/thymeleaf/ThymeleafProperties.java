package com.semihshn.notificationservice.adapter.thymeleaf;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@Validated
@Configuration
@ConfigurationProperties(prefix = "spring.mail")
public class ThymeleafProperties {

    @NotNull
    private String username;
}
