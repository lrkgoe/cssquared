package com.github.reachout;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yash on 4/2/2016.
 */
public class User {

    private String email;
    private String password;
    private int zipCode;
    private List<Event> eventsCreated;
    private List<Event> eventsFollowed;


    public User(String email, String password, int zipCode) {
        this.email = email;
        this.password = password;
        this.zipCode = zipCode;
        eventsCreated = new ArrayList<>();
        eventsFollowed = new ArrayList<>();
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    public boolean equals(Object o) {
        if(o != null && o instanceof User) {
            User compare = (User) o;
            return this.getEmail().equals(compare.getEmail())
                    && this.getPassword().equals(compare.getPassword());
        }
        return false;

    }

    public void addNewEvent(Event e) {
        //TODO: don't add duplicate && return boolean
        eventsCreated.add(e);
    }

    public void addFollowedEvent(Event e) {
        //TODO: don't add duplicate && return boolean
        eventsFollowed.add(e);
    }
}
