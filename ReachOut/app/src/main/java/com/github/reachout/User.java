package com.github.reachout;

/**
 * Created by Yash on 4/2/2016.
 */
public class User {

    private String email;
    private String password;
    private int zipCode;

    public User(String email, String password, int zipCode) {
        this.email = email;
        this.password = password;
        this.zipCode = zipCode;
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

    public boolean equals()
}
