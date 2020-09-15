package com.perscholas.casestudy.controllers;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.perscholas.casestudy.models.User;
import com.perscholas.casestudy.repositories.UserRepository;
import com.perscholas.casestudy.services.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
public class UserController {

    @Autowired
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/show-all", method = RequestMethod.GET)
    public ResponseEntity<Iterable<User>> index() {
        return new ResponseEntity<>(userService.index(), HttpStatus.OK);
    }

    @GetMapping(value = "/get-user/{id}")
    public ResponseEntity<User> get(@PathVariable Long id) {
        return new ResponseEntity<>(userService.show(id), HttpStatus.OK);
    }

    @RequestMapping(value = "/create-user", method = RequestMethod.POST)
    public ResponseEntity<User> create(@RequestBody User user) {
        return new ResponseEntity<>(userService.create(user), HttpStatus.CREATED);
    }


    @RequestMapping(value = "/delete-user/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Boolean> delete(@PathVariable Long id) {
        //need to check for children records before deleting
        return new ResponseEntity<>(userService.delete(id), HttpStatus.OK);
    }

    @RequestMapping(value = "/update-user/{id}", method = RequestMethod.PUT)
    public ResponseEntity<User> update(@PathVariable Long id, @RequestBody User user) {
        return new ResponseEntity<>(userService.update(id, user), HttpStatus.OK);
    }
}
