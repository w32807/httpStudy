package com.jwj.httpstudy.web.member;

import com.jwj.httpstudy.domain.member.repository.MemberRepository;
import com.jwj.httpstudy.domain.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;

@Slf4j
@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;
    private final MemberRepository memberRepository;

}
