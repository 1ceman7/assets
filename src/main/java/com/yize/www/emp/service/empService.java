package com.yize.www.emp.service;

import com.yize.www.emp.pojo.EmpModel;
import com.yize.www.emp.pojo.EmpQueryModel;
import com.yize.www.utils.PageModel;

import java.util.List;

public interface empService {
    Integer getCount(EmpQueryModel eqm);

    List<EmpModel> getAll(EmpQueryModel eqm, PageModel pageModel);

    void del(Integer id);

    Integer getDeptCount(Integer id);
}
