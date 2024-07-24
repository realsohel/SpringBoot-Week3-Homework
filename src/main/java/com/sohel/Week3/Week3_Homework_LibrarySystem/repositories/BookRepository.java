package com.sohel.Week3.Week3_Homework_LibrarySystem.repositories;

import com.sohel.Week3.Week3_Homework_LibrarySystem.entities.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<BookEntity,Long> {
    BookEntity findByTitle(String title);
}
