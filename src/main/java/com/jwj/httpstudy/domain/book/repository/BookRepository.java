package com.jwj.httpstudy.domain.book.repository;

import com.jwj.httpstudy.domain.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<BookEntity, Long> {
}
