package com.facai.entity;

import lombok.Data;

@Data
public class Admin {
    private long id;
    private String username;
    private String password;

    public void setId(long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
