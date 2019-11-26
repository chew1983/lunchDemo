package com.facai.repository;

import com.facai.entity.User;

import java.util.List;

public interface UserRepository {
    public List<User> findAll(int index, int limit);
    public int count();
    public void save(User user);
    public void deleteById(long id);
    public User findById(Long id);
    public void update(User user);
}
