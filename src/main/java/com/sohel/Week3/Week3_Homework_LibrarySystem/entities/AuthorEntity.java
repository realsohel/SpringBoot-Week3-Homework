package com.sohel.Week3.Week3_Homework_LibrarySystem.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "Authors")
public class AuthorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;


    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    private Set<BookEntity> books;

    @Override
    public boolean equals(Object obj) {
        if (this==obj)
            return true;
        if(!(obj instanceof AuthorEntity that))
            return false;

        return Objects.equals(getId(),that.getId()) && Objects.equals(getName(),that.getName());
    }

    @Override
    public int hashCode(){
        return Objects.hash(getId(),getName());
    }
}
