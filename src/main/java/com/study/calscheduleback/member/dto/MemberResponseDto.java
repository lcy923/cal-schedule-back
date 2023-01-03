package com.study.calscheduleback.member.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class MemberResponseDto {

    private final String user_id;
    private final String user_name;

    @Builder
    public MemberResponseDto(String userId, String userName) {
        this.user_id = userId;
        this.user_name = userName;
    }
}
