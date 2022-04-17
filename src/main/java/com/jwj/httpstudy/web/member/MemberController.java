package com.jwj.httpstudy.web.member;

import com.jwj.httpstudy.domain.entity.MemberEntity;
import com.jwj.httpstudy.domain.member.repository.MemberRepository;
import com.jwj.httpstudy.domain.member.service.MemberService;
import com.jwj.httpstudy.web.member.dto.MemberRequestDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
@RequiredArgsConstructor
// HTML FORM, 컨트롤URI를 이용한 API 설계
public class MemberController {

    private final MemberService memberService;
    private final MemberRepository memberRepository;


    // 1. 멤버 리스트 조회 - GET
    @GetMapping("/members")
    public String members(Model model){
        model.addAttribute("members", memberService.findAll());
        return "member/members";
    }

    // 2. 멤버 1명 조회 - GET
    @GetMapping("/members/{id}")
    public String searchMembers(@PathVariable("id") Long id, Model model){
        model.addAttribute("member", memberService.findById(id));
        return "member/member";
    }

    // 3. 멤버 등록 폼 - GET
    @GetMapping("/members/create")
    public String membersCreateForm(Model model){
        model.addAttribute("dto", new MemberRequestDto());
        return "member/joinForm";
    }

    // 4. 멤버 등록 - POST
    @PostMapping("/members/create")
    public String membersCreate(MemberRequestDto dto){
        MemberEntity entity = memberRepository.save(dto.toEntity());
        return "redirect:/members/" + entity.getId(); // PRG 패턴 사용
    }

    // 5. 멤버 수정 폼 -> GET
    @GetMapping("/members/{id}/edit")
    public String membersEditForm(@PathVariable("id") Long id, Model model){
        model.addAttribute("member", memberService.findById(id));
        return "member/editForm";
    }

    // 6. 멤버 수정 -> PATCH
    @PostMapping("/members/{id}/edit")
    public String membersEdit(MemberRequestDto dto, @PathVariable("id") Long id){
        memberService.save(dto, id);
        return "redirect:/members/" + id; // PRG 패턴 사용
    }

    // 7. 멤버 삭제 -> DELETE
    @PostMapping("/members/{id}/delete")
    public String membersDelete(@PathVariable("id") Long id){
        memberRepository.deleteById(id);
        return "redirect:/members/";
    }

}
