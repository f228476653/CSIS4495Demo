package com.example.demo4495.models;

import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class MemberAccount implements Serializable {
    private String email;
    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}