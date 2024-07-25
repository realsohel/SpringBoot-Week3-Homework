package com.sohel.Week3.Week3_Homework_LibrarySystem.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.util.Objects;

@Entity
@Data
@Table(name = "Books")
public class BookEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;


    @Column(name = "published_On")
    @CreationTimestamp
    private LocalDate publishedOn;

    @UpdateTimestamp
    private LocalDate updatedOn;

    @ManyToOne
    @JoinColumn(name = "Book_written_by")
    @JsonIgnore
    private AuthorEntity author;

    @Override
    public boolean equals(Object obj) {
        if (this==obj)
            return true;
        if(!(obj instanceof BookEntity that))
            return false;

        return Objects.equals(getId(),that.getId()) && Objects.equals(getTitle(),that.getTitle());
    }

    @Override
    public int hashCode(){
        return Objects.hash(getId(),getTitle());
    }
}
