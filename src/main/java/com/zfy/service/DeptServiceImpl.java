package com.zfy.service;

import com.zfy.dao.DeptDAO;
import com.zfy.entity.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
@Service
@Transactional
public class DeptServiceImpl implements DeptService {
    @Autowired
    private DeptDAO deptDAO;
    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<Dept> showAll() {
        List<Dept> depts = deptDAO.selectAll();
        return depts;
    }

    @Override
    public void adddept(Dept dept) {
        deptDAO.adddept(dept);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public Dept selectbyid(Integer id) {
        Dept dept = deptDAO.selectbyid(id);
        return dept;
    }

    @Override
    public void update(Dept dept) {
        deptDAO.update(dept);
    }

    @Override
    @Transactional (propagation = Propagation.SUPPORTS,readOnly = true)
    public List<Dept> selectDepname() {
        List<Dept> list= deptDAO.selectDepname();
        return list;
    }
}
