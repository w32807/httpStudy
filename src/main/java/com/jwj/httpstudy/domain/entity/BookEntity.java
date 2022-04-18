package com.jwj.httpstudy.domain.entity;

import com.jwj.httpstudy.web.book.dto.BookResponseDto;
import lombok.*;

import javax.persistence.*;

@Data
@EqualsAndHashCode
@Entity
@Builder
@Table(name = "BOOK")
@NoArgsConstructor
@AllArgsConstructor
public class BookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;

    private int price;

    public BookResponseDto toDto(){
        return BookResponseDto.builder()
                .id(this.id)
                .title(this.title)
                .price(this.price)
                .build();
    }
}
