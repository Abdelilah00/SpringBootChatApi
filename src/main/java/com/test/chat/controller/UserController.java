package com.test.chat.controller;

import com.test.chat.storage.UserStorage;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@CrossOrigin
public class UserController {
    @GetMapping("/registration/{userName}")
    public ResponseEntity<Void> register(@PathVariable String userName) {
        if (userName.isBlank() || userName.equals("'undefined"))
            return ResponseEntity.badRequest().build();


        System.out.println("handling regiter user request: " + userName);
        try {
            UserStorage.getInstance().setUser(userName);
        } catch (Exception ex) {
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok().build();
    }

    @GetMapping("/fetchAllUsers")
    private Set<String> fetchAll() {
        return UserStorage.getInstance().getUsers();
    }
}
