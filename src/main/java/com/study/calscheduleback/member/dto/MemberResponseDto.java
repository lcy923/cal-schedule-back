package com.study.calscheduleback.member.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class MemberResponseDto {

    private final String userId;
    private final String userName;

    @Builder
    public MemberResponseDto(String userId, String userName) {
        this.userId = userId;
        this.userName = userName;
    }
}
