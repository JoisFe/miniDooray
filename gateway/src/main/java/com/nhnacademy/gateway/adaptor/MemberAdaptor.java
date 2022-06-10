package com.nhnacademy.gateway.adaptor;

import com.nhnacademy.gateway.domain.Member;
import com.nhnacademy.gateway.dto.request.RegisterMemberRequestDto;

public interface MemberAdaptor {
    Member findByUsername(String username);

    Member makeOAuthMember(String email);

    String register(RegisterMemberRequestDto memberRequestDto);
}
