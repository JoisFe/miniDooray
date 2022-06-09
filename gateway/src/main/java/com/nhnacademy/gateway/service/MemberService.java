package com.nhnacademy.gateway.service;

import com.nhnacademy.gateway.domain.Member;
import com.nhnacademy.gateway.dto.request.MemberRequestDto;
import com.nhnacademy.gateway.vo.SecurityUser;

public interface MemberService {
    SecurityUser makeOAuthMemberByEmail(String email);

    String register(MemberRequestDto memberRequestDto);
}
