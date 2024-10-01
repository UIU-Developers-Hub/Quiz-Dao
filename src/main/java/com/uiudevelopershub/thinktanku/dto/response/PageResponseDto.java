package com.uiudevelopershub.thinktanku.dto.response;

import com.uiudevelopershub.thinktanku.dto.request.QuizRequestDto;
import lombok.Data;

import java.util.List;

@Data
public class PageResponseDto {

    private List<QuizRequestDto>content;
    private int pageNo;
    private int pageSize;
    private int totalPages;
    private Long totalElements;
    private Boolean last;

}
