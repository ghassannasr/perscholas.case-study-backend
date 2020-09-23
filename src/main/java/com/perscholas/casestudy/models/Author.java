package com.perscholas.casestudy.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "author")
//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "type")
    private String type;

//    @OneToMany(mappedBy = "author", cascade = {
//            CascadeType.ALL
//    })
//    private List < BlogPost > blogPosts;

//    @OneToMany(cascade = CascadeType.ALL) //uncommented all these lines
//    @ElementCollection
    //@JoinColumn(name = "author_id", referencedColumnName = "id") //GN uncommented this line
    //private List<BlogPost> blogPosts = new ArrayList<BlogPost>();

//    public List<BlogPost> getBlogPosts() {
//        return blogPosts;
//    }
//
//    public void setBlogPosts(List<BlogPost> blogPosts) {
//        this.blogPosts = blogPosts;
//    }


    public Author() {

    }

//    public Author(String firstName, String lastName, String type) {
//        this(null, firstName, lastName, type);
//    }

    public Author(String firstName, String lastName, String type) {
        //this.id = id;
        //super();
        this.firstname = firstName;
        this.lastname = lastName;
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

//    public String getFirstName() {
//        return firstname;
//    }
//
//    public void setFirstName(String firstName) {
//        this.firstname = firstName;
//    }
//
//    public String getLastName() {
//        return lastname;
//    }
//
//    public void setLastName(String lastName) {
//        this.lastname = lastName;
//    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
