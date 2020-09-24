package com.perscholas.casestudy.services;

import com.perscholas.casestudy.models.Author;
import com.perscholas.casestudy.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {
    private AuthorRepository repository;

    @Autowired
    public AuthorService(AuthorRepository repository) {
        this.repository = repository;
    }

    public Iterable<Author> index() {
        return repository.findAll();
    }

    public Author show(Long id) {
        return repository.findById(id).get();
    }

    public Author create(Author author) {
        return repository.save(author);
    }

    public Author update(Long id, Author newAuthorData) {
        Author originalAuthor = repository.findById(id).get();
        originalAuthor.setFirstname(newAuthorData.getFirstname());
        originalAuthor.setLastname(newAuthorData.getLastname());
        originalAuthor.setType(newAuthorData.getType());
        return repository.save(originalAuthor);
    }

    public Boolean delete(Long id) {
        repository.deleteById(id);
        return true;
    }

    public List<Author> findAuthorsByType(String type) {
        return repository.findAuthorsByType(type);
    }
}

