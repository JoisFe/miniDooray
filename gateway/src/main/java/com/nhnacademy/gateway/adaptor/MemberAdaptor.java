package com.nhnacademy.gateway.adaptor;

import com.nhnacademy.gateway.domain.Member;
import com.nhnacademy.gateway.dto.request.MemberRequestDto;

public interface MemberAdaptor {
    Member findByUsername(String username);

    Member makeOAuthMember(String email);

    String register(MemberRequestDto memberRequestDto);
}
