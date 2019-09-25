package com.zfy.dao;

import com.zfy.entity.Dept;

import java.util.List;

public interface DeptDAO {

    List<Dept> selectAll();

    void adddept(Dept dept);

    Dept selectbyid(Integer id);

    void update(Dept dept);

    List<Dept> selectDepname();
}
