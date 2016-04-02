package com.github.reachout;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Heather on 4/2/2016.
 */
public class UserManager {
    private static ArrayList<User> userList;

    public UserManager() {

    }

    public void add(User user) {
        userList.add(user);
    }

    public User getUser(String email) {
        for (User u : userList) {
            if (u != null && u.getEmail().equals(email)) {
                return u;
            }
        }
        return null;
    }

    public boolean contains(User user) {
        return userList.contains(user);
    }
}
