package com.study.calscheduleback.member.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.Date;

@Getter
public class ContentsRequestDto {
    private String userId;
    private String content;
    private String isDone;
    private Date createDate;

    @Builder
    public ContentsRequestDto(String userId, String content, String isDone, Date createDate) {
        this.userId = userId;
        this.content = content;
        this.isDone = isDone;
        this.createDate = createDate;
    }
}
