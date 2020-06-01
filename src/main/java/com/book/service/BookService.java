package com.book.service;

import com.book.dto.BookDTO;
import java.util.List;

public interface BookService{

    public List<BookDTO> getAllBooks();

    /**
     * This method will return the book information
     * 
     * @param id the id of the book
     * @return returns a string containg the book information.
     */
    public String getBookStats(Long id);

    /**
     * This method attemps to create a book when receiving a object {@link BookDTO}.
     * 
     * @param book {@link BookDTO} 
     */
    public void createBook(BookDTO book);
}