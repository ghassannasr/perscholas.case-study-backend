package com.perscholas.casestudy.controllers;

import com.perscholas.casestudy.models.Author;
import com.perscholas.casestudy.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/authors")
//@CrossOrigin(origins = "http://3.22.118.142:3000", maxAge = 3600)
@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @RequestMapping(value = "/show-all", method = RequestMethod.GET)
    public ResponseEntity<Iterable<Author>> index() {
        return new ResponseEntity<>(authorService.index(), HttpStatus.OK);
    }

    @GetMapping(value = "/get-author/{id}")
    public ResponseEntity<Author> get(@PathVariable Long id) {
        return new ResponseEntity<>(authorService.show(id), HttpStatus.OK);
    }

    @RequestMapping(value = "/create-author", method = RequestMethod.POST)
    public ResponseEntity<Author> create(@RequestBody Author author) {
        return new ResponseEntity<>(authorService.create(author), HttpStatus.CREATED);
    }


    @RequestMapping(value = "/delete-author/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Boolean> delete(@PathVariable Long id) {
        //need to check for children records before deleting
        return new ResponseEntity<>(authorService.delete(id), HttpStatus.OK);
    }

    @RequestMapping(value = "/update-author/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Author> update(@PathVariable Long id, @RequestBody Author author) {
        return new ResponseEntity<>(authorService.update(id, author), HttpStatus.OK);
    }
}
