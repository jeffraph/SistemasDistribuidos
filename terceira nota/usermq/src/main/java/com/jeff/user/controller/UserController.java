package com.jeff.user.controller;

import com.jeff.user.repositories.UserRepository;
import com.jeff.user.models.UserModel;
import com.jeff.user.service.Sender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    UserRepository repository;

    Sender sender;

    @Autowired
    public UserController(UserRepository repository, Sender sender) {
        this.repository = repository;
        this.sender = sender;
    }

    @PostMapping("/save")
    public UserModel saveUser(@RequestBody UserModel userModel) {
        sender.send(userModel.getMail());
        return repository.save(userModel);
    }

}
