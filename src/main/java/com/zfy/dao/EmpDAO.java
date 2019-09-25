package com.zfy.dao;

import com.zfy.entity.Emp;

import java.util.List;

public interface EmpDAO {

    List<Emp> selectAll(Integer did);

    void addemp(Emp emp);

    Emp selectbyid(Integer id);

    void update(Emp emp);

    void delete(String id);
}
