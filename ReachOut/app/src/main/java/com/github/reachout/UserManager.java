package com.github.reachout;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Mock db for Users
 */
public class UserManager {
    private static ArrayList<User> userList;

    public UserManager() {
        userList = new ArrayList<>();
    }

    public void add(User user) {
        userList.add(user);
    }

    public User getUser(User user) {
        for (int i = 0; i < userList.size(); i++) {
            if (userList.get(i).equals(user)) {
                return userList.get(i);
            }
        }
        return null;
    }

    public boolean contains(User user) {
        return userList.contains(user);
    }
}
