package com.test.chat.storage;

import lombok.Getter;

import java.util.HashSet;
import java.util.Set;

public class UserStorage {
    public static UserStorage instance;
    @Getter
    private Set<String> users = new HashSet<>();

    public static synchronized UserStorage getInstance() {
        if (instance == null)
            instance = new UserStorage();
        return instance;
    }

    public void setUser(String userName) throws Exception {
        if (users.contains(userName))
            throw new Exception("User already exist with login : " + userName);
        users.add(userName);
    }

}
