package com.sohel.Week3.Week3_Homework_LibrarySystem.repositories;

import com.sohel.Week3.Week3_Homework_LibrarySystem.entities.AuthorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<AuthorEntity,Long> {
    AuthorEntity findByName(String name);
}
