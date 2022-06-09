package com.nhnacademy.gateway.service.impl;

import com.nhnacademy.gateway.adaptor.MemberAdaptor;
import com.nhnacademy.gateway.domain.Member;
import com.nhnacademy.gateway.domain.MemberGrade;
import com.nhnacademy.gateway.dto.request.MemberRequestDto;
import com.nhnacademy.gateway.service.MemberService;
import com.nhnacademy.gateway.vo.SecurityUser;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MemberServiceImpl implements MemberService {
    private final MemberAdaptor memberAdaptor;
    private final PasswordEncoder passwordEncoder;

    @Override
    public SecurityUser makeOAuthMemberByEmail(String email) {
        Member member = memberAdaptor.makeOAuthMember(email);

        SimpleGrantedAuthority simpleGrantedAuthority =
            new SimpleGrantedAuthority(member.getMemberGrade().toString());
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(simpleGrantedAuthority);

        SecurityUser securityUser = new SecurityUser(member.getMemberNum(), member.getMemberId(),
            member.getMemberPassword(),
            member.getMemberEmail(), authorities);

        Authentication
            authentication =
            new UsernamePasswordAuthenticationToken(member.getMemberEmail(),
                member.getMemberPassword(), authorities);

        SecurityContext securityContext = SecurityContextHolder.getContext();
        securityContext.setAuthentication(authentication);

        return securityUser;
    }

    @Override
    public String register(MemberRequestDto memberRequestDto) {
        memberRequestDto.setMemberPassword(
            passwordEncoder.encode(memberRequestDto.getMemberPassword()));

        memberRequestDto.setMemberGrade(MemberGrade.ROLE_USER.toString());

        return memberAdaptor.register(memberRequestDto);
    }
}
