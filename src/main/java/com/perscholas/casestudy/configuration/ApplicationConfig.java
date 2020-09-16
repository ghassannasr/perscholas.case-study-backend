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
import java.util.Date;

@Configuration
public class ApplicationConfig {

    @Autowired
    private BlogPostRepository blogPostRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @PostConstruct
    public void setup() {
        Author ghassan = new Author("Ghassan", "Nasr", "admin");
        Author adnan = new Author("Adnan", "Nasr", "user");

        BlogPost post1 = new BlogPost("This is my first post", new Date().toString(), ghassan);
        BlogPost post2 = new BlogPost("This is my second post", new Date().toString(), ghassan);
        BlogPost post3 = new BlogPost("This is a post from Adnan", new Date().toString(), adnan);

        authorRepository.save(ghassan);
        authorRepository.save(adnan);

        blogPostRepository.save(post1);
        blogPostRepository.save(post2);
        blogPostRepository.save(post3);
    }

}

