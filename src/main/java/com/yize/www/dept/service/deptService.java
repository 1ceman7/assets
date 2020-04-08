package com.yize.www.dept.service;

import com.yize.www.dept.pojo.DeptModel;
import com.yize.www.dept.pojo.DeptQueryModel;
import com.yize.www.utils.PageModel;

import java.util.List;

public interface deptService {
    Integer getCount(DeptQueryModel gqm);

    List<DeptModel> getAll(DeptQueryModel gqm, PageModel pageModel);
}
