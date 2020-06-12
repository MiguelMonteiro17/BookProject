package com.book.dto;

import com.book.entity.BookEntity;

public class BookDTO{
    private Long id;

    private String title;
    private String author;

    public BookDTO(){
        
    }

    public BookDTO(Long id, String title, String author){
        setId(id);
        setTitle(title);
        setAuthor(author);
    }

    public BookDTO(BookEntity book){
        setId(book.getId());
        setAuthor(book.getAuthor());
        setTitle(book.getTitle());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}