package com.yize.www.emp.service;

import com.yize.www.emp.mapper.EmpModelMapper;
import com.yize.www.emp.pojo.EmpModel;
import com.yize.www.emp.pojo.EmpModelExample;
import com.yize.www.emp.pojo.EmpModelExample.Criteria;
import com.yize.www.emp.pojo.EmpQueryModel;
import com.yize.www.utils.PageModel;
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
    public List<EmpModel> getAll(EmpQueryModel eqm, PageModel pageModel) {
        EmpModelExample example = new EmpModelExample();
        example.setStart(pageModel.getStart());
        example.setLimit(pageModel.getPageCount());
        Criteria criteria = example.createCriteria();

        List<EmpModel> empAndDept = empModelMapper.getEmpAndDept(example);
        empAndDept.forEach(System.out::println);

        return empAndDept;
    }
}
