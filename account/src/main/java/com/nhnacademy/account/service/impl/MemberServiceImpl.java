package com.nhnacademy.account.service.impl;

import com.nhnacademy.account.dto.request.MemberRequestDto;
import com.nhnacademy.account.dto.respond.MemberRespondDto;
import com.nhnacademy.account.entity.Member;
import com.nhnacademy.account.repository.MemberRepository;
import com.nhnacademy.account.service.MemberService;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MemberServiceImpl implements MemberService {
    private final MemberRepository memberRepository;

    @Override
    public Optional<MemberRespondDto> getMemberByMemberId(String memberId) {
        return Optional.ofNullable(memberRepository.findByMemberId(memberId));
    }

    @Override
    public Optional<MemberRespondDto> findMemberHaveEmail(String email) {
        return Optional.ofNullable(memberRepository.findByMemberEmail(email));
    }

    @Override
    public String register(MemberRequestDto memberRequestDto) {
        Member member = Member.builder()
            .memberId(memberRequestDto.getMemberId())
            .memberPassword(memberRequestDto.getMemberPassword())
            .memberEmail(memberRequestDto.getMemberEmail())
            .memberGrade(memberRequestDto.getMemberGrade())
            .build();

        memberRepository.save(member);

        return "회원가입 되었습니다.";
    }
}
