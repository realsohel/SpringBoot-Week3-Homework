package com.sohel.Week3.Week3_Homework_LibrarySystem.services;


import com.sohel.Week3.Week3_Homework_LibrarySystem.entities.AuthorEntity;
import com.sohel.Week3.Week3_Homework_LibrarySystem.entities.BookEntity;
import com.sohel.Week3.Week3_Homework_LibrarySystem.repositories.AuthorRepository;
import com.sohel.Week3.Week3_Homework_LibrarySystem.repositories.BookRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class AuthorService {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public AuthorService(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    public List<AuthorEntity> getAllAuthors() {
        List<AuthorEntity>  author = authorRepository.findAll();
        return author;
    }

    public AuthorEntity createAuthor(AuthorEntity author) {
        System.out.println(author);
        return authorRepository.save(author);
    }

    public AuthorEntity getAuthorById(Long authorId) {
        Optional<AuthorEntity> author = authorRepository.findById(authorId);

        return author.orElse(null);
    }

    public void deleteAuthor(Long authorId) {
        authorRepository.deleteById(authorId);

    }

    public AuthorEntity updateAuthor(Map<String, Object> updates, Long authorId) {
        AuthorEntity author = authorRepository.findById(authorId).get();

        updates.forEach((field,value)->{
            Field updateField = ReflectionUtils.findField(AuthorEntity.class, field);
            if (updateField != null) {
                updateField.setAccessible(true);
                ReflectionUtils.setField(updateField, author, value);
            }

        });
        return authorRepository.save(author);
    }

    public AuthorEntity getAuthorByName(String name) {
        return authorRepository.findByName(name);
    }

    public AuthorEntity assignAuthorToBook(Long authorId, Long bookId) {
        Optional<AuthorEntity> authorEntity = authorRepository.findById(authorId);
        Optional<BookEntity> bookEntity = bookRepository.findById(bookId);

        return authorEntity.flatMap(author->
                bookEntity.map(book->{
                    book.setAuthor(author);
                    bookRepository.save(book);
                    author.getBooks().add(book);

                    return authorRepository.save(author);

                })
        ).orElse(null);


    }
}
