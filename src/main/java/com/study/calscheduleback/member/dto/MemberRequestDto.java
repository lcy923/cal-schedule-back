package com.study.calscheduleback.member.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class MemberRequestDto {
    private String userId;
    private String userPw;

    @Builder
    public MemberRequestDto(String userId, String userPw) {
        this.userId = userId;
        this.userPw = userPw;
    }

}
