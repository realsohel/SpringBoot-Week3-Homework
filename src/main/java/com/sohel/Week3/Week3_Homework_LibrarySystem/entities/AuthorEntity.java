package com.sohel.Week3.Week3_Homework_LibrarySystem.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Data
@Table(name = "Authors")
public class AuthorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;


    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    private Set<BookEntity> books;

}
