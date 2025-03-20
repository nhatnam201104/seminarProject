package com.example.frontend.models.user;

import androidx.annotation.NonNull;

public class User {
    private int id;
    private String name;
    private String username;
    private String email;
    private Address address;
    private String phone;
    private String website;
    private Company company;

    // Getter and Setter methods for all fields

    public String getName() {
        return name;
    }

    @NonNull
    public String toString() {
        return id + " " + name + " " + username + " " + email + " " + phone + " " + website;
    }
}
