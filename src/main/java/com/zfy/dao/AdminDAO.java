package com.zfy.dao;

import com.zfy.entity.Admin;

public interface AdminDAO {
    void save(Admin admin);

    Admin querybyusername(String username);
}
