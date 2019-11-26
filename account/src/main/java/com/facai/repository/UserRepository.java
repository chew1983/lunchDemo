package com.facai.repository;

import com.facai.entity.User;

public interface UserRepository {
    public User login(String username, String password);
}
