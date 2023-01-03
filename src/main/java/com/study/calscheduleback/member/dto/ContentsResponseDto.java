package com.study.calscheduleback.member.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class ContentsResponseDto {
    private String userId;
    private String content;
    private String isDone;

    @Builder
    public ContentsResponseDto(String userId, String content, String isDone) {
        this.userId = userId;
        this.content = content;
        this.isDone = isDone;
    }
}
