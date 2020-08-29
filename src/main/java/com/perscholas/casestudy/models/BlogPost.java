package com.perscholas.casestudy.models;

import org.springframework.context.annotation.ScopeMetadata;

import javax.persistence.*;
import javax.transaction.UserTransaction;

@Entity
@Table(name = "blogposts")
public class BlogPost {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // or .IDENTITY
    @Column(name = "id")
    private Long id;

    @Basic
    @Column(name = "text")
    private String text;

    @Basic
    @Column(name = "date")
    private String date;

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

