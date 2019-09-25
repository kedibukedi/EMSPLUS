package com.zfy.service;

import com.zfy.dao.EmpDAO;
import com.zfy.entity.Emp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class EmpServiceImpl implements EmpService {
    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public Emp selectbyid(Integer id) {
        Emp emp=empDAO.selectbyid(id);
        return emp;
    }

    @Override
    public void update(Emp emp) {
        empDAO.update(emp);
    }

    @Override
    public void delete(String id) {
        empDAO.delete(id);
    }

    @Autowired
    private EmpDAO empDAO;
    @Override
    @Transactional (propagation = Propagation.SUPPORTS,readOnly = true)
    public List<Emp> showAll(Integer did) {
       List<Emp> list = empDAO.selectAll(did);
        return list;
    }

    @Override
    public void addemp(Emp emp) {
        empDAO.addemp(emp);
    }
}
