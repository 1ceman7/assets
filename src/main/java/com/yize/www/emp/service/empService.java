package com.yize.www.emp.service;

import com.yize.www.dept.pojo.DeptModel;
import com.yize.www.emp.pojo.EmpQueryModel;

import java.util.List;

public interface empService {
    Integer getCount(EmpQueryModel eqm);

    List<DeptModel> getAll(EmpQueryModel eqm);

}
