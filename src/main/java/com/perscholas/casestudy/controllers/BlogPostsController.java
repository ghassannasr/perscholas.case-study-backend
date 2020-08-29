package com.perscholas.casestudy.controllers;


import com.perscholas.casestudy.models.BlogPost;
import com.perscholas.casestudy.repositories.BlogPostRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blogposts")
public class BlogPostsController {

    @Autowired
    private BlogPostRepository blogPostRepository;

    @GetMapping
    public List<BlogPost> list() {
        return blogPostRepository.findAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    public BlogPost get(@PathVariable Long id) {
        return blogPostRepository.getOne(id);
    }

    @PostMapping
    //@ResponseStatus(HttpStatus.CREATED)
    public BlogPost create(@RequestBody final BlogPost blogPost) {
        return blogPostRepository.saveAndFlush(blogPost);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id) {
        //need to check for children records before deleting
        blogPostRepository.deleteById(id);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public BlogPost update(@PathVariable Long id, @RequestBody BlogPost blogPost) {
        BlogPost existingBlogPost = blogPostRepository.getOne(id);
        BeanUtils.copyProperties(blogPost, existingBlogPost, "id");
        return blogPostRepository.saveAndFlush(existingBlogPost);
    }
}
