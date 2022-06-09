package com.nhnacademy.account.controller;

import com.nhnacademy.account.dto.request.MemberRequestDto;
import com.nhnacademy.account.dto.respond.MemberRespondDto;
import com.nhnacademy.account.entity.Member;
import com.nhnacademy.account.exception.NotFoundMemberException;
import com.nhnacademy.account.service.MemberService;
import java.util.Optional;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class MemberController {
    private final MemberService memberService;

    @GetMapping("/member")
    public Optional<MemberRespondDto> getMember(@RequestParam(value = "username") String memberId) {
        return memberService.getMemberByMemberId(memberId);
    }

    @GetMapping("/member/exist")
    public Optional<MemberRespondDto> checkMemberHaveEmail(@RequestParam(value = "email") String email) {
        return memberService.findMemberHaveEmail(email);
    }

    @PostMapping("/member/register")
    public String registerMember(@RequestBody MemberRequestDto memberRequestDto) {
        return memberService.register(memberRequestDto);
    }
}
