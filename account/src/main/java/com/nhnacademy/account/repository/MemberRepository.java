package com.nhnacademy.account.repository;

import com.nhnacademy.account.dto.respond.MemberRespondDto;
import com.nhnacademy.account.entity.Member;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
    MemberRespondDto findByMemberId(String memberId); // 왜 dto랑 매핑이 안될까?

    MemberRespondDto findByMemberEmail(String email);
}

