package com.nhnacademy.gateway.controller;

import com.nhnacademy.gateway.dto.request.MemberRequestDto;
import com.nhnacademy.gateway.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@RequiredArgsConstructor
@Controller
public class MemberController {
    private final MemberService memberService;

    @GetMapping("/register")
    public String goReigster() {
        return "register";
    }

    @PostMapping("/register")
    public String registerMember(MemberRequestDto memberRequestDto, Model model) {
        String message = memberService.register(memberRequestDto);

        model.addAttribute("message", message);
        return "redirect:/auth/login";
    }
}
