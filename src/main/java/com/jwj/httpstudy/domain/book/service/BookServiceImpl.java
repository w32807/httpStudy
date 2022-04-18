package com.jwj.httpstudy.domain.book.service;

import com.jwj.httpstudy.domain.book.repository.BookRepository;
import com.jwj.httpstudy.domain.entity.BookEntity;
import com.jwj.httpstudy.web.book.dto.BookRequestDto;
import com.jwj.httpstudy.web.book.dto.BookResponseDto;
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
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    
    @PostConstruct
    public void init(){
        String filePath = "initData/bookInitData.json";
        List<BookRequestDto> list = readJSONList(filePath, BookRequestDto.class);
        list.stream().forEach(dto -> bookRepository.save(dto.toEntity()));
    }

    @Override
    public List<BookResponseDto> findAll() {
        List<BookEntity> entities = bookRepository.findAll();
        return entities.stream().map(entity -> entity.toDto()).collect(toList());
    }

    @Override
    public BookResponseDto findById(Long id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException())
                .toDto();
    }

    @Override
    public Long save(BookRequestDto dto, Long id) {
        BookEntity entity = bookRepository.findById(id).orElseThrow(() -> new IllegalArgumentException());
        entity.setTitle(dto.getTitle());
        entity.setPrice(dto.getPrice());
        return entity.getId();
    }
}
