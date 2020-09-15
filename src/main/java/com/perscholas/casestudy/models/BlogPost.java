package com.perscholas.casestudy.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "blogpost")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class BlogPost {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) // or .IDENTITY
    @Column(name = "id")
    private Long id;

    @Basic
    @Column(name = "text")
    private String text;

    @Basic
    @Column(name = "date")
    private String date;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "author_id")
    private Author author;

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public BlogPost(String text, String date) {
        this.text = text;
        this.date = date;
    }

    public BlogPost(Long id, String text, String date) {
        this.id = id;
        this.text = text;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public BlogPost() {

    }
}

