package com.zfy.service;

import com.zfy.dao.AdminDAO;
import com.zfy.entity.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminDAO  adminDAO;
    @Override
    public void register(Admin admin) {
        adminDAO.save(admin);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS ,readOnly = true)
     public Admin login(Admin admin) {
        Admin a = adminDAO.querybyusername(admin.getUsername());

        if (a == null)
            throw new RuntimeException("没有这个管理员");
        if (!a.getPassword().equals(admin.getPassword()))
            throw new RuntimeException("密码错误");
        return a;
     }
}
