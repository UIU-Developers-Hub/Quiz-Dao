package com.uiudevelopershub.thinktanku.dto.request;

import org.springframework.web.multipart.MultipartFile;

public record QuizSessionRequestDto(
        String QuizSessionName,
        MultipartFile imageUrl
) {
}
