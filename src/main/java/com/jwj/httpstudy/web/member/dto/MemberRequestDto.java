package com.jwj.httpstudy.web.member.dto;

import com.jwj.httpstudy.domain.entity.MemberEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class MemberRequestDto {

    private String name;

    private int age;

    public MemberEntity toEntity(){
        return MemberEntity.builder()
                .name(this.name)
                .age(this.age)
                .build();
    }

}
