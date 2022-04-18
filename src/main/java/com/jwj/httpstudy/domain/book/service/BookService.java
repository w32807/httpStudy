package com.jwj.httpstudy.domain.book.service;

import com.jwj.httpstudy.web.book.dto.BookRequestDto;
import com.jwj.httpstudy.web.book.dto.BookResponseDto;

import java.util.List;

public interface BookService {
    List<BookResponseDto> findAll();
    BookResponseDto findById(Long id);
    Long save(BookRequestDto dto, Long id);
}
