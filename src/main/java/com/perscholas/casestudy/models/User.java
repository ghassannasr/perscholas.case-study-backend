package com.perscholas.casestudy.models;

import javax.persistence.*;
import java.util.List;
import java.util.ArrayList;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @OneToMany(mappedBy = "blogposts")
    private List<BlogPost> posts = new ArrayList<BlogPost>();

    public List<BlogPost> getPosts() {
        return posts;
    }

    public void setPosts(List<BlogPost> posts) {
        this.posts = posts;
    }

    public User() {

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
