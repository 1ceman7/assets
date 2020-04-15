package com.yize.www.emp.pojo;

import com.yize.www.dept.pojo.DeptModel;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class EmpModel {
    //数据字典
    public static final Integer CUSTOMER_GENDER_MAN = 1;
    public static final Integer CUSTOMER_GENDER_WOMAN = 0;

    public static final String CUSTOMER_GENDER_MAN_VIEW = "男";
    public static final String CUSTOMER_GENDER_WOMAN_VIEW = "女";

    public static final Map<Integer, String> GENDER_MAP = new HashMap<Integer, String>();
    static{
        GENDER_MAP.put(CUSTOMER_GENDER_MAN, CUSTOMER_GENDER_MAN_VIEW);
        GENDER_MAP.put(CUSTOMER_GENDER_WOMAN, CUSTOMER_GENDER_WOMAN_VIEW);
    }
    private Integer id;

    private String name;

    private String tel;

    private Integer gender;

    private String email;

    private Date intime;

    private Date outtime;

    private Integer deptid;

    private DeptModel dm;

    public DeptModel getDm() {
        return dm;
    }

    public void setDm(DeptModel dm) {
        this.dm = dm;
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

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public Date getIntime() {
        return intime;
    }

    public void setIntime(Date intime) {
        this.intime = intime;
    }

    public Date getOuttime() {
        return outtime;
    }

    public void setOuttime(Date outtime) {
        this.outtime = outtime;
    }

    public Integer getDeptid() {
        return deptid;
    }

    public void setDeptid(Integer deptid) {
        this.deptid = deptid;
    }
}