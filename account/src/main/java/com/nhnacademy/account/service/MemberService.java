package com.nhnacademy.account.service;

import com.nhnacademy.account.dto.request.MemberRequestDto;
import com.nhnacademy.account.dto.respond.MemberRespondDto;
import com.nhnacademy.account.entity.Member;
import java.util.Optional;

public interface MemberService {
    Optional<MemberRespondDto> getMemberByMemberId(String memberId);

    Optional<MemberRespondDto> findMemberHaveEmail(String email);

    String register(MemberRequestDto memberRequestDto);
}
