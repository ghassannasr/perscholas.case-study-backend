package com.perscholas.casestudy.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;

@Entity
@Table(name = "user")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Basic
    @Column(name = "firstname")
    private String firstName;

    @Basic
    @Column(name = "lastname")
    private String lastName;

    @Basic
    @Column(name = "type")
    private String type;

    @OneToMany(mappedBy = "user", cascade = {
            CascadeType.ALL
    })
    private List < BlogPost > blogPosts;

    public List<BlogPost> getBlogPosts() {
        return blogPosts;
    }

    public void setBlogPosts(List<BlogPost> blogPosts) {
        this.blogPosts = blogPosts;
    }
//    public void setBlogPosts(Set<BlogPost> blogPosts) {
//        this.blogPosts = blogPosts;
//    }

    //    @OneToMany(mappedBy = "blogpost")
//    private List<BlogPost> posts = new ArrayList<BlogPost>();
//
//    public List<BlogPost> getPosts() {
//        return posts;
//    }
//
//    public void setPosts(List<BlogPost> posts) {
//        this.posts = posts;
//    }

    public User() {

    }

    public User(String firstName, String lastName, String type) {
        this(null, firstName, lastName, type);
    }

    public User(Long id, String firstName, String lastName, String type) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
