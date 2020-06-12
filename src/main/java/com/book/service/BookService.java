package com.book.service;

import com.book.dto.BookDTO;
import com.book.exceptions.BookNotFoundException;

import java.util.List;

public interface BookService{

    public List<BookDTO> getAllBooks();

    /**
     * This method will return the book information
     * 
     * @param id the id of the book
     * @return returns a string containg the book information.
     * @throws BookNotFoundException throws this exception when it does not find any book with this ID.
     */
    public BookDTO getBookByID(Long id) throws BookNotFoundException;

    /**
     * This method attemps to create a book when receiving a object {@link BookDTO}.
     * 
     * @param book {@link BookDTO} 
     * @return returns a {@link BookDTO} with all information created in Book
     */
    public BookDTO createBook(BookDTO book);


    /**
     * This method attemps to update a Book enttity when receiving a object {@link BookDTO}
     * @param book {@BookDTO} object containing the updated fields.
     */
    //public void updateBook(BookDTO book);
}