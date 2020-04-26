package com.yize.www.dept.pojo;

import com.yize.www.emp.pojo.EmpModel;

import java.util.List;

public class DeptModel {
    private Integer id;

    private String name;

    private String tel;
    //对订单的一对多
    private List<EmpModel> EmpList;

    public List<EmpModel> getEmpList() {
        return EmpList;
    }

    public void setEmpList(List<EmpModel> empList) {
        EmpList = empList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
    }

    @Override
    public String toString() {
        return "DeptModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", tel='" + tel + '\'' +
                '}';
    }
}