package com.study.calscheduleback.member.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.util.Date;

@Getter
public class ContentsRequestDto {
    private String userId;
    private String content;
    private String isDone;
    private Date createDate;
    private LocalDate contentDate;

    @Builder
    public ContentsRequestDto(String userId, String content, String isDone, Date createDate, String contentDate) {
        this.userId = userId;
        this.content = content;
        this.isDone = isDone;
        this.createDate = createDate;
        this.contentDate = LocalDate.parse(contentDate);
    }
}
