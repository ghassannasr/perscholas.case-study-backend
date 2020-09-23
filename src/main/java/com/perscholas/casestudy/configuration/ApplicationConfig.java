package com.perscholas.casestudy.configuration;

import com.perscholas.casestudy.models.Author;
import com.perscholas.casestudy.models.BlogPost;
import com.perscholas.casestudy.repositories.AuthorRepository;
import com.perscholas.casestudy.repositories.BlogPostRepository;
import com.perscholas.casestudy.services.AuthorService;
import com.perscholas.casestudy.services.BlogPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.Date;

//@Configuration
public class ApplicationConfig {

//    @Autowired
//    private BlogPostRepository blogPostRepository;
//
//    @Autowired
//    private AuthorRepository authorRepository;

    @PostConstruct
    public void setup() {

//        Author ghassan = new Author("Ghassan", "Nasr", "admin");
//
//        ghassan = authorRepository.save(ghassan);
//
//        BlogPost post1 = new BlogPost("First Post", "This is my first post", new Date().toString(), ghassan.getId());
//        BlogPost post2 = new BlogPost("Second Post","This is my second post", new Date().toString(), ghassan.getId());
//
//        blogPostRepository.save(post1);
//        blogPostRepository.save(post2);
    }

}

