package com.design.splitwise_lld;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class UserService {
    private Map<String, User> users;

    public UserService() {
        this.users = new HashMap<>();
    }

    public User createUser(String name, String email, String phone) {
        String userId = UUID.randomUUID().toString();
        User user = new User(userId, name, email, phone);
        users.put(userId, user);
        return user;
    }

    public User getUser(String userId) {
        return users.get(userId);
    }

    public Map<String, User> getUsers() {
        return users;
    }
}
