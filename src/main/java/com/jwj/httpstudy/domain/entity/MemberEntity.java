package com.jwj.httpstudy.domain.entity;

import com.jwj.httpstudy.web.member.dto.MemberResponseDto;
import lombok.*;

import javax.persistence.*;

@Data
@EqualsAndHashCode
@Entity
@Builder
@Table(name = "MEMBER")
@NoArgsConstructor
@AllArgsConstructor
public class MemberEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private int age;

    public MemberResponseDto toDto(){
        return MemberResponseDto.builder()
                .id(this.id)
                .name(this.name)
                .age(this.age)
                .build();
    }
}
