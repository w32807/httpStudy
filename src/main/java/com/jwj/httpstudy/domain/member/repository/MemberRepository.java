package com.jwj.httpstudy.domain.member.repository;

import com.jwj.httpstudy.domain.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<MemberEntity, Long> {
}
