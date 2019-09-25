package com.zfy.service;

import com.zfy.entity.Dept;

import java.util.List;

public interface DeptService {
    List<Dept> showAll();

    void adddept(Dept dept);

    Dept selectbyid(Integer id);

    void update(Dept dept);

    List<Dept> selectDepname();
}
