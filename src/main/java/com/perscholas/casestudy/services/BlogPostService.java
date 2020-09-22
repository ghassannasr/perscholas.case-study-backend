package com.perscholas.casestudy.services;

import com.perscholas.casestudy.models.BlogPost;
import com.perscholas.casestudy.repositories.BlogPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BlogPostService {
    private BlogPostRepository repository;

    @Autowired
    public BlogPostService(BlogPostRepository repository) {
        this.repository = repository;
    }

    public Iterable<BlogPost> index() {
        return repository.findAll();
    }

    public BlogPost show(Long id) {
        return repository.findById(id).get();
    }

    public BlogPost create(BlogPost post) {
        return repository.save(post);
    }

    public BlogPost update(Long id, BlogPost newPostData) {
        BlogPost originalPost = repository.findById(id).get();
        originalPost.setTitle(newPostData.getTitle());
        originalPost.setBody(newPostData.getBody());
        originalPost.setDate(newPostData.getDate());
        //originalPost.setPostUserId(newPostData.getPostUserId());
        return repository.save(originalPost);
    }

    public Boolean delete(Long id) {
        repository.deleteById(id);
        return true;
    }
}
