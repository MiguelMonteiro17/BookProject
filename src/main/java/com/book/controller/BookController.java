package com.book.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.book.service.BookService;

@Controller
@RequestMapping(path = "/book")
@ResponseBody
public class BookController {
    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }
    @RequestMapping(value = "data", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> onResRequest(@RequestParam(value = "id") String id){
        Long Id = Long.parseLong(id);
        return ResponseEntity.ok(bookService.getBookStats(Id));
    }
}