package com.perscholas.casestudy.controllers;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.perscholas.casestudy.models.User;
import com.perscholas.casestudy.repositories.UserRepository;
import com.perscholas.casestudy.services.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UsersController {

    @Autowired
    private UserService userService;

    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity<Iterable<User>> index() {
        return new ResponseEntity<>(userService.index(), HttpStatus.OK);
    }

    @GetMapping(value = "/getuser/{id}")
    public ResponseEntity<User> get(@PathVariable Long id) {
        return new ResponseEntity<>(userService.show(id), HttpStatus.OK);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseEntity<User> create(@RequestBody User user) {
        return new ResponseEntity<>(userService.create(user), HttpStatus.CREATED);
    }

//    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
//    public void delete(@PathVariable Long id) {
//        //need to check for children records before deleting
//        userRepository.deleteById(id);
//    }
//
//    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
//    public User update(@PathVariable Long id, @RequestBody User user) {
//        User existingUser = userRepository.getOne(id);
//        BeanUtils.copyProperties(user, existingUser, "id");
//        return userRepository.saveAndFlush(existingUser);
//    }
}
