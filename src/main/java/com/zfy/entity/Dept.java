package com.zfy.entity;

public class Dept {
    private Integer id;
    private String department_num;
    private String department_name;

    public Dept() {
    }

    public Dept(Integer id, String department_num, String department_name) {
        this.id = id;
        this.department_num = department_num;
        this.department_name = department_name;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "id=" + id +
                ", department_num='" + department_num + '\'' +
                ", department_name='" + department_name + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDepartment_num() {
        return department_num;
    }

    public void setDepartment_num(String department_num) {
        this.department_num = department_num;
    }

    public String getDepartment_name() {
        return department_name;
    }

    public void setDepartment_name(String department_name) {
        this.department_name = department_name;
    }
}
