package com.semihshn.notificationservice.adapter.rest.notification;

import com.semihshn.notificationservice.adapter.rest.notification.request.NotificationSendRequest;
import com.semihshn.notificationservice.adapter.rest.notification.response.NotificationSendResponse;
import com.semihshn.notificationservice.adapter.rest.notification.response.NotificationResponse;
import com.semihshn.notificationservice.domain.notification.NotificationService;
import com.semihshn.notificationservice.domain.notification.TwilioResponse;
import com.twilio.rest.api.v2010.account.Message;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/notifications")
public class NotificationController {
    private final NotificationService notificationService;

    @PostMapping()
    public NotificationSendResponse send(@RequestBody @Valid NotificationSendRequest request) {
        TwilioResponse twilioResponse = notificationService.send(request.convertToNotification());
        return NotificationSendResponse.from(twilioResponse);
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
