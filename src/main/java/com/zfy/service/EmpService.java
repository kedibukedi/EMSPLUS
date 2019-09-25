package com.zfy.service;

import com.zfy.entity.Emp;

import java.util.List;

public interface EmpService {

    List<Emp> showAll(Integer did);

    void addemp(Emp emp);

    Emp selectbyid(Integer id);

    void update(Emp emp);

    void delete(String id);
}
