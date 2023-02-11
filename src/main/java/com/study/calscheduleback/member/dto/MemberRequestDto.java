package com.study.calscheduleback.member.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class MemberRequestDto {
    private String userId;
    private String userPw;
    private String userName;
    private String userEmail;
    private String userStatus;
    private String contentDate;

    @Builder
    public MemberRequestDto(
            String userId, String userPw, String userName,
            String userEmail, String userStatus, String contentDate
    ) {
        this.userId = userId;
        this.userPw = userPw;
        this.userName = userName;
        this.userEmail = userEmail;
        this.userStatus = userStatus;
        this.contentDate = contentDate;
    }
}
