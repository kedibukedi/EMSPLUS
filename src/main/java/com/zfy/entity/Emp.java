package com.zfy.entity;

public class Emp {
    private Integer id;
    private String headlike;
    private String empname;
    private Integer age;
    private Double salary;
    private Integer did;
    private Dept  dept;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHeadlike() {
        return headlike;
    }

    public void setHeadlike(String headlike) {
        this.headlike = headlike;
    }

    public String getEmpname() {
        return empname;
    }

    public void setEmpname(String empname) {
        this.empname = empname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Integer getDid() {
        return did;
    }

    public void setDid(Integer did) {
        this.did = did;
    }

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    public Emp(Integer id, String headlike, String empname, Integer age, Double salary, Integer did, Dept dept) {
        this.id = id;
        this.headlike = headlike;
        this.empname = empname;
        this.age = age;
        this.salary = salary;
        this.did = did;
        this.dept = dept;
    }

    public Emp() {
    }

    @Override
    public String toString() {
        return "Emp{" +
                "id=" + id +
                ", headlike='" + headlike + '\'' +
                ", empname='" + empname + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", did=" + did +
                ", dept=" + dept +
                '}';
    }
}
