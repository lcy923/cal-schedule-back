package com.study.calscheduleback.main.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class MonthContentsResponseDto {

    private String content;
    private String isDone;
    private LocalDate contentDate;

    @Builder
    public MonthContentsResponseDto(String content, String isDone, LocalDate contentDate) {
        this.content = content;
        this.isDone = isDone;
        this.contentDate = contentDate;
    }
}
