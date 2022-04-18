package com.jwj.httpstudy.web.book.dto;

import lombok.*;

@Data
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookResponseDto {

    private Long id;

    private String title;

    private int price;

}
