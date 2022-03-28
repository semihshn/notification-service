package com.semihshn.notificationservice.adapter.rest.notification;

import com.semihshn.notificationservice.adapter.rest.notification.request.NotificationCreateRequest;
import com.semihshn.notificationservice.adapter.rest.notification.response.NotificationCreateResponse;
import com.semihshn.notificationservice.adapter.rest.notification.response.NotificationResponse;
import com.semihshn.notificationservice.domain.notification.NotificationService;
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
    public NotificationCreateResponse create(@RequestBody @Valid NotificationCreateRequest request) {
        Long createdNotificationId = notificationService.create(request.convertToNotification());
        return NotificationCreateResponse.builder().id(createdNotificationId).build();
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
