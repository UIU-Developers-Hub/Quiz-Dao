package com.uiudevelopershub.thinktanku.dto.response;

import lombok.Data;

@Data
public class UserCorrectAnswerResponse {
    private Long userId;
    private Long correctCount;

    public UserCorrectAnswerResponse(Long userId, Long correctCount) {
        this.userId = userId;
        this.correctCount = correctCount;
    }

    // Getters and Setters
}
