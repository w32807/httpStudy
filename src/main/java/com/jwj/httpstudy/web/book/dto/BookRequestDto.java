package com.jwj.httpstudy.web.book.dto;

import com.jwj.httpstudy.domain.entity.BookEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class BookRequestDto {

    private String title;

    private int price;

    public BookEntity toEntity(){
        return BookEntity.builder()
                .title(this.title)
                .price(this.price)
                .build();
    }

}
