package com.nhnacademy.account.dto.respond;

import com.nhnacademy.account.entity.MemberGrade;

public interface MemberRespondDto {
    Long getMemberNum();

    String getMemberId();

    String getMemberPassword();

    String getMemberGrade();

    String getMemberEmail();

    String getMemberState();
}
