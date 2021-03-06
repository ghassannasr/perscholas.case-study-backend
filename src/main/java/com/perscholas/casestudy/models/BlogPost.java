package com.perscholas.casestudy.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedDate;
import org.w3c.dom.Text;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "blogpost")
//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class BlogPost {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // or .IDENTITY
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Lob
  @Column(name = "body", columnDefinition = "TEXT") //need column with unlimited capacity
//    @Column(name = "body")
    private String body;

    @Column(name = "date")
    private String date;

    @ManyToOne//(cascade = CascadeType.ALL) //GN uncommented these two lines.
    private Author author;

    public BlogPost() {

    }

    public BlogPost(String title, String body, String date, Author author) {
        this.title = title;
        this.body = body;
        this.date = date;
        this.author = author;
    }

    public BlogPost(Long id, String title, String body, String date, Author author) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.date = date;
        this.author = author;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

}

