package com.jwj.httpstudy.web.book;

import com.jwj.httpstudy.domain.book.repository.BookRepository;
import com.jwj.httpstudy.domain.book.service.BookService;
import com.jwj.httpstudy.domain.entity.BookEntity;
import com.jwj.httpstudy.web.book.dto.BookRequestDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
public class BookApiController {
    // 화면 이동이 필요한 경우는 일반 Controller에서 작성한다.
    // todo 빠르게 끝낸 후, HTTP 상태코드 듣고, ExceptionHandler 다시 공부해서 적용하자
    private final BookService bookService;
    private final BookRepository bookRepository;

    // 1. Book 등록 (with ajax) - POST
    @PostMapping("/books")
    public ResponseEntity<Long> createBook(@RequestBody BookRequestDto dto){
        BookEntity entity = bookRepository.save(dto.toEntity());
        return new ResponseEntity(entity.getId(), HttpStatus.OK);
    }

    // 2. Book 수정 (with ajax) - PATCH
    @PatchMapping ("/books")
    public ResponseEntity<Long> editBook(@RequestBody BookRequestDto dto){
        BookEntity entity = bookRepository.save(dto.toEntity());
        return new ResponseEntity(entity.getId(), HttpStatus.OK);
    }

    // 3. Book 삭제 (with ajax) - DELETE
    @DeleteMapping("/books")
    public ResponseEntity<Long> deleteBook(@RequestParam("id") Long id){
        bookRepository.deleteById(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
