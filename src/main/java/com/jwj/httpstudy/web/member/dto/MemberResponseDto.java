package com.jwj.httpstudy.web.member.dto;

import lombok.*;

@Data
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MemberResponseDto {

    private Long id;

    private String name;

    private int age;

}
