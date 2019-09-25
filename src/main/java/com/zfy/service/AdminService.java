package com.zfy.service;

import com.zfy.entity.Admin;

public interface AdminService {
    void  register(Admin admin);

    Admin login(Admin admin);
}
