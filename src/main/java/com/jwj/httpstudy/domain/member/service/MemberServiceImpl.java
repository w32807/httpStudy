package com.jwj.httpstudy.domain.member.service;

import com.jwj.httpstudy.domain.entity.MemberEntity;
import com.jwj.httpstudy.domain.member.repository.MemberRepository;
import com.jwj.httpstudy.web.member.dto.MemberRequestDto;
import com.jwj.httpstudy.web.member.dto.MemberResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.List;

import static com.jwj.httpstudy.utils.JSONReadUtils.readJSONList;
import static java.util.stream.Collectors.toList;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional
public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository;
    
    @PostConstruct
    public void init(){
        String filePath = "initData/memberInitData.json";
        List<MemberRequestDto> list = readJSONList(filePath, MemberRequestDto.class);
        list.stream().forEach(dto -> memberRepository.save(dto.toEntity()));
    }

    @Override
    public List<MemberResponseDto> findAll() {
        List<MemberEntity> entities = memberRepository.findAll();
        return entities.stream().map(entity -> entity.toDto()).collect(toList());
    }

    @Override
    public MemberResponseDto findById(Long id) {
        return memberRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException())
                .toDto();
    }

    @Override
    public Long save(MemberRequestDto dto, Long id) {
        MemberEntity entity = memberRepository.findById(id).orElseThrow(() -> new IllegalArgumentException());
        entity.setName(dto.getName());
        entity.setAge(dto.getAge());
        return entity.getId();
    }
}
