package com.book.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import com.book.dal.BookRepository;
import com.book.entity.BookEntity;
import com.book.exceptions.BookNotFoundException;
import com.book.dto.BookDTO;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@Transactional
public class BookServiceImpl implements BookService{
    private final BookRepository bookRepository;

    @Autowired
    public BookServiceImpl(final BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<BookDTO> getAllBooks() {
        final List<BookEntity> bookList = bookRepository.findAll();
        final List<BookDTO> bookDTOList = bookList.stream()
                .map(x -> new BookDTO(x.getId(), x.getTitle(), x.getAuthor())).collect(Collectors.toList());
        return bookDTOList;
    }

    @Override
    public BookDTO getBookByID( final Long id) throws BookNotFoundException{
        final BookEntity book= bookRepository.findById(id);
        if(book != null){
            final BookDTO bookDTO = new BookDTO(book.getId(), book.getTitle(), book.getAuthor());
            return bookDTO;
        }else{
            throw new BookNotFoundException();
        }
        
    }

    @Override
    public BookDTO createBook(final BookDTO bookDTO) {
        BookEntity book = new BookEntity(bookDTO.getTitle(), bookDTO.getAuthor());
        book = bookRepository.save(book);
        return new BookDTO(book);
    }
}