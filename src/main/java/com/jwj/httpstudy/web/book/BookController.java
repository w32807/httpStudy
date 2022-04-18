package com.jwj.httpstudy.web.book;

import com.jwj.httpstudy.domain.book.repository.BookRepository;
import com.jwj.httpstudy.domain.book.service.BookService;
import com.jwj.httpstudy.web.book.dto.BookRequestDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Slf4j
@Controller
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;
    private final BookRepository bookRepository;

    // 1. Book 전체 조회
    @GetMapping("/books")
    public String books(Model model){
        model.addAttribute("books", bookService.findAll());
        return "book/books";
    }

    // 2. Book 등록 폼 -> GET
    @GetMapping("/books/create")
    public String booksCreateForm(Model model){
        model.addAttribute("book", new BookRequestDto());
        return "book/createForm";
    }

    // 3. Book 조회 -> GET
    @GetMapping("/books/{id}")
    public String searchBook(@PathVariable("id") Long id, Model model){
        model.addAttribute("book", bookService.findById(id));
        return "book/book";
    }

    // 4. Book 수정 폼 -> GET
    @GetMapping("/books/{id}/edit")
    public String booksEditForm(@PathVariable("id") Long id, Model model){
        model.addAttribute("book", bookService.findById(id));
        return "book/editForm";
    }
}
