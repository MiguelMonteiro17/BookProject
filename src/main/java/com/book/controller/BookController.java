package com.book.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.book.dto.BookDTO;
import com.book.service.BookServiceImpl;
import java.util.List;

@Controller
@RequestMapping(path = "/book")
@ResponseBody
public class BookController {
    private final BookServiceImpl bookService;

    @Autowired
    public BookController(final BookServiceImpl bookService) {
        this.bookService = bookService;
    }

    @RequestMapping(produces= MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    public ResponseEntity<List<BookDTO>> getAllBooks(){
        return  ResponseEntity.ok(bookService.getAllBooks());
    }

    @RequestMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE, method= RequestMethod.GET)
    public ResponseEntity<String> onResRequest(@PathVariable("id") final String id){
        final Long Id = Long.parseLong(id);
        return ResponseEntity.ok(bookService.getBookStats(Id));
        //return ResponseEntity.ok("Hello Books!");
    }

    @RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE, method= RequestMethod.POST)
    public ResponseEntity<String> createBook(@RequestBody BookDTO bookDTO){
        bookService.createBook(bookDTO);
        return ResponseEntity.ok("");
    }
}