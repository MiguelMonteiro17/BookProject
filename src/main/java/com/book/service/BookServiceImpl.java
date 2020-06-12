package com.book.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import com.book.dal.BookRepository;
import com.book.entity.BookEntity;

import com.book.dto.BookDTO;
import java.util.List;
import java.util.stream.Collectors;


@Service
@Transactional
public class BookServiceImpl implements BookService{
    private final BookRepository bookRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<BookDTO> getAllBooks() {
        List<BookEntity> bookList = bookRepository.findAll();
        List<BookDTO> bookDTOList = bookList.stream().
                map(x -> new BookDTO(x.getId(), x.getTitle(), x.getAuthor()))
                .collect(Collectors.toList());
        return bookDTOList;
    }

    @Override
    public String getBookStats( Long id){
        final BookEntity book= bookRepository.findById(id);
        final String result="{ID : "+book.getId().toString()+",Title : "+book.getTitle()+",Author :"+ book.getAuthor()+" }";

        return result;
    }

    @Override
    public void createBook(BookDTO bookDTO){
        BookEntity book = new BookEntity(bookDTO.getTitle(), bookDTO.getAuthor());
        bookRepository.save(book);
    }
}