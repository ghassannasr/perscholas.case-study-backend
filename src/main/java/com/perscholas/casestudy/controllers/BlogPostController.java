package com.perscholas.casestudy.controllers;


import com.perscholas.casestudy.models.BlogPost;
import com.perscholas.casestudy.models.User;
import com.perscholas.casestudy.repositories.BlogPostRepository;
import com.perscholas.casestudy.services.BlogPostService;
import com.perscholas.casestudy.services.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blogposts")
@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
public class BlogPostController {

    @Autowired
    private BlogPostService blogPostService;

    public BlogPostController(BlogPostService blogPostService) {
        this.blogPostService = blogPostService;
    }

    @RequestMapping(value = "/show-all", method = RequestMethod.GET)
    public ResponseEntity<Iterable<BlogPost>> index() {
        return new ResponseEntity<>(blogPostService.index(), HttpStatus.OK);
    }

    @GetMapping(value = "/get-blogpost/{id}")
    public ResponseEntity<BlogPost> get(@PathVariable Long id) {
        return new ResponseEntity<>(blogPostService.show(id), HttpStatus.OK);
    }

    @RequestMapping(value = "/create-blogpost", method = RequestMethod.POST)
    public ResponseEntity<BlogPost> create(@RequestBody BlogPost post) {
        return new ResponseEntity<>(blogPostService.create(post), HttpStatus.CREATED);
    }


    @RequestMapping(value = "/delete-blogpost/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Boolean> delete(@PathVariable Long id) {
        //need to check for children records before deleting
        return new ResponseEntity<>(blogPostService.delete(id), HttpStatus.OK);
    }

    @RequestMapping(value = "/update-user/{id}", method = RequestMethod.PUT)
    public ResponseEntity<BlogPost> update(@PathVariable Long id, @RequestBody BlogPost post) {
        return new ResponseEntity<>(blogPostService.update(id, post), HttpStatus.OK);
    }
}