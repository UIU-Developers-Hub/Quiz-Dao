package com.uiudevelopershub.thinktanku.dto.response;

import lombok.Data;

@Data
public class UserCorrectAnswerResponse {
    private Long userId;
    private String userName;
    private Long correctCount;

    public UserCorrectAnswerResponse(Long userId,String userName, Long correctCount) {
        this.userId = userId;
        this.userName = userName;
        this.correctCount = correctCount;
    }

    // Getters and Setters
}
