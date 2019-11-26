package com.facai.repository;

import com.facai.entity.Admin;

public interface AdminRepository {
    public Admin login(String username,String password);
}
