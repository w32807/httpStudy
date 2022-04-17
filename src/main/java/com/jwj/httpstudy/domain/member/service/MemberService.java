package com.jwj.httpstudy.domain.member.service;

import com.jwj.httpstudy.web.member.dto.MemberRequestDto;
import com.jwj.httpstudy.web.member.dto.MemberResponseDto;

import java.util.List;

public interface MemberService {
    List<MemberResponseDto> findAll();
    MemberResponseDto findById(Long id);
    Long save(MemberRequestDto dto, Long id);
}
