package com.study.calscheduleback.member.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class MemberRequestDto {
    private String userId;
    private String userPw;
    private String userName;
    private String userEmail;
    private String userStatus;

    @Builder
    public MemberRequestDto(String userId, String userPw, String userName, String userEmail, String userStatus) {
        this.userId = userId;
        this.userPw = userPw;
        this.userName = userName;
        this.userEmail = userEmail;
        this.userStatus = userStatus;
    }
}
