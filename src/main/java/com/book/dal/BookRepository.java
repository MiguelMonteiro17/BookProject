package com.book.dal;


import com.book.entity.BookEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<BookEntity,String> {
    
    BookEntity findById(Long id);

}