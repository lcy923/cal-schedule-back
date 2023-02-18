package com.study.calscheduleback.main.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
public class MonthContentsRequestDto {

    private String userId;
    private String contentDate;

    @Builder
    public MonthContentsRequestDto(String userId, String contentDate) {
        this.userId = userId;
        this.contentDate = contentDate;
    }
}
