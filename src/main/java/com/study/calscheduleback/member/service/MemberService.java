package com.study.calscheduleback.member.service;

import com.study.calscheduleback.member.dto.MemberRequestDto;
import com.study.calscheduleback.member.dto.MemberResponseDto;
import com.study.calscheduleback.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final String NAME_SPACE = "mybatis.mapper.member.";

    private final MemberRepository memberRepository;


    public MemberResponseDto loginCheck(MemberRequestDto memberRequestDto) {
        return memberRepository.selectOne(NAME_SPACE + "selectMember", memberRequestDto);
    }

    public int signUp(MemberRequestDto memberRequestDto) {
        return memberRepository.insert(NAME_SPACE + "insertMember", memberRequestDto);
    }


}
