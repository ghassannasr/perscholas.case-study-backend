package com.perscholas.casestudy.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.context.annotation.ScopeMetadata;

import javax.persistence.*;
import javax.transaction.UserTransaction;

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

//    @Column(name="author-id")
//    private Long authorId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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

