package com.sohel.Week3.Week3_Homework_LibrarySystem.controllers;

import com.sohel.Week3.Week3_Homework_LibrarySystem.entities.AuthorEntity;
import com.sohel.Week3.Week3_Homework_LibrarySystem.services.AuthorService;
import com.sohel.Week3.Week3_Homework_LibrarySystem.services.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/authors")
public class AuthorController {

    private final AuthorService authorService;
    private final BookService bookService;

    public AuthorController(AuthorService authorService, BookService bookService) {
        this.authorService = authorService;
        this.bookService = bookService;
    }

    @GetMapping("")
    public List<AuthorEntity> getAllAuthors(){
        return authorService.getAllAuthors();
    }

    @GetMapping("/{authorId}")
    public AuthorEntity getAuthorById(@PathVariable Long authorId){
        return authorService.getAuthorById(authorId);
    }

    @PostMapping("")
    public AuthorEntity createAuthor(@RequestBody AuthorEntity author){
        return authorService.createAuthor(author);
    }

    @PatchMapping("/{authorId}")
    public AuthorEntity updateAuthor(@RequestBody Map<String, Object> updates, @PathVariable Long authorId){
        return authorService.updateAuthor(updates,authorId);
    }

    @DeleteMapping("/{authorId}")
    public void deleteAuthor(@PathVariable Long authorId){
         authorService.deleteAuthor(authorId);
    }

    @GetMapping("/name")
    public AuthorEntity getAuthorByName(@RequestParam String name){
        return authorService.getAuthorByName(name);
    }

    @PutMapping("/{authorId}/wrote/{bookId}")
    public AuthorEntity assignAuthorToBook(@PathVariable Long authorId,@PathVariable Long bookId ){
        return authorService.assignAuthorToBook(authorId,bookId);

    }

}
