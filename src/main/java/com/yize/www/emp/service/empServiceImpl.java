package com.yize.www.emp.service;

import com.yize.www.dept.pojo.DeptModel;
import com.yize.www.emp.mapper.EmpModelMapper;
import com.yize.www.emp.pojo.EmpModelExample;
import com.yize.www.emp.pojo.EmpModelExample.Criteria;
import com.yize.www.emp.pojo.EmpQueryModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class empServiceImpl implements empService{
    @Autowired
    private EmpModelMapper empModelMapper;

    @Override
    public Integer getCount(EmpQueryModel eqm) {
        EmpModelExample example = new EmpModelExample();
        return empModelMapper.countByExample(example);
    }

    @Override
    public List<DeptModel> getAll(EmpQueryModel eqm) {
        return null;
    }
}
