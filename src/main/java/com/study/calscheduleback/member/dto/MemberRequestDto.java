package com.study.calscheduleback.member.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class MemberRequestDto {
    private String userid;
    private String userpw;

    @Builder
    public MemberRequestDto(String userid, String userpw) {
        this.userid = userid;
        this.userpw = userpw;
    }

}
