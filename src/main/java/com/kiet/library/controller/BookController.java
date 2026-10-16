package com.kiet.library.controller;


import com.kiet.library.model.Book;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController 
@RequestMapping("/books")
public class BookController {
    public List<Book> books = new ArrayList<>();
    @GetMapping
    public List<Book> getAllBooks(){
        return books;
    }
    @GetMapping("/{id}")
    public Book getBookById(@PathVariable int id){
        for(Book b:books){
            if(b.getBookId() == id){

            }
        }
    }
}
