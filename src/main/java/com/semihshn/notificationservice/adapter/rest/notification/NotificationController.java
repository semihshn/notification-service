package com.semihshn.notificationservice.adapter.rest.notification;

import com.semihshn.notificationservice.adapter.rest.notification.request.EmailNotificationRequest;
import com.semihshn.notificationservice.adapter.rest.notification.request.SmsNotificationRequest;
import com.semihshn.notificationservice.adapter.rest.notification.response.EmailNotificationResponse;
import com.semihshn.notificationservice.adapter.rest.notification.response.SmsNotificationResponse;
import com.semihshn.notificationservice.adapter.rest.notification.response.NotificationResponse;
import com.semihshn.notificationservice.domain.notification.thymeleaf.EmailResponse;
import com.semihshn.notificationservice.domain.notification.NotificationService;
import com.semihshn.notificationservice.domain.notification.twilio.SmsResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/notifications")
public class NotificationController {
    private final NotificationService notificationService;

    @PostMapping("/sms")
    public SmsNotificationResponse sendSms(@RequestBody @Valid SmsNotificationRequest request) {
        SmsResponse smsResponse = notificationService.send(request.convertToNotification());
        return SmsNotificationResponse.from(smsResponse);
    }

    @PostMapping("/email")
    public EmailNotificationResponse sendEmail(@RequestBody @Valid EmailNotificationRequest request) {
        EmailResponse emailResponse = notificationService.send(request.convertToNotification());
        return EmailNotificationResponse.from(emailResponse);
    }

    @DeleteMapping("{notificationId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long notificationId) {
        notificationService.delete(notificationId);
    }

    @GetMapping("{notificationId}")
    public NotificationResponse retrieve(@PathVariable Long notificationId) {
        return NotificationResponse.from(notificationService.retrieve(notificationId));
    }
}
