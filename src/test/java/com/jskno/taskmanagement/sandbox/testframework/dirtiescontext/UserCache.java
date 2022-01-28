package com.jskno.taskmanagement.sandbox.testframework.dirtiescontext;

import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class UserCache {

    private Set<User> userList = new HashSet<>();

    public Set<User> getUserList() {
        return userList;
    }

    public boolean addUser(User user) {
        return userList.add(user);
    }

    public void printUserList(String message) {
        System.out.println(message + ": " + userList.stream().map(User::toString).collect(Collectors.joining()));
    }
}
