package com.sohel.Week3.Week3_Homework_LibrarySystem.controllers;

import com.sohel.Week3.Week3_Homework_LibrarySystem.entities.AuthorEntity;
import com.sohel.Week3.Week3_Homework_LibrarySystem.entities.BookEntity;
import com.sohel.Week3.Week3_Homework_LibrarySystem.services.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("")
    public List<BookEntity> getAllBooks(){
        return bookService.getAllBooks();
    }

    @GetMapping("/{bookId}")
    public BookEntity getBookById(@PathVariable Long bookId){
        return bookService.getBookById(bookId);
    }

    @PostMapping("")
    public BookEntity addBook(@RequestBody BookEntity book){
        return bookService.addBook(book);
    }

    @PutMapping("/{bookId}")
    public BookEntity updateBook(@RequestBody BookEntity book, @PathVariable Long bookId){
        return bookService.updateBook(book,bookId);
    }

    @DeleteMapping("/{bookId}")
    public void deleteBook(@PathVariable Long bookId){
        bookService.deleteBook(bookId);
    }

    @GetMapping("/title")
    public BookEntity findBookByTitle(@RequestParam String title){
        return bookService.findBookByTitle(title);
    }
}
