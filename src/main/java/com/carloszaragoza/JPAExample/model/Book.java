package com.carloszaragoza.JPAExample.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity(name="Book")
@Table(name="book")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Book {

    @Id
    @SequenceGenerator(
            name = "book_sequence",
            sequenceName= "book_sequence",
            allocationSize=1)
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator="book_sequence")
    @Column(
            name="id",
            updatable = false)
    private Long id;

    @Column(
            name="created_at",
            nullable=false,
            columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private LocalDateTime createdAt;

    @Column(
            name = "book_name",
            nullable = false)
    private String bookName;

    @ManyToOne
    @JoinColumn(
            name = "student_id",
            nullable = false,
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name = "student_book_fk"))
    private Student student;

    public Book(String bookName,LocalDateTime createdAt) {
        this.createdAt = createdAt;
        this.bookName = bookName;
    }
}
