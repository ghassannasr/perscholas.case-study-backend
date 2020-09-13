package com.perscholas.casestudy.services;

import com.perscholas.casestudy.models.User;
import com.perscholas.casestudy.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    private UserRepository repository;

    @Autowired
    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public Iterable<User> index() {
        return repository.findAll();
    }

    public User show(Long id) {
        return repository.findById(id).get();
    }

    public User create(User user) {
        return repository.save(user);
    }

    public User update(Long id, User newUserData) {
        User originalUser = repository.findById(id).get();
        originalUser.setFirstName(newUserData.getFirstName());
        originalUser.setLastName(newUserData.getLastName());
        originalUser.setType(newUserData.getType());
        return repository.save(originalUser);
    }

    public Boolean delete(Long id) {
        repository.deleteById(id);
        return true;
    }
}

