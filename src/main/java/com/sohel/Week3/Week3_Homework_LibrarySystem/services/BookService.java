package com.sohel.Week3.Week3_Homework_LibrarySystem.services;

import com.sohel.Week3.Week3_Homework_LibrarySystem.entities.AuthorEntity;
import com.sohel.Week3.Week3_Homework_LibrarySystem.entities.BookEntity;
import com.sohel.Week3.Week3_Homework_LibrarySystem.repositories.BookRepository;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<BookEntity> getAllBooks() {
        List<BookEntity>  book = bookRepository.findAll();
        return book;
    }

    public BookEntity addBook(BookEntity book) {

        return bookRepository.save(book);
    }

    public BookEntity getBookById(Long bookId) {
        Optional<BookEntity> book = bookRepository.findById(bookId);
        return book.orElse(null);
    }

    public void deleteBook(Long bookId) {
        bookRepository.deleteById(bookId);
    }

    public BookEntity updateBook(BookEntity book, Long bookId) {
        book.setId(bookId);
        return bookRepository.save(book);
    }

    public BookEntity findBookByTitle(String title) {
        return bookRepository.findByTitle(title);
    }
}
