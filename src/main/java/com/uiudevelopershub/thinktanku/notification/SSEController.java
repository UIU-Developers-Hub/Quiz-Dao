package com.uiudevelopershub.thinktanku.notification;

import com.uiudevelopershub.thinktanku.model.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class SSEController {
    private final SSEService<User> sseService;

    @PreAuthorize("hasAnyRole('Admin')")
    @GetMapping(value = "Subscribe", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<User> subscribe() {
        return sseService.subscribe();
    }
}
