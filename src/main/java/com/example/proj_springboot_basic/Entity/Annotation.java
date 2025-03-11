package com.example.proj_springboot_basic.Entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Entity(name = "ant_annotation")
public class Annotation {

    @Id
    @Column(name = "ant_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ant_author")
    private String author;

    @Column(name = "ant_text")
    private String text;

    @Column(name = "ant_date_time")
    @CreationTimestamp
    private LocalDateTime dateTime;

    public Annotation(String author, String text) {
        this.author = author;
        this.text = text;
    }
}
