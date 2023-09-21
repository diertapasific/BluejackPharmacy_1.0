package com.example.mcs_assignment_lab;

import java.util.ArrayList;

public class dataBaseUser {
    private Integer userID;
    private String name;
    private String email;
    private String password;
    private String phoneNumber;


    public dataBaseUser(Integer userID, String name, String email, String password, String phoneNumber) {
        this.userID = userID;
        this.name = name;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
    }

    public Integer getUserID() {
        return userID;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    static ArrayList<dataBaseUser> usersList = new ArrayList<>();
}